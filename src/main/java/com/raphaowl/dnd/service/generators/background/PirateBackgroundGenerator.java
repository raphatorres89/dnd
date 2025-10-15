package com.raphaowl.dnd.service.generators.background;

import java.util.List;

import com.raphaowl.dnd.enums.BackgroundEnum;
import com.raphaowl.dnd.enums.PersonalityTrait;

import org.springframework.stereotype.Component;

@Component
public class PirateBackgroundGenerator extends AbstractBackgroundGenerator {

    public static final List<PersonalityTrait> PERSONALITY_TRAITS = List.of(
            PersonalityTrait.PIRATE_1,
            PersonalityTrait.PIRATE_2,
            PersonalityTrait.PIRATE_3,
            PersonalityTrait.PIRATE_4,
            PersonalityTrait.PIRATE_5,
            PersonalityTrait.PIRATE_6,
            PersonalityTrait.PIRATE_7,
            PersonalityTrait.PIRATE_8
    );

    @Override
    protected PersonalityTrait generatePersonalityTrait() {
        return PERSONALITY_TRAITS.get(random.nextInt(PERSONALITY_TRAITS.size()));
    }

    @Override
    public BackgroundEnum getBackgroundName() {
        return BackgroundEnum.PIRATE;
    }

}
