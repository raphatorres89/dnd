package com.raphaowl.dnd.enums;

import java.util.Random;

public enum TavernSpecialty {
    // Bebidas
    BEST_MEAD,
    DARK_DWARF_ALE,
    ELVEN_WINE,
    ILLEGAL_WHISKEY,
    HONEY_AND_SPICE_WINE,

    // Comida
    DAILY_STEW,
    GIANT_BOAR_ROAST,
    MUSHROOM_PIE,
    FISH_AND_CHIPS,
    EXOTIC_SPICED_MEAT,

    // Outros
    BEST_SERVICE,
    SECRET_ENTRANCE,
    AMAZING_BARD;

    private static final Random random = new Random();
    private static final TavernSpecialty[] VALUES = values();

    public static TavernSpecialty getRandomName() {
        return VALUES[random.nextInt(VALUES.length)];
    }
}
