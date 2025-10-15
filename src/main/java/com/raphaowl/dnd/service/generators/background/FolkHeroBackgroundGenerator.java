package com.raphaowl.dnd.service.generators.background;

import java.util.List;

import com.raphaowl.dnd.enums.BackgroundEnum;
import com.raphaowl.dnd.enums.PersonalityTrait;

import org.springframework.stereotype.Component;

@Component
public class FolkHeroBackgroundGenerator extends AbstractBackgroundGenerator {

    public static final List<PersonalityTrait> PERSONALITY_TRAITS = List.of(
            PersonalityTrait.FOLK_HERO_1,
            PersonalityTrait.FOLK_HERO_2,
            PersonalityTrait.FOLK_HERO_3,
            PersonalityTrait.FOLK_HERO_4,
            PersonalityTrait.FOLK_HERO_5,
            PersonalityTrait.FOLK_HERO_6,
            PersonalityTrait.FOLK_HERO_7,
            PersonalityTrait.FOLK_HERO_8
    );

    @Override
    protected PersonalityTrait generatePersonalityTrait() {
        return PERSONALITY_TRAITS.get(random.nextInt(PERSONALITY_TRAITS.size()));
    }

    @Override
    public BackgroundEnum getBackgroundName() {
        return BackgroundEnum.FOLK_HERO;
    }

}
