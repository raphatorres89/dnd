package com.raphaowl.dnd.enums;

import java.util.Random;

public enum TavernQuest {
    // Missões de Baixo Nível (Fácil de Encontrar)
    RAT_INFESTATION,
    DELIVER_PACKAGE,
    RECOVER_STOLEN_ITEM,
    ESCORTE_MERCHANT,
    DEAL_WITH_BANDITS,

    // Missões de Nível Médio (Mais Perigosas)
    INVESTIGATE_HAUNTING,
    CLEAR_GOBLIN_CAMP,
    RESCUE_CAPTIVE,
    FIND_MISSING_PERSON,
    HUNT_LOCAL_MONSTER,

    // Missões Incomuns/Intrigantes (Plot Hooks)
    MAP_FRAGMENT,
    GUARD_ARTIFACT,
    TRUCE_NEGOTIATION;

    private static final Random random = new Random();
    private static final TavernQuest[] VALUES = values();

    public static TavernQuest getRandomName() {
        return VALUES[random.nextInt(VALUES.length)];
    }
}
