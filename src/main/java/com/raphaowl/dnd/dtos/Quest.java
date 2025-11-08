package com.raphaowl.dnd.dtos;

import java.util.List;

import com.raphaowl.dnd.enums.MonsterNameEnum;
import com.raphaowl.dnd.enums.QuestDifficulty;
import com.raphaowl.dnd.enums.QuestEnum;
import com.raphaowl.dnd.enums.QuestType;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Quest {
    private QuestEnum id;
    private QuestDifficulty difficulty;
    private QuestType type;
    private List<Item> reward;
    private List<MonsterNameEnum> suggestedMonsters;
    private List<String> factionsInvolved;
    private List<String> keyNPCs;
}
