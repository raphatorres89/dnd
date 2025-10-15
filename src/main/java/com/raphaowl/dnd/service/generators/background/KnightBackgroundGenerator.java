package com.raphaowl.dnd.service.generators.background;

import java.util.List;

import com.raphaowl.dnd.enums.BackgroundEnum;
import com.raphaowl.dnd.enums.IdealEnum;
import com.raphaowl.dnd.enums.PersonalityTrait;

import org.springframework.stereotype.Component;

@Component
public class KnightBackgroundGenerator extends AbstractBackgroundGenerator {

    public static final List<PersonalityTrait> PERSONALITY_TRAITS = List.of(
            PersonalityTrait.KNIGHT_1,
            PersonalityTrait.KNIGHT_2,
            PersonalityTrait.KNIGHT_3,
            PersonalityTrait.KNIGHT_4,
            PersonalityTrait.KNIGHT_5,
            PersonalityTrait.KNIGHT_6,
            PersonalityTrait.KNIGHT_7,
            PersonalityTrait.KNIGHT_8
    );

    public static final List<IdealEnum> IDEALS = List.of(
            IdealEnum.KNIGHT_1,
            IdealEnum.KNIGHT_2,
            IdealEnum.KNIGHT_3,
            IdealEnum.KNIGHT_4,
            IdealEnum.KNIGHT_5,
            IdealEnum.KNIGHT_6
    );

    @Override
    protected IdealEnum generateIdealTrait() {
        return IDEALS.get(random.nextInt(IDEALS.size()));
    }

    @Override
    protected PersonalityTrait generatePersonalityTrait() {
        return PERSONALITY_TRAITS.get(random.nextInt(PERSONALITY_TRAITS.size()));
    }

    @Override
    public BackgroundEnum getBackgroundName() {
        return BackgroundEnum.KNIGHT;
    }

}
