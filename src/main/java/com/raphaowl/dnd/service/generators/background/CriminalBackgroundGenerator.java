package com.raphaowl.dnd.service.generators.background;

import java.util.List;

import com.raphaowl.dnd.enums.BackgroundEnum;
import com.raphaowl.dnd.enums.PersonalityTrait;

import org.springframework.stereotype.Component;

@Component
public class CriminalBackgroundGenerator extends AbstractBackgroundGenerator {

    public static final List<PersonalityTrait> PERSONALITY_TRAITS = List.of(
            PersonalityTrait.CRIMINAL_1,
            PersonalityTrait.CRIMINAL_2,
            PersonalityTrait.CRIMINAL_3,
            PersonalityTrait.CRIMINAL_4,
            PersonalityTrait.CRIMINAL_5,
            PersonalityTrait.CRIMINAL_6,
            PersonalityTrait.CRIMINAL_7,
            PersonalityTrait.CRIMINAL_8
    );

    @Override
    protected PersonalityTrait generatePersonalityTrait() {
        return PERSONALITY_TRAITS.get(random.nextInt(PERSONALITY_TRAITS.size()));
    }

    @Override
    public BackgroundEnum getBackgroundName() {
        return BackgroundEnum.CRIMINAL;
    }

}
