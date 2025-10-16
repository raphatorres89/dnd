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
public class EntertainerBackgroundGenerator extends AbstractBackgroundGenerator {

    public static final List<PersonalityTrait> PERSONALITY_TRAITS = List.of(
            PersonalityTrait.ENTERTAINER_1,
            PersonalityTrait.ENTERTAINER_2,
            PersonalityTrait.ENTERTAINER_3,
            PersonalityTrait.ENTERTAINER_4,
            PersonalityTrait.ENTERTAINER_5,
            PersonalityTrait.ENTERTAINER_6,
            PersonalityTrait.ENTERTAINER_7,
            PersonalityTrait.ENTERTAINER_8
    );

    public static final  List<BondsEnum> BONDS_TRAITS = List.of(
            BondsEnum.ENTERTAINER_1,
            BondsEnum.ENTERTAINER_2,
            BondsEnum.ENTERTAINER_3,
            BondsEnum.ENTERTAINER_4,
            BondsEnum.ENTERTAINER_5,
            BondsEnum.ENTERTAINER_6
    );

    public static final List<FlawsEnum> FLAWS_TRAITS = List.of(
            FlawsEnum.ENTERTAINER_1,
            FlawsEnum.ENTERTAINER_2,
            FlawsEnum.ENTERTAINER_3,
            FlawsEnum.ENTERTAINER_4,
            FlawsEnum.ENTERTAINER_5,
            FlawsEnum.ENTERTAINER_6
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
            ideals.add(IdealEnum.ENTERTAINER_2);
        }
        // CHAOTIC
        if (AlignmentEnum.getChaotic().contains(alignment)) {
            ideals.add(IdealEnum.ENTERTAINER_3);
        }
        // GOOD
        if (AlignmentEnum.getGood().contains(alignment)) {
            ideals.add(IdealEnum.ENTERTAINER_1);
        }
        // EVIL
        if (AlignmentEnum.getEvil().contains(alignment)) {
            ideals.add(IdealEnum.ENTERTAINER_4);
        }
        // NEUTRAL
        if (AlignmentEnum.getNeutral().contains(alignment)) {
            ideals.add(IdealEnum.ENTERTAINER_5);
        }
        ideals.add(IdealEnum.ENTERTAINER_6);
        return ideals.get(random.nextInt(ideals.size()));
    }

    @Override
    protected PersonalityTrait generatePersonalityTrait() {
        return PERSONALITY_TRAITS.get(random.nextInt(PERSONALITY_TRAITS.size()));
    }

    @Override
    public BackgroundEnum getBackgroundName() {
        return BackgroundEnum.ENTERTAINER;
    }

}
