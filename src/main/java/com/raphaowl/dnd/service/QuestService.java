package com.raphaowl.dnd.service;

import java.util.List;

import com.raphaowl.dnd.dtos.Quest;
import com.raphaowl.dnd.enums.GearEnum;
import com.raphaowl.dnd.enums.MonsterNameEnum;
import com.raphaowl.dnd.enums.QuestDifficulty;
import com.raphaowl.dnd.enums.QuestEnum;
import com.raphaowl.dnd.enums.QuestType;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class QuestService {

    public Quest getQuest() {
        return new Quest(
                QuestEnum.CLEAR_GOBLIN_CAMP,
                "Sussurros nas Minas Antigas",
                "Mineiros desapareceram, sussurros ecoam nos túneis...",
                QuestDifficulty.MEDIUM,
                QuestType.RESCUE,
                "Minas Ruinosas",
                "Mineiros relatam sussurros vindos do subsolo.",
                "Investigar os túneis e descobrir a origem.",
                "A criatura é manipulada por um culto local.",
                List.of(GearEnum.GOLD.toItem(50)),
                "Subterrâneo",
                List.of(MonsterNameEnum.DARKMANTLE, MonsterNameEnum.GRIMLOCK, MonsterNameEnum.CULT_FANATIC),
                List.of("Guilda dos Mineradores", "Culto da Pedra Sombria"),
                List.of("Mestre da Guilda, Sacerdote misterioso")
        );
    }

    public Quest findById(String id) {
        return new Quest(
                QuestEnum.valueOf(id),
                "Sussurros nas Minas Antigas " + id,
                "Mineiros desapareceram, sussurros ecoam nos túneis...",
                QuestDifficulty.MEDIUM,
                QuestType.RESCUE,
                "Minas Ruinosas",
                "Mineiros relatam sussurros vindos do subsolo.",
                "Investigar os túneis e descobrir a origem.",
                "A criatura é manipulada por um culto local.",
                List.of(GearEnum.GOLD.toItem(50)),
                "Subterrâneo",
                List.of(MonsterNameEnum.DARKMANTLE, MonsterNameEnum.GRIMLOCK, MonsterNameEnum.CULT_FANATIC),
                List.of("Guilda dos Mineradores", "Culto da Pedra Sombria"),
                List.of("Mestre da Guilda, Sacerdote misterioso")
        );
    }
}
