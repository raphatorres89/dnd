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
public class SageBackgroundGenerator extends AbstractBackgroundGenerator {

    public static final List<PersonalityTrait> PERSONALITY_TRAITS = List.of(
            PersonalityTrait.SAGE_1,
            PersonalityTrait.SAGE_2,
            PersonalityTrait.SAGE_3,
            PersonalityTrait.SAGE_4,
            PersonalityTrait.SAGE_5,
            PersonalityTrait.SAGE_6,
            PersonalityTrait.SAGE_7,
            PersonalityTrait.SAGE_8
    );

    public static final  List<BondsEnum> BONDS_TRAITS = List.of(
            BondsEnum.SAGE_1,
            BondsEnum.SAGE_2,
            BondsEnum.SAGE_3,
            BondsEnum.SAGE_4,
            BondsEnum.SAGE_5,
            BondsEnum.SAGE_6
    );

    public static final List<FlawsEnum> FLAWS_TRAITS = List.of(
            FlawsEnum.SAGE_1,
            FlawsEnum.SAGE_2,
            FlawsEnum.SAGE_3,
            FlawsEnum.SAGE_4,
            FlawsEnum.SAGE_5,
            FlawsEnum.SAGE_6
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
            ideals.add(IdealEnum.SAGE_3);
        }
        // CHAOTIC
        if (AlignmentEnum.getChaotic().contains(alignment)) {
            ideals.add(IdealEnum.SAGE_4);
        }
        // GOOD
        if (AlignmentEnum.getGood().contains(alignment)) {
            ideals.add(IdealEnum.SAGE_2);
        }
        // EVIL
        if (AlignmentEnum.getEvil().contains(alignment)) {
            ideals.add(IdealEnum.SAGE_5);
        }
        // NEUTRAL
        if (AlignmentEnum.getNeutral().contains(alignment)) {
            ideals.add(IdealEnum.SAGE_1);
        }
        ideals.add(IdealEnum.SAGE_6);
        return ideals.get(random.nextInt(ideals.size()));
    }

    @Override
    protected PersonalityTrait generatePersonalityTrait() {
        return PERSONALITY_TRAITS.get(random.nextInt(PERSONALITY_TRAITS.size()));
    }

    @Override
    public BackgroundEnum getBackgroundName() {
        return BackgroundEnum.SAGE;
    }

}
