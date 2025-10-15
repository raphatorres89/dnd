package com.raphaowl.dnd.service.generators.background;

import java.util.List;

import com.raphaowl.dnd.enums.BackgroundEnum;
import com.raphaowl.dnd.enums.IdealEnum;
import com.raphaowl.dnd.enums.PersonalityTrait;

import org.springframework.stereotype.Component;

@Component
public class HermitBackgroundGenerator extends AbstractBackgroundGenerator {

    public static final List<PersonalityTrait> PERSONALITY_TRAITS = List.of(
            PersonalityTrait.HERMIT_1,
            PersonalityTrait.HERMIT_2,
            PersonalityTrait.HERMIT_3,
            PersonalityTrait.HERMIT_4,
            PersonalityTrait.HERMIT_5,
            PersonalityTrait.HERMIT_6,
            PersonalityTrait.HERMIT_7,
            PersonalityTrait.HERMIT_8
    );

    public static final List<IdealEnum> IDEALS = List.of(
            IdealEnum.HERMIT_1,
            IdealEnum.HERMIT_2,
            IdealEnum.HERMIT_3,
            IdealEnum.HERMIT_4,
            IdealEnum.HERMIT_5,
            IdealEnum.HERMIT_6
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
        return BackgroundEnum.HERMIT;
    }

}
