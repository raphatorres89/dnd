package com.raphaowl.dnd.enums;

import java.util.List;
import java.util.stream.Stream;

import com.fasterxml.jackson.annotation.JsonCreator;

import lombok.Getter;

@Getter
public enum AlignmentEnum {
    CHAOTIC_EVIL,
    CHAOTIC_GOOD,
    CHAOTIC_NEUTRAL,
    LAWFUL_EVIL,
    LAWFUL_GOOD,
    LAWFUL_NEUTRAL,
    NEUTRAL,
    NEUTRAL_EVIL,
    NEUTRAL_GOOD,
    // monster specific
    ANY_ALIGNMENT,
    UNALIGNED,
    ANY_NON_GOOD_ALIGNMENT,
    ANY_NON_LAWFUL_ALIGNMENT,
    ANY_CHAOTIC_ALIGNMENT,
    NEUTRAL_GOOD_OR_EVIL,
    ANY_EVIL_ALIGNMENT;

    public static List<AlignmentEnum> getStandard() {
        return List.of(
                CHAOTIC_EVIL,
                CHAOTIC_GOOD,
                CHAOTIC_NEUTRAL,
                LAWFUL_EVIL,
                LAWFUL_GOOD,
                LAWFUL_NEUTRAL,
                NEUTRAL,
                NEUTRAL_EVIL,
                NEUTRAL_GOOD
        );
    }

    @JsonCreator
    public static AlignmentEnum fromString(String value) {
        if (value == null) {
            return null;
        }
        String normalized = value.trim()
                .toLowerCase()
                .replace(" ", "_")
                .replace("-", "_");

        if (value.equalsIgnoreCase("neutral good (50%) or neutral evil (50%)")) {
            return NEUTRAL_GOOD_OR_EVIL;
        }

        return Stream.of(AlignmentEnum.values())
                .filter(g -> g.name().toLowerCase().equals(normalized))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Alinhamento não reconhecido: " + value));
    }
}
