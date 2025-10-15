package com.raphaowl.dnd.service.generators.background;

import java.util.List;

import com.raphaowl.dnd.enums.BackgroundEnum;
import com.raphaowl.dnd.enums.IdealEnum;
import com.raphaowl.dnd.enums.PersonalityTrait;

import org.springframework.stereotype.Component;

@Component
public class EntertainerBackgroundGenerator extends AbstractBackgroundGenerator {

    public static final List<PersonalityTrait> PERSONALITY_TRAITS = List.of(
            PersonalityTrait.ENTERTAINER_1,
            PersonalityTrait.ENTERTAINER_2,
            PersonalityTrait.ENTERTAINER_3,
            PersonalityTrait.ENTERTAINER_4,
            PersonalityTrait.ENTERTAINER_5,
            PersonalityTrait.ENTERTAINER_6,
            PersonalityTrait.ENTERTAINER_7,
            PersonalityTrait.ENTERTAINER_8
    );

    public static final List<IdealEnum> IDEALS = List.of(
            IdealEnum.ENTERTAINER_1,
            IdealEnum.ENTERTAINER_2,
            IdealEnum.ENTERTAINER_3,
            IdealEnum.ENTERTAINER_4,
            IdealEnum.ENTERTAINER_5,
            IdealEnum.ENTERTAINER_6
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
        return BackgroundEnum.ENTERTAINER;
    }

}
