package com.raphaowl.dnd.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MonsterSubtypeEnum {
    // Enum                           // Valor Original (EN)     // Tradução (PT)
    ANY_RACE("any race", "qualquer raça"),
    DEMON("demon", "demônio"),
    DEVIL("devil", "diabo"),
    GOBLINOID("goblinoid", "goblinóide"),
    GNOME("gnome", "gnomo"),
    DWARF("dwarf", "anão"),
    ELF("elf", "elfo"),
    SHAPECHANGER("shapechanger", "metamorfo"),
    GNOLL("gnoll", "gnoll"),
    GRIMLOCK("grimlock", "grimlock"),
    HUMAN("human", "humano"),
    TITAN("titan", "titã"),
    KOBOLD("kobold", "kobold"),
    LIZARDFOLK("lizardfolk", "povo-lagarto"),
    MERFOLK("merfolk", "povo-peixe"), // Tradução comum para D&D 'merfolk'
    ORC("orc", "orc"),
    SAHUAGIN("sahuagin", "sahuagin");

    private final String name;
    private final String ptName;

    public static MonsterSubtypeEnum fromName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Subtype name cannot be null.");
        }
        for (MonsterSubtypeEnum subtype : MonsterSubtypeEnum.values()) {
            if (subtype.name.equalsIgnoreCase(name)) {
                return subtype;
            }
        }
        throw new IllegalArgumentException("No enum constant for subtype: " + name);
    }
}
