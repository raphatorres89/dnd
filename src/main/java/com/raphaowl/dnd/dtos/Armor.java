package com.raphaowl.dnd.dtos;

import com.raphaowl.dnd.enums.ArmorTypeEnum;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Armor extends Item {
    private Integer ac;
    private Boolean stealthDisadvantage;
    private String strengthRequirement;
    private ArmorTypeEnum type;

    public Armor(Integer quantity, String name, Double price, Double weight, Integer ac,
            Boolean stealthDisadvantage, String strengthRequirement, ArmorTypeEnum type) {
        super(quantity, name, price, weight, type.getIconClass());
        this.ac = ac;
        this.stealthDisadvantage = stealthDisadvantage;
        this.strengthRequirement = strengthRequirement;
        this.type = type;
    }
}
