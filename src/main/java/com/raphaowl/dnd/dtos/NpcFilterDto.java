package com.raphaowl.dnd.dtos;

import com.raphaowl.dnd.enums.BackgroundEnum;
import com.raphaowl.dnd.enums.ClassEnum;
import com.raphaowl.dnd.enums.GenderEnum;
import com.raphaowl.dnd.enums.RaceEnum;

public record NpcFilterDto(
        RaceEnum race,
        GenderEnum gender,
        ClassEnum className,
        BackgroundEnum background
) {
}
