package com.raphaowl.dnd.service.generators.background;

import java.util.List;

import com.raphaowl.dnd.enums.BackgroundEnum;
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

    @Override
    protected PersonalityTrait generatePersonalityTrait() {
        return PERSONALITY_TRAITS.get(random.nextInt(PERSONALITY_TRAITS.size()));
    }

    @Override
    public BackgroundEnum getBackgroundName() {
        return BackgroundEnum.OUTLANDER;
    }

}
