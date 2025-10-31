package com.raphaowl.dnd.enums;

import java.util.Random;

public enum TavernRumor {
    LOCAL_LORD_CORRUPT,
    SECRET_PASSAGE,
    STRANGE_CULT_SIGHTED,
    OLD_MINE_ACTIVE,
    GHOST_IN_THE_WELL,

    // Rumores Globais (Sobre o Mundo/Plot Principal)
    KING_IS_ILL,
    DRAGON_AWAKENS,
    LOST_RELIC_FOUND,
    GUILD_WAR_BEGINS,
    NEW_EVIL_RISES,

    // Rumores Engraçados/Aleatórios
    TAVERN_GHOST,
    BARD_IS_VAMPIRE,
    TREASURE_MAP_PIECE,

    // A. Rumores de AVENTURA/COMBATE (Ganchos Imediatos)
    GOBLIN_RAID,
    SKELETON_ARMY,
    LOST_RELIC_MAP,
    MINE_MONSTER,
    BANDIT_HIDEOUT,
    WEREWOLF_HUNTER,
    GIANT_SPIDER_WEB,
    CULT_MEETING,
    ABANDONED_TOWER,
    DRAGON_SIGHTING,

    // B. Rumores LOCAIS/INVESTIGAÇÃO (Contexto da Cidade)
    CORRUPT_GUARD,
    MAYOR_POISONED,
    WATER_WELL_SICKNESS,
    MERCHANT_SCAM,
    CHILDREN_VANISHED,
    FORBIDDEN_BOOKS,
    CRYPT_OPENED,
    FARMER_TREASURE,
    GOSSIP_MONK,
    MISSING_GUARD_PATROL,

    // C. Rumores de MISTÉRIO/MUNDO (Grandes Ganchos de Plot)
    ANCIENT_GOD_WOKE,
    MAGIC_FAILURES,
    TIME_STOPPED_FOREST,
    PROPHET_ARRIVED,
    FALLEN_STAR_GLOWS,
    DRUIDS_MOURNING,
    NEW_RACE_SIGHTED,
    KING_IS_IMPOSTER,
    GHOST_SHIP_APPEARED,
    SECRET_ORDER_ACTIVATED;

    private static final Random random = new Random();
    private static final TavernRumor[] VALUES = values();

    public static TavernRumor getRandomName() {
        return VALUES[random.nextInt(VALUES.length)];
    }
}
