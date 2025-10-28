package com.raphaowl.dnd.dtos;

import com.raphaowl.dnd.enums.BackgroundEnum;
import com.raphaowl.dnd.enums.ClassEnum;
import com.raphaowl.dnd.enums.GenderEnum;
import com.raphaowl.dnd.enums.RaceEnum;

public record NpcFilterDto(
        RaceEnum race,
        GenderEnum gender,
        ClassEnum className,
        BackgroundEnum background,
        Integer level
) {
    public NpcFilterDto {
        if (level != null && (level < 1 || level > 20)) {
            throw new IllegalArgumentException("O nível deve estar entre 1 e 20.");
        }
    }
}
