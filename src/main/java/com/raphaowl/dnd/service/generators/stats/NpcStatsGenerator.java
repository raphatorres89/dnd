package com.raphaowl.dnd.service.generators.stats;

import com.raphaowl.dnd.dtos.NpcStats;
import com.raphaowl.dnd.enums.AbilityScoreEnum;
import com.raphaowl.dnd.enums.ClassEnum;
import com.raphaowl.dnd.enums.RaceEnum;
import org.springframework.stereotype.Component;

import java.util.EnumMap;
import java.util.Map;
import java.util.Random;

@Component
public class NpcStatsGenerator {

    private final Random random = new Random();

    public NpcStats generateStats(ClassEnum clazz, RaceEnum race, double challengeRating) {
        Map<AbilityScoreEnum, Integer> attributes = generateBaseAttributes(challengeRating);
        applyClassPriority(attributes, clazz);
        applyRaceBonus(attributes, race);

        int constitutionModifier = (attributes.get(AbilityScoreEnum.CON) - 10) / 2;
        int hitPoints = calculateHitPoints(clazz, constitutionModifier, challengeRating);

        return new NpcStats(attributes, hitPoints);
    }

    private Map<AbilityScoreEnum, Integer> generateBaseAttributes(double cr) {
        Map<AbilityScoreEnum, Integer> attrs = new EnumMap<>(AbilityScoreEnum.class);

        int base = switch ((int) Math.ceil(cr)) {
            case 0, 1 -> 10;
            case 2, 3, 4 -> 12;
            case 5, 6, 7, 8 -> 13;
            case 9, 10, 11, 12 -> 15;
            default -> 16;
        };

        for (AbilityScoreEnum ability : AbilityScoreEnum.values()) {
            attrs.put(ability, base + random.nextInt(3) - 1);
        }

        return attrs;
    }

    private void applyClassPriority(Map<AbilityScoreEnum, Integer> attrs, ClassEnum clazz) {
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

        attrs.computeIfPresent(primary, (k, v) -> v + 2);
        attrs.computeIfPresent(secondary, (k, v) -> v + 1);
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

    private int calculateHitPoints(ClassEnum clazz, int conMod, double cr) {
        int hitDie = switch (clazz) {
            case WIZARD, SORCERER -> 6;
            case ROGUE, BARD, CLERIC, DRUID, RANGER -> 8;
            case FIGHTER, PALADIN -> 10;
            case BARBARIAN -> 12;
            default -> 8;
        };

        int avg = (hitDie / 2) + 1;
        int levelApprox = (int) Math.ceil(cr);
        return (avg + conMod) * Math.max(1, levelApprox);
    }
}
