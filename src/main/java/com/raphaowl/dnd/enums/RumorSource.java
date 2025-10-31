package com.raphaowl.dnd.enums;

import java.util.Random;

public enum RumorSource {
    DRUNKEN_FARMER,
    QUIET_MERCENARY,
    ELDERLY_BARMAID,
    TRAVELING_BARD,
    GOSSIPY_MERCHANT,
    LOCAL_PRIEST,
    CITY_GUARD,
    RIVER_FISHERMAN;

    private static final Random random = new Random();
    private static final RumorSource[] VALUES = values();

    public static RumorSource getRandomName() {
        return VALUES[random.nextInt(VALUES.length)];
    }
}
