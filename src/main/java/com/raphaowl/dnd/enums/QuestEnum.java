package com.raphaowl.dnd.enums;

import java.util.Random;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum QuestEnum {
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
    TRUCE_NEGOTIATION(QuestDifficulty.MEDIUM, QuestType.SOCIAL),

    // Novas Quests Dragonlance
    DEFEND_SOLAMNIA_VILLAGE(QuestDifficulty.LOW, QuestType.DEFEND),
    ESCORT_SILVANESTI_REFUGEE(QuestDifficulty.LOW, QuestType.ESCORT),
    FETCH_WAYRETH_COMPONENT(QuestDifficulty.LOW, QuestType.FETCH),
    INVESTIGATE_MISSING_KENDER(QuestDifficulty.LOW, QuestType.INVESTIGATE),
    DELIVER_MESSAGE_TO_QUALINESTI(QuestDifficulty.LOW, QuestType.FETCH),
    CLEAR_HOBGOBLIN_DEN(QuestDifficulty.LOW, QuestType.HUNT),
    RESCUE_PRISONER_FROM_OGRE(QuestDifficulty.LOW, QuestType.RESCUE),
    EXPLORE_OLD_TOWER_OF_HIGH_SORCERY(QuestDifficulty.MEDIUM, QuestType.EXPLORE),
    DEFEND_TEMPLE_OF_PALADINE(QuestDifficulty.MEDIUM, QuestType.DEFEND),
    HUNT_WHITE_DRAGON_WHELP(QuestDifficulty.MEDIUM, QuestType.HUNT),
    ESCORT_MAGE_TO_WAYRETH(QuestDifficulty.MEDIUM, QuestType.ESCORT),
    INVESTIGATE_CURSED_FOREST(QuestDifficulty.MEDIUM, QuestType.INVESTIGATE),
    RESCUE_CHILD_FROM_BLOODED_WOLVES(QuestDifficulty.MEDIUM, QuestType.RESCUE),
    FETCH_HEALING_HERBS_FOR_HEALER(QuestDifficulty.LOW, QuestType.FETCH),
    SOCIALIZE_AT_SOLACE_INN(QuestDifficulty.LOW, QuestType.SOCIAL),
    DEFEND_CARAVAN_FROM_BANDITS(QuestDifficulty.LOW, QuestType.DEFEND),
    HUNT_GIANT_OWL_IN_DARKEN_WOOD(QuestDifficulty.MEDIUM, QuestType.HUNT),
    ESCORT_PRIESTESS_TO_XAK_TSAROTH(QuestDifficulty.MEDIUM, QuestType.ESCORT),
    INVESTIGATE_LOST_ARTIFACT_IN_ICELANDER(QuestDifficulty.MEDIUM, QuestType.INVESTIGATE),
    RESCUE_ELVEN_SCOUTS(QuestDifficulty.MEDIUM, QuestType.RESCUE),
    EXPLORE_RUINS_OF_ITHINCART(QuestDifficulty.MEDIUM, QuestType.EXPLORE),
    DEFEND_TOWN_FROM_BLACK_DRAGON(QuestDifficulty.HIGH, QuestType.DEFEND),
    HUNT_MINOTAUR_GLADIATOR(QuestDifficulty.HIGH, QuestType.HUNT),
    ESCORT_KNIGHT_TO_HIGHCLERIC_TOWER(QuestDifficulty.MEDIUM, QuestType.ESCORT),
    INVESTIGATE_SHADOWS_IN_NERAKA(QuestDifficulty.HIGH, QuestType.INVESTIGATE),
    RESCUE_CAPTIVE_FROM_DARK_QUEEN_CULT(QuestDifficulty.HIGH, QuestType.RESCUE),
    FETCH_DRAGONLANCE_FRAGMENT(QuestDifficulty.HIGH, QuestType.FETCH),
    SOCIALIZE_AT_ELVEN_COURT(QuestDifficulty.MEDIUM, QuestType.SOCIAL),
    EXPLORE_TOMB_OF_HUMA(QuestDifficulty.HIGH, QuestType.EXPLORE);

    private static final Random random = new Random();
    private static final QuestEnum[] VALUES = values();

    private final QuestDifficulty difficulty;
    private final QuestType type;

    public static QuestEnum getRandomName() {
        return VALUES[random.nextInt(VALUES.length)];
    }
}
