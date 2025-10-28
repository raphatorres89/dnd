package com.raphaowl.dnd.dtos;

import com.raphaowl.dnd.enums.DamageEnum;
import com.raphaowl.dnd.enums.MagicSchool;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Spell {
    private String name;
    private Integer level;
    private MagicSchool school;
    private DamageEnum damageType;
    private String damage;
}
