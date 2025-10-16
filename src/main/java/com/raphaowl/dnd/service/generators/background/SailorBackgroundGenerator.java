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
public class SailorBackgroundGenerator extends AbstractBackgroundGenerator {

    public static final List<PersonalityTrait> PERSONALITY_TRAITS = List.of(
            PersonalityTrait.SAILOR_1,
            PersonalityTrait.SAILOR_2,
            PersonalityTrait.SAILOR_3,
            PersonalityTrait.SAILOR_4,
            PersonalityTrait.SAILOR_5,
            PersonalityTrait.SAILOR_6,
            PersonalityTrait.SAILOR_7,
            PersonalityTrait.SAILOR_8
    );

    public static final  List<BondsEnum> BONDS_TRAITS = List.of(
            BondsEnum.SAILOR_1,
            BondsEnum.SAILOR_2,
            BondsEnum.SAILOR_3,
            BondsEnum.SAILOR_4,
            BondsEnum.SAILOR_5,
            BondsEnum.SAILOR_6
    );

    public static final List<FlawsEnum> FLAWS_TRAITS = List.of(
            FlawsEnum.SAILOR_1,
            FlawsEnum.SAILOR_2,
            FlawsEnum.SAILOR_3,
            FlawsEnum.SAILOR_4,
            FlawsEnum.SAILOR_5,
            FlawsEnum.SAILOR_6
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
            ideals.add(IdealEnum.SAILOR_2);
        }
        // CHAOTIC
        if (AlignmentEnum.getChaotic().contains(alignment)) {
            ideals.add(IdealEnum.SAILOR_3);
        }
        // GOOD
        if (AlignmentEnum.getGood().contains(alignment)) {
            ideals.add(IdealEnum.SAILOR_1);
        }
        // EVIL
        if (AlignmentEnum.getEvil().contains(alignment)) {
            ideals.add(IdealEnum.SAILOR_4);
        }
        // NEUTRAL
        if (AlignmentEnum.getNeutral().contains(alignment)) {
            ideals.add(IdealEnum.SAILOR_5);
        }
        ideals.add(IdealEnum.SAILOR_6);
        return ideals.get(random.nextInt(ideals.size()));
    }

    @Override
    protected PersonalityTrait generatePersonalityTrait() {
        return PERSONALITY_TRAITS.get(random.nextInt(PERSONALITY_TRAITS.size()));
    }

    @Override
    public BackgroundEnum getBackgroundName() {
        return BackgroundEnum.SAILOR;
    }

}
