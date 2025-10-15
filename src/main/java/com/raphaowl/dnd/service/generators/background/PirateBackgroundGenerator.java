package com.raphaowl.dnd.service.generators.background;

import java.util.List;

import com.raphaowl.dnd.enums.BackgroundEnum;
import com.raphaowl.dnd.enums.IdealEnum;
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

    public static final List<IdealEnum> IDEALS = List.of(
            IdealEnum.PIRATE_1,
            IdealEnum.PIRATE_2,
            IdealEnum.PIRATE_3,
            IdealEnum.PIRATE_4,
            IdealEnum.PIRATE_5,
            IdealEnum.PIRATE_6
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
        return BackgroundEnum.PIRATE;
    }

}
