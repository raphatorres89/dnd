package com.raphaowl.dnd.dtos;

import com.raphaowl.dnd.enums.DamageEnum;

public record Attack(
        String name,
        String toHitBonus,
        String damageRoll,
        DamageEnum type
) {}
