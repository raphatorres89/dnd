package com.raphaowl.dnd.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ToolTypeEnum {
    ARTISAN("ra ra-wrench"),
    MUSICAL("ra ra-ocarina"),
    GAMING("ra ra-jigsaw-piece"),
    CHEATING("ra ra-hearts-card"),
    GENERAL("ra ra-gears");

    private final String iconClass;
}
