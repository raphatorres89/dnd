package com.raphaowl.dnd.enums;

import com.raphaowl.dnd.dtos.Armor;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ArmorEnum {
    // ---------- LIGHT ARMOR ----------
    PADDED("Padded Armor", 5.0, 4.0, 11, true, null, ArmorTypeEnum.LIGHT),
    LEATHER("Leather Armor", 10.0, 5.0, 11, false, null, ArmorTypeEnum.LIGHT),
    STUDDED_LEATHER("Studded Leather Armor", 45.0, 6.5, 12, false, null, ArmorTypeEnum.LIGHT),

    // ---------- MEDIUM ARMOR ----------
    HIDE("Hide Armor", 10.0, 6.0, 12, false, null, ArmorTypeEnum.MEDIUM),
    CHAIN_SHIRT("Chain Shirt", 50.0, 10.0, 13, false, null, ArmorTypeEnum.MEDIUM),
    SCALE_MAIL("Scale Mail", 50.0, 22.5, 14, true, null, ArmorTypeEnum.MEDIUM),
    BREASTPLATE("Breastplate", 400.0, 10.0, 14, false, null, ArmorTypeEnum.MEDIUM),
    HALF_PLATE("Half Plate", 750.0, 20.0, 15, true, null, ArmorTypeEnum.MEDIUM),

    // ---------- HEAVY ARMOR ----------
    RING_MAIL("Ring Mail", 30.0, 20.0, 14, true, null, ArmorTypeEnum.HEAVY),
    CHAIN_MAIL("Chain Mail", 75.0, 27.5, 16, true, "13", ArmorTypeEnum.HEAVY),
    SPLINT("Splint Armor", 200.0, 30.0, 17, true, "15", ArmorTypeEnum.HEAVY),
    PLATE("Plate Armor", 1500.0, 32.5, 18, true, "15", ArmorTypeEnum.HEAVY),

    // ---------- SHIELD ----------
    SHIELD("Shield", 10.0, 3.0, 2, false, null, ArmorTypeEnum.SHIELD);

    private final String name;
    private final Double price;
    private final Double weight;
    private final Integer ac;
    private final Boolean stealthDisadvantage;
    private final String strengthRequirement;
    private final ArmorTypeEnum type;

    public Armor toArmor(Integer quantity) {
        return new Armor(
                quantity,
                this.name(),
                price,
                weight,
                ac,
                stealthDisadvantage,
                strengthRequirement,
                type
        );
    }
}
