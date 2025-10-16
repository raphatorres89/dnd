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

    public static final  List<BondsEnum> BONDS_TRAITS = List.of(
            BondsEnum.HERMIT_1,
            BondsEnum.HERMIT_2,
            BondsEnum.HERMIT_3,
            BondsEnum.HERMIT_4,
            BondsEnum.HERMIT_5,
            BondsEnum.HERMIT_6
    );

    public static final List<FlawsEnum> FLAWS_TRAITS = List.of(
            FlawsEnum.HERMIT_1,
            FlawsEnum.HERMIT_2,
            FlawsEnum.HERMIT_3,
            FlawsEnum.HERMIT_4,
            FlawsEnum.HERMIT_5,
            FlawsEnum.HERMIT_6
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
            ideals.add(IdealEnum.HERMIT_2);
        }
        // CHAOTIC
        if (AlignmentEnum.getChaotic().contains(alignment)) {
            ideals.add(IdealEnum.HERMIT_3);
        }
        // GOOD
        if (AlignmentEnum.getGood().contains(alignment)) {
            ideals.add(IdealEnum.HERMIT_1);
        }
        // EVIL
        if (AlignmentEnum.getEvil().contains(alignment)) {
            ideals.add(IdealEnum.HERMIT_4);
        }
        // NEUTRAL
        if (AlignmentEnum.getNeutral().contains(alignment)) {
            ideals.add(IdealEnum.HERMIT_5);
        }
        ideals.add(IdealEnum.HERMIT_6);
        return ideals.get(random.nextInt(ideals.size()));
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
