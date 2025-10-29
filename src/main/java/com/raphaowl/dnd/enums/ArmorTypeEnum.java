package com.raphaowl.dnd.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ArmorTypeEnum {
    LIGHT("ra ra-vest"),
    MEDIUM("ra ra-helmet"),
    HEAVY("ra ra-knight-helmet"),
    SHIELD("ra ra-shield");

    private final String iconClass;
}
