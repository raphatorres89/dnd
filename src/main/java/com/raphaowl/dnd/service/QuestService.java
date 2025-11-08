package com.raphaowl.dnd.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Stream;

import com.raphaowl.dnd.dtos.Item;
import com.raphaowl.dnd.dtos.Quest;
import com.raphaowl.dnd.enums.GearEnum;
import com.raphaowl.dnd.enums.MonsterNameEnum;
import com.raphaowl.dnd.enums.QuestEnum;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class QuestService {

    private final MessageSource messageSource;

    public Quest getQuest() {
        return findById(QuestEnum.getRandomName().name());
    }

    public Quest findById(String id) {
        QuestEnum questEnum = QuestEnum.valueOf(id);
        String enemies = getMessage( id, "enemies");
        String rewards = getMessage( id, "rewards");
        String factions = getMessage( id, "factions");
        String npcs = getMessage( id, "npcs");
        List<String> factionList = splitList(factions);
        List<String> npcList = splitList(npcs);

        List<Item> rewardList = new ArrayList<>();
        Map<String, Integer> stringIntegerMap = parseRewards(rewards);
        for (Map.Entry<String, Integer> entry : stringIntegerMap.entrySet()) {
            rewardList.add(GearEnum.valueOf(entry.getKey()).toItem(entry.getValue()));
        }

        List<MonsterNameEnum> monsterList = !enemies.isEmpty() ?
                Stream.of(enemies.split(","))
                    .map(String::trim)
                    .map(MonsterNameEnum::valueOf)
                    .toList()
                : List.of();

        return new Quest(questEnum,
                         questEnum.getDifficulty(),
                         questEnum.getType(),
                         rewardList,
                         monsterList,
                         factionList,
                         npcList
        );
    }

    public static Map<String, Integer> parseRewards(String rewardStr) {
        Map<String, Integer> rewards = new HashMap<>();
        for (String part : rewardStr.split(",")) {
            part = part.trim();
            if (part.matches("([A-Z_]+)\\[(\\d+)]")) {
                String name = part.replaceAll("\\[(\\d+)]", "");
                int qty = Integer.parseInt(part.replaceAll(".*\\[(\\d+)]", "$1"));
                rewards.put(name, qty);
            }
        }
        return rewards;
    }

    private static List<String> splitList(String factions) {
        return !factions.isEmpty() ? Stream.of(factions.split(",")).map(String::trim).toList() : List.of();
    }

    private String getMessage(String id, String suffix) {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("tavern.quest." + id + "." + suffix, null, locale);
    }
}
