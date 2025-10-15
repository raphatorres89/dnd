package com.raphaowl.dnd.service.generators.background;

import java.util.List;

import com.raphaowl.dnd.enums.BackgroundEnum;
import com.raphaowl.dnd.enums.IdealEnum;
import com.raphaowl.dnd.enums.PersonalityTrait;

import org.springframework.stereotype.Component;

@Component
public class OutlanderBackgroundGenerator extends AbstractBackgroundGenerator {

    public static final List<PersonalityTrait> PERSONALITY_TRAITS = List.of(
            PersonalityTrait.OUTLANDER_1,
            PersonalityTrait.OUTLANDER_2,
            PersonalityTrait.OUTLANDER_3,
            PersonalityTrait.OUTLANDER_4,
            PersonalityTrait.OUTLANDER_5,
            PersonalityTrait.OUTLANDER_6,
            PersonalityTrait.OUTLANDER_7,
            PersonalityTrait.OUTLANDER_8
    );

    public static final List<IdealEnum> IDEALS = List.of(
            IdealEnum.OUTLANDER_1,
            IdealEnum.OUTLANDER_2,
            IdealEnum.OUTLANDER_3,
            IdealEnum.OUTLANDER_4,
            IdealEnum.OUTLANDER_5,
            IdealEnum.OUTLANDER_6
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
        return BackgroundEnum.OUTLANDER;
    }

}
