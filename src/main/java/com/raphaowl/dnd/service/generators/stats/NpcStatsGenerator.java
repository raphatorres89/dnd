package com.raphaowl.dnd.service.generators.stats;

import java.util.*;

import com.raphaowl.dnd.dtos.NpcStats;
import com.raphaowl.dnd.enums.AbilityScoreEnum;
import com.raphaowl.dnd.enums.ClassEnum;
import com.raphaowl.dnd.enums.RaceEnum;

import org.springframework.stereotype.Component;

@Component
public class NpcStatsGenerator {

    private static final int POINT_BUY_TOTAL = 27;
    private static final Map<Integer, Integer> POINT_BUY_COST = Map.of(
            8, 0, 9, 1, 10, 2, 11, 3, 12, 4, 13, 5, 14, 7, 15, 9
    );
    private final Random random = new Random();

    public NpcStats generateStats(ClassEnum clazz, RaceEnum race, Integer npcLevel) {
        Map<AbilityScoreEnum, Integer> attributes = generatePointBuyAttributes(clazz);
        applyRaceBonus(attributes, race);
        return new NpcStats(attributes);
    }

    private Map<AbilityScoreEnum, Integer> generatePointBuyAttributes(ClassEnum clazz) {
        Map<AbilityScoreEnum, Integer> attrs = new EnumMap<>(AbilityScoreEnum.class);
        for (AbilityScoreEnum ability : AbilityScoreEnum.values()) {
            attrs.put(ability, 8);
        }

        // Defina os atributos prioritários
        AbilityScoreEnum primary = switch (clazz) {
            case ROGUE, RANGER -> AbilityScoreEnum.DEX;
            case WIZARD -> AbilityScoreEnum.INT;
            case CLERIC, DRUID -> AbilityScoreEnum.WIS;
            case BARD, SORCERER, WARLOCK -> AbilityScoreEnum.CHA;
            default -> AbilityScoreEnum.STR;
        };

        AbilityScoreEnum secondary = switch (clazz) {
            case BARBARIAN, FIGHTER, PALADIN, RANGER, ROGUE, WIZARD, CLERIC, DRUID, BARD, SORCERER, WARLOCK ->
                    AbilityScoreEnum.CON;
            default -> AbilityScoreEnum.WIS;
        };

        int pointsLeft = POINT_BUY_TOTAL;

        // Atribua 15 ao primário, se possível
        int costPrimary = POINT_BUY_COST.get(15) - POINT_BUY_COST.get(8);
        if (pointsLeft >= costPrimary) {
            attrs.put(primary, 15);
            pointsLeft -= costPrimary;
        }

        // Atribua 14 ao secundário, se possível
        int costSecondary = POINT_BUY_COST.get(14) - POINT_BUY_COST.get(8);
        if (secondary != primary && pointsLeft >= costSecondary) {
            attrs.put(secondary, 14);
            pointsLeft -= costSecondary;
        }

        // Distribua o restante aleatoriamente
        List<AbilityScoreEnum> others = new ArrayList<>(Arrays.asList(AbilityScoreEnum.values()));
        others.remove(primary);
        if (secondary != primary) others.remove(secondary);

        while (pointsLeft > 0 && !others.isEmpty()) {
            Collections.shuffle(others, random);
            boolean spent = false;
            for (AbilityScoreEnum ability : others) {
                int current = attrs.get(ability);
                if (current < 13) { // Limite para não gastar muitos pontos nos atributos menos importantes
                    int cost = POINT_BUY_COST.get(current + 1) - POINT_BUY_COST.get(current);
                    if (pointsLeft >= cost) {
                        attrs.put(ability, current + 1);
                        pointsLeft -= cost;
                        spent = true;
                        break;
                    }
                }
            }
            if (!spent) break;
        }
        return attrs;
    }

    private void applyRaceBonus(Map<AbilityScoreEnum, Integer> attrs, RaceEnum race) {
        if (race == null) return;

        switch (race) {
            case ELF, HALFLING -> attrs.computeIfPresent(AbilityScoreEnum.DEX, (k, v) -> v + 2);
            case DWARF -> attrs.computeIfPresent(AbilityScoreEnum.CON, (k, v) -> v + 2);
            case HUMAN -> attrs.replaceAll((k, v) -> v + 1);
            case HALF_ORC -> {
                attrs.computeIfPresent(AbilityScoreEnum.STR, (k, v) -> v + 2);
                attrs.computeIfPresent(AbilityScoreEnum.CON, (k, v) -> v + 1);
            }
            case HALF_ELF -> {
                attrs.computeIfPresent(AbilityScoreEnum.CHA, (k, v) -> v + 2);
                attrs.computeIfPresent(AbilityScoreEnum.DEX, (k, v) -> v + 1);
                attrs.computeIfPresent(AbilityScoreEnum.WIS, (k, v) -> v + 1);
            }
            default -> {}
        }
    }
}