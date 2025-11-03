package com.raphaowl.dnd.dtos;

import java.util.List;

import com.raphaowl.dnd.enums.MonsterNameEnum;
import com.raphaowl.dnd.enums.QuestDifficulty;
import com.raphaowl.dnd.enums.QuestType;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Quest {
    private String title;
    private String description;
    private QuestDifficulty difficulty;
    private QuestType type;
    private String location;
    private String hook;
    private String objective;
    private String complication;
    private List<String> reward;
    private String environment;
    private List<MonsterNameEnum> suggestedMonsters;
    private List<String> factionsInvolved;
    private List<String> keyNPCs;
}
