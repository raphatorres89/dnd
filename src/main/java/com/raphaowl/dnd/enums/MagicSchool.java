package com.raphaowl.dnd.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MagicSchool {
    ABJURATION("ra ra-shield text-primary"),
    CONJURATION("bi bi-stars text-success"),
    DIVINATION("ra ra-crystal-ball text-info"),
    ENCHANTMENT("ra ra-hearts text-danger"),
    EVOCATION("ra ra-fire text-warning"),
    ILLUSION("bi bi-eye-slash text-secondary"),
    NECROMANCY("ra ra-death-skull"),
    TRANSMUTATION("ra ra-recycle text-success");

    private final String iconClass;

    public static MagicSchool from(String school) {
        for (MagicSchool ms : values()) {
            if (ms.name().equalsIgnoreCase(school)) {
                return ms;
            }
        }
        throw new IllegalArgumentException("Unknown magic school: " + school);
    }
}
