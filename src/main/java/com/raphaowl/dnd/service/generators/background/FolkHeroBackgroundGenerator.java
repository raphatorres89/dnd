package com.raphaowl.dnd.service.generators.background;

import java.util.List;

import com.raphaowl.dnd.enums.BackgroundEnum;
import com.raphaowl.dnd.enums.IdealEnum;
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

    public static final List<IdealEnum> IDEALS = List.of(
            IdealEnum.FOLK_HERO_1,
            IdealEnum.FOLK_HERO_2,
            IdealEnum.FOLK_HERO_3,
            IdealEnum.FOLK_HERO_4,
            IdealEnum.FOLK_HERO_5,
            IdealEnum.FOLK_HERO_6
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
        return BackgroundEnum.FOLK_HERO;
    }

}
