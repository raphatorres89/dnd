package com.raphaowl.dnd.dtos;

import com.raphaowl.dnd.enums.AlignmentEnum;
import com.raphaowl.dnd.enums.CharacteristicEnum;
import com.raphaowl.dnd.enums.ClassEnum;
import com.raphaowl.dnd.enums.GenderEnum;
import com.raphaowl.dnd.enums.MotivationEnum;
import com.raphaowl.dnd.enums.RaceEnum;

public record Npc(
        String name,
        RaceEnum race,
        GenderEnum gender,
        AlignmentEnum alignment,
        ClassEnum className,
        String statistics,
        CharacteristicEnum trait,
        MotivationEnum motivation) {
}
