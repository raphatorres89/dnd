package com.raphaowl.dnd.enums;

import lombok.Getter;

@Getter
public enum ComponentEnum {
    V("ra ra-microphone"),
    S("ra ra-hand"),
    M("ra ra-potion");

    private final String iconClass;

    ComponentEnum(String iconClass) {
        this.iconClass = iconClass;
    }
}
