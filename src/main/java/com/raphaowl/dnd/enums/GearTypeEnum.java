package com.raphaowl.dnd.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GearTypeEnum {
    ADVENTURING_GEAR("bi bi-backpack"),
    CONTAINER("bi bi-box"),
    CLOTHING("ra ra-vest"),
    AMMUNITION("ra ra-rifle"),
    TRADE_GOOD("ra ra-gem"),
    PACK("ra ra-ammo-bag"),
    FOCUS("ra ra-crystal-ball");

    private final String iconClass;
}
