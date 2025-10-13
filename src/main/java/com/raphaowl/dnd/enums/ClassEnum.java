package com.raphaowl.dnd.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ClassEnum {
    BARBARIAN("ra ra-axe"),
    BARD("ra ra-vine-whip"),
    CLERIC("ra ra-hospital-cross"),
    DRUID("ra ra-wolf-head"),
    FIGHTER("ra ra-sword"),
    MONK("ra ra-flaming-claw"),
    PALADIN("ra ra-shield"),
    RANGER("ra ra-archer"),
    ROGUE("ra ra-plain-dagger"),
    SORCERER("ra ra-crystal-wand"),
    WARLOCK("ra ra-fire-symbol"),
    WIZARD("ra ra-book");

    private String iconClass;
}
