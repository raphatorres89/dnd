package com.raphaowl.dnd.service.generators.background;

import java.util.List;

import com.raphaowl.dnd.enums.BackgroundEnum;
import com.raphaowl.dnd.enums.PersonalityTrait;

import org.springframework.stereotype.Component;

@Component
public class AcolyteBackgroundGenerator extends AbstractBackgroundGenerator {

    public static final List<PersonalityTrait> PERSONALITY_TRAITS = List.of(
            PersonalityTrait.ACOLYTE_1,
            PersonalityTrait.ACOLYTE_2,
            PersonalityTrait.ACOLYTE_3,
            PersonalityTrait.ACOLYTE_4,
            PersonalityTrait.ACOLYTE_5,
            PersonalityTrait.ACOLYTE_6,
            PersonalityTrait.ACOLYTE_7,
            PersonalityTrait.ACOLYTE_8
    );

    @Override
    protected PersonalityTrait generatePersonalityTrait() {
        return PERSONALITY_TRAITS.get(random.nextInt(PERSONALITY_TRAITS.size()));
    }

    @Override
    public BackgroundEnum getBackgroundName() {
        return BackgroundEnum.ACOLYTE;
    }

}
