package com.raphaowl.dnd.dtos;

import com.raphaowl.dnd.enums.DamageEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Attack {
        private String damageDice;
        private DamageEnum damageType;
        private boolean finesse;
        private boolean twoHanded;
        private boolean versatile;
}
