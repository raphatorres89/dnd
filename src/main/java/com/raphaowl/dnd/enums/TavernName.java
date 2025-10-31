package com.raphaowl.dnd.enums;

import java.util.Random;

public enum TavernName {
    // A. Animals & Monsters
    LAUGHING_LION,
    BLIND_OWL,
    FAITHFUL_HOUND,
    LUCKY_GECKO,
    CAT_OF_NINE_TAILS,
    SLEEPING_GRIFFIN,
    THREE_HEADED_HYDRA,
    WISE_SERPENT,
    DRUNKEN_BEAR,
    BAT_IN_THE_BELL,
    SPIDERS_AND_ADVENTURERS,
    BOUNCING_RABBIT,
    BRONZE_DRAGON,
    SMILING_GARGOYLE,
    FALCON_ON_THE_ROCK,

    // B. Objects & Commerce
    LEAKY_BARREL,
    SMOKING_CAULDRON,
    WORN_GOLD_COIN,
    BROKEN_BLADE,
    HAMMER_AND_CUP,
    ROAD_CANDLE,
    PEACE_PIPE,
    TORN_CLOAK,
    SHUFFLED_CARDS,
    GRANDMAS_COOKBOOK,
    RUSTY_SHIELD,
    TRAVELERS_ANCHOR,
    TORN_MAP,
    KEY_AND_CHALICE,
    FALLEN_STAR,

    // C. Fantasy & Places
    ELVEN_RETREAT,
    SILENT_GROVE,
    DREAMS_HARBOR,
    MOUNTAIN_MIST,
    OATH_STONES,
    BARDS_SANCTUARY,
    MOON_CROSSROADS,
    WISHING_WELL,
    LAST_POST,
    SECRET_PASSAGE,

    // D. People & Adjectives
    TIRED_KNIGHT,
    GROGS_SONG,
    HEROES_RETURN,
    FRIENDLY_PROSE,
    GRUMPY_BARTENDERS_INN,
    DUCHESS_DANCE,
    CAPTAINS_TOAST,
    ENIGMATIC_MAIDEN,
    OLD_MERCHANT,
    FARMERS_SECRET;

    private static final Random random = new Random();
    private static final TavernName[] VALUES = values();

    public static TavernName getRandomName() {
        return VALUES[random.nextInt(VALUES.length)];
    }
}
