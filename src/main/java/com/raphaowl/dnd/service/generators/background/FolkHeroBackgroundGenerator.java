package com.raphaowl.dnd.service.generators.background;

import java.util.ArrayList;
import java.util.List;

import com.raphaowl.dnd.enums.AlignmentEnum;
import com.raphaowl.dnd.enums.BackgroundEnum;
import com.raphaowl.dnd.enums.BondsEnum;
import com.raphaowl.dnd.enums.FlawsEnum;
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

    public static final  List<BondsEnum> BONDS_TRAITS = List.of(
            BondsEnum.FOLK_HERO_1,
            BondsEnum.FOLK_HERO_2,
            BondsEnum.FOLK_HERO_3,
            BondsEnum.FOLK_HERO_4,
            BondsEnum.FOLK_HERO_5,
            BondsEnum.FOLK_HERO_6
    );

    public static final List<FlawsEnum> FLAWS_TRAITS = List.of(
            FlawsEnum.FOLK_HERO_1,
            FlawsEnum.FOLK_HERO_2,
            FlawsEnum.FOLK_HERO_3,
            FlawsEnum.FOLK_HERO_4,
            FlawsEnum.FOLK_HERO_5,
            FlawsEnum.FOLK_HERO_6
    );

    @Override
    protected FlawsEnum generateFlaws() {
        return FLAWS_TRAITS.get(random.nextInt(FLAWS_TRAITS.size()));
    }

    @Override
    protected BondsEnum generateBonds() {
        return BONDS_TRAITS.get(random.nextInt(BONDS_TRAITS.size()));
    }

    @Override
    protected IdealEnum generateIdeal(AlignmentEnum alignment) {
        List<IdealEnum> ideals = new ArrayList<>(List.of());
        // LAWFUL
        if (AlignmentEnum.getLawful().contains(alignment)) {
            ideals.add(IdealEnum.FOLK_HERO_2);
        }
        // CHAOTIC
        if (AlignmentEnum.getChaotic().contains(alignment)) {
            ideals.add(IdealEnum.FOLK_HERO_3);
        }
        // GOOD
        if (AlignmentEnum.getGood().contains(alignment)) {
            ideals.add(IdealEnum.FOLK_HERO_1);
        }
        // EVIL
        if (AlignmentEnum.getEvil().contains(alignment)) {
            ideals.add(IdealEnum.FOLK_HERO_4);
        }
        // NEUTRAL
        if (AlignmentEnum.getNeutral().contains(alignment)) {
            ideals.add(IdealEnum.FOLK_HERO_5);
        }
        ideals.add(IdealEnum.FOLK_HERO_6);
        return ideals.get(random.nextInt(ideals.size()));
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
