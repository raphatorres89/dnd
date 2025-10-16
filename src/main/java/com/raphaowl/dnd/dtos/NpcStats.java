package com.raphaowl.dnd.dtos;

import java.util.Map;

import com.raphaowl.dnd.enums.AbilityScoreEnum;

public record NpcStats(
        Map<AbilityScoreEnum, Integer> attributes,
        int hitPoints
) {}
