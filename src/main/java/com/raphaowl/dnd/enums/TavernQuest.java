package com.raphaowl.dnd.enums;

import java.util.Random;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TavernQuest {
    // Missões de Baixo Nível (Fácil de Encontrar)
    RAT_INFESTATION(QuestDifficulty.LOW, QuestType.HUNT),
    DELIVER_PACKAGE(QuestDifficulty.LOW, QuestType.FETCH),
    RECOVER_STOLEN_ITEM(QuestDifficulty.LOW, QuestType.FETCH),
    ESCORTE_MERCHANT(QuestDifficulty.LOW, QuestType.ESCORT),
    DEAL_WITH_BANDITS(QuestDifficulty.LOW, QuestType.HUNT),

    // Missões de Nível Médio
    INVESTIGATE_HAUNTING(QuestDifficulty.MEDIUM, QuestType.INVESTIGATE),
    CLEAR_GOBLIN_CAMP(QuestDifficulty.MEDIUM, QuestType.HUNT),
    RESCUE_CAPTIVE(QuestDifficulty.MEDIUM, QuestType.RESCUE),
    FIND_MISSING_PERSON(QuestDifficulty.MEDIUM, QuestType.RESCUE),
    HUNT_LOCAL_MONSTER(QuestDifficulty.MEDIUM, QuestType.HUNT),

    // Missões Incomuns / Hooks de Plot
    MAP_FRAGMENT(QuestDifficulty.MEDIUM, QuestType.EXPLORE),
    GUARD_ARTIFACT(QuestDifficulty.MEDIUM, QuestType.DEFEND),
    TRUCE_NEGOTIATION(QuestDifficulty.MEDIUM, QuestType.SOCIAL);

    private static final Random random = new Random();
    private static final TavernQuest[] VALUES = values();

    private final QuestDifficulty difficulty;
    private final QuestType type;

    public static TavernQuest getRandomName() {
        return VALUES[random.nextInt(VALUES.length)];
    }
}
