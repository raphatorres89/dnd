package com.raphaowl.dnd.service.generators.background;

import java.util.List;

import com.raphaowl.dnd.enums.BackgroundEnum;
import com.raphaowl.dnd.enums.IdealEnum;
import com.raphaowl.dnd.enums.PersonalityTrait;

import org.springframework.stereotype.Component;

@Component
public class CharlatanBackgroundGenerator extends AbstractBackgroundGenerator {

    public static final List<PersonalityTrait> PERSONALITY_TRAITS = List.of(
            PersonalityTrait.CHARLATAN_1,
            PersonalityTrait.CHARLATAN_2,
            PersonalityTrait.CHARLATAN_3,
            PersonalityTrait.CHARLATAN_4,
            PersonalityTrait.CHARLATAN_5,
            PersonalityTrait.CHARLATAN_6,
            PersonalityTrait.CHARLATAN_7,
            PersonalityTrait.CHARLATAN_8
    );

    public static final List<IdealEnum> IDEALS = List.of(
            IdealEnum.CHARLATAN_1,
            IdealEnum.CHARLATAN_2,
            IdealEnum.CHARLATAN_3,
            IdealEnum.CHARLATAN_4,
            IdealEnum.CHARLATAN_5,
            IdealEnum.CHARLATAN_6
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
        return BackgroundEnum.CHARLATAN;
    }

}
