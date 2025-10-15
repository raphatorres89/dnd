package com.raphaowl.dnd.service.generators.background;

import java.util.List;

import com.raphaowl.dnd.enums.BackgroundEnum;
import com.raphaowl.dnd.enums.IdealEnum;
import com.raphaowl.dnd.enums.PersonalityTrait;

import org.springframework.stereotype.Component;

@Component
public class SailorBackgroundGenerator extends AbstractBackgroundGenerator {

    public static final List<PersonalityTrait> PERSONALITY_TRAITS = List.of(
            PersonalityTrait.SAILOR_1,
            PersonalityTrait.SAILOR_2,
            PersonalityTrait.SAILOR_3,
            PersonalityTrait.SAILOR_4,
            PersonalityTrait.SAILOR_5,
            PersonalityTrait.SAILOR_6,
            PersonalityTrait.SAILOR_7,
            PersonalityTrait.SAILOR_8
    );

    public static final List<IdealEnum> IDEALS = List.of(
            IdealEnum.SAILOR_1,
            IdealEnum.SAILOR_2,
            IdealEnum.SAILOR_3,
            IdealEnum.SAILOR_4,
            IdealEnum.SAILOR_5,
            IdealEnum.SAILOR_6
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
        return BackgroundEnum.SAILOR;
    }

}
