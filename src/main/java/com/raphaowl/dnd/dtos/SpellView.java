package com.raphaowl.dnd.dtos;

import java.util.List;

import com.raphaowl.dnd.enums.ComponentEnum;
import com.raphaowl.dnd.enums.DamageEnum;
import com.raphaowl.dnd.enums.MagicSchool;
import com.raphaowl.dnd.enums.VersionEnum;

public record SpellView(
    String id,
    String name,
    Integer level,
    MagicSchool school,
    DamageEnum damageType,
    String damage,
    List<ComponentEnum> components,
    List<VersionEnum> versions,
    String range
) {}