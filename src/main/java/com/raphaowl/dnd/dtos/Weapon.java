package com.raphaowl.dnd.dtos;

import com.raphaowl.dnd.enums.WeaponType;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Weapon extends Item {
    private Attack attack;
    private WeaponType type;

    public Weapon(Integer quantity, String name, Double price, Double weight, Attack attack, WeaponType type) {
        super(quantity, name, price, weight);
        this.attack = attack;
        this.type = type;
    }
}
