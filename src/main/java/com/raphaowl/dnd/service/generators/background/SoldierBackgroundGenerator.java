package com.raphaowl.dnd.service.generators.background;

import java.util.List;

import com.raphaowl.dnd.enums.BackgroundEnum;
import com.raphaowl.dnd.enums.PersonalityTrait;

import org.springframework.stereotype.Component;

@Component
public class SoldierBackgroundGenerator extends AbstractBackgroundGenerator {

    public static final List<PersonalityTrait> PERSONALITY_TRAITS = List.of(
            PersonalityTrait.SOLDIER_1,
            PersonalityTrait.SOLDIER_2,
            PersonalityTrait.SOLDIER_3,
            PersonalityTrait.SOLDIER_4,
            PersonalityTrait.SOLDIER_5,
            PersonalityTrait.SOLDIER_6,
            PersonalityTrait.SOLDIER_7,
            PersonalityTrait.SOLDIER_8
    );

    @Override
    protected PersonalityTrait generatePersonalityTrait() {
        return PERSONALITY_TRAITS.get(random.nextInt(PERSONALITY_TRAITS.size()));
    }

    @Override
    public BackgroundEnum getBackgroundName() {
        return BackgroundEnum.SOLDIER;
    }

}
