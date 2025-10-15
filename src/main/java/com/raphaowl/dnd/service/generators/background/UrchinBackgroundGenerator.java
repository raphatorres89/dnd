package com.raphaowl.dnd.service.generators.background;

import java.util.List;

import com.raphaowl.dnd.enums.BackgroundEnum;
import com.raphaowl.dnd.enums.PersonalityTrait;

import org.springframework.stereotype.Component;

@Component
public class UrchinBackgroundGenerator extends AbstractBackgroundGenerator {

    public static final List<PersonalityTrait> PERSONALITY_TRAITS = List.of(
            PersonalityTrait.URCHIN_1,
            PersonalityTrait.URCHIN_2,
            PersonalityTrait.URCHIN_3,
            PersonalityTrait.URCHIN_4,
            PersonalityTrait.URCHIN_5,
            PersonalityTrait.URCHIN_6,
            PersonalityTrait.URCHIN_7,
            PersonalityTrait.URCHIN_8
    );

    @Override
    protected PersonalityTrait generatePersonalityTrait() {
        return PERSONALITY_TRAITS.get(random.nextInt(PERSONALITY_TRAITS.size()));
    }

    @Override
    public BackgroundEnum getBackgroundName() {
        return BackgroundEnum.URCHIN;
    }

}
