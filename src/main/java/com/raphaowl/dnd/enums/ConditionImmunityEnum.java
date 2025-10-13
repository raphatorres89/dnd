package com.raphaowl.dnd.enums;

import java.util.stream.Stream;

import com.fasterxml.jackson.annotation.JsonCreator;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ConditionImmunityEnum {
    BLINDED("ra ra-bleeding-eye text-danger"),
    CHARMED("ra ra-two-hearts text-danger"),
    DEAFENED("bi bi-volume-mute"),
    EXHAUSTION("ra ra-player-despair text-primary"),
    FRIGHTENED("ra ra-player-despair"),
    GRAPPLED("ra ra-suckered-tentacle text-info"),
    PARALYZED("ra ra-player-teleport text-danger"),
    PETRIFIED("ra ra-aura text-secondary"),
    POISONED("ra ra-vial text-success"),
    PRONE("ra ra-snake text-success"),
    RESTRAINED("ra ra-chain text-secondary"),
    STUNNED("ra ra-aware text-info"),
    UNCONSCIOUS("ra ra-falling text-secondary");

    private final String iconClass;

    @JsonCreator
    public static ConditionImmunityEnum fromString(String value) {
        if (value == null) {
            return null;
        }
        String normalized = value.trim().toLowerCase();

        return Stream.of(ConditionImmunityEnum.values())
                .filter(g -> g.name().toLowerCase().equals(normalized))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Dano não reconhecido: " + value));
    }
}
