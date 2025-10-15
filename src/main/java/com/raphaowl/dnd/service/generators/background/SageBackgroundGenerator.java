package com.raphaowl.dnd.service.generators.background;

import java.util.List;

import com.raphaowl.dnd.enums.BackgroundEnum;
import com.raphaowl.dnd.enums.PersonalityTrait;

import org.springframework.stereotype.Component;

@Component
public class SageBackgroundGenerator extends AbstractBackgroundGenerator {

    public static final List<PersonalityTrait> PERSONALITY_TRAITS = List.of(
            PersonalityTrait.SAGE_1,
            PersonalityTrait.SAGE_2,
            PersonalityTrait.SAGE_3,
            PersonalityTrait.SAGE_4,
            PersonalityTrait.SAGE_5,
            PersonalityTrait.SAGE_6,
            PersonalityTrait.SAGE_7,
            PersonalityTrait.SAGE_8
    );

    @Override
    protected PersonalityTrait generatePersonalityTrait() {
        return PERSONALITY_TRAITS.get(random.nextInt(PERSONALITY_TRAITS.size()));
    }

    @Override
    public BackgroundEnum getBackgroundName() {
        return BackgroundEnum.SAGE;
    }

}
