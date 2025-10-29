package com.raphaowl.dnd.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum WeaponType {
    SIMPLE_MELEE("ra ra-plain-dagger"),
    SIMPLE_RANGED("ra ra-arrow-flights"),
    MARTIAL_MELEE("ra ra-relic-blade"),
    MARTIAL_RANGED("ra ra-crossbow");

    private final String iconClass;
}
