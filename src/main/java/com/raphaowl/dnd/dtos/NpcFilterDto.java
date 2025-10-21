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
        Integer challengeRating
) {
    public NpcFilterDto {
        if (challengeRating != null && (challengeRating < 1 || challengeRating > 16)) {
            throw new IllegalArgumentException("O nível de desafio deve estar entre 1 e 16.");
        }
    }
}
