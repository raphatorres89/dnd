package com.raphaowl.dnd.enums;

import java.util.Random;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TavernOwner {
    GROG("Grog Ironhand", "Ex-Adventurer, retired due to injury"),
    ELARA("Elara Brightwood", "Always speaks in riddles"),
    FENRIS("Fenris Stonebeard", "Obsessed with cleaning and order"),
    GRISELDA("Griselda Blackwood", "Knows every rumor in the city"),
    SILAS("Silas the Silent", "Never speaks, communicates only with gestures"),
    MAYA("Maya Swiftfoot", "Secretly a retired spy for the King"),
    BARTHOLOMEW("Bartholomew 'Bart' Tumble", "Terrible memory, often mixes up orders"),
    ZARA("Zara Fireforge", "A proud Dwarf, insists on using only dwarven currency"),
    KAELEN("Kaelen Moonwhisper", "An Elf who is constantly bored"),
    DREX("Drex the Honest", "Will never lie, even if it hurts business or feelings");

    private static final Random random = new Random();
    private static final TavernOwner[] VALUES = values();

    private final String name;
    private final String personalityTrait;

    public static TavernOwner getRandomName() {
        return VALUES[random.nextInt(VALUES.length)];
    }
}
