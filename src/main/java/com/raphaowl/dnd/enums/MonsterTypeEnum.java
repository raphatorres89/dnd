package com.raphaowl.dnd.enums;

import java.util.stream.Stream;

import com.fasterxml.jackson.annotation.JsonCreator;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MonsterTypeEnum {
    ABERRATION("ra ra-eye-monster text-info"),
    HUMANOID("ra ra-player text-secondary"),
    DRAGON("ra ra-dragon text-success"),
    ELEMENTAL("ra ra-burning-embers text-info"),
    MONSTROSITY("ra ra-monster-skull text-secondary"),
    CONSTRUCT("ra ra-player-thunder-struck text-warning"),
    BEAST("ra ra-wolf-head text-secondary"),
    PLANT("ra ra-sprout text-success"),
    FIEND("ra ra-desert-skull text-secondary"),
    OOZE("ra ra-gloop text-danger"),
    FEY("ra ra-fairy text-warning"),
    GIANT("ra ra-muscle-fat text-secondary"),
    CELESTIAL("ra ra-angel-wings text-info"),
    UNDEAD("ra ra-skull text-secondary"),
    SWARM_OF_TINY_BEASTS("ra ra-kaleidoscope text-warning");

    private final String iconClass;

    @JsonCreator
    public static MonsterTypeEnum fromString(String value) {
        if (value == null) {
            return null;
        }
        String normalized = value.trim().toLowerCase();

        return Stream.of(MonsterTypeEnum.values())
                .filter(g -> g.name().toLowerCase().equals(normalized))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Tipo não reconhecido: " + value));
    }
}
