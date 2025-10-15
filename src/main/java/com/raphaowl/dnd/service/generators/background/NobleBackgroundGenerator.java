package com.raphaowl.dnd.service.generators.background;

import java.util.List;

import com.raphaowl.dnd.enums.BackgroundEnum;
import com.raphaowl.dnd.enums.PersonalityTrait;

import org.springframework.stereotype.Component;

@Component
public class NobleBackgroundGenerator extends AbstractBackgroundGenerator {

    public static final List<PersonalityTrait> PERSONALITY_TRAITS = List.of(
            PersonalityTrait.NOBLE_1,
            PersonalityTrait.NOBLE_2,
            PersonalityTrait.NOBLE_3,
            PersonalityTrait.NOBLE_4,
            PersonalityTrait.NOBLE_5,
            PersonalityTrait.NOBLE_6,
            PersonalityTrait.NOBLE_7,
            PersonalityTrait.NOBLE_8
    );

    @Override
    protected PersonalityTrait generatePersonalityTrait() {
        return PERSONALITY_TRAITS.get(random.nextInt(PERSONALITY_TRAITS.size()));
    }

    @Override
    public BackgroundEnum getBackgroundName() {
        return BackgroundEnum.NOBLE;
    }

}
