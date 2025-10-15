package com.raphaowl.dnd.dtos;

import com.raphaowl.dnd.enums.BackgroundEnum;
import com.raphaowl.dnd.enums.IdealEnum;
import com.raphaowl.dnd.enums.PersonalityTrait;

public record Background(
        BackgroundEnum name,
        PersonalityTrait trait,
        IdealEnum ideal
) {
}
