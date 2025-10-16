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
public class CriminalBackgroundGenerator extends AbstractBackgroundGenerator {

    public static final List<PersonalityTrait> PERSONALITY_TRAITS = List.of(
            PersonalityTrait.CRIMINAL_1,
            PersonalityTrait.CRIMINAL_2,
            PersonalityTrait.CRIMINAL_3,
            PersonalityTrait.CRIMINAL_4,
            PersonalityTrait.CRIMINAL_5,
            PersonalityTrait.CRIMINAL_6,
            PersonalityTrait.CRIMINAL_7,
            PersonalityTrait.CRIMINAL_8
    );

    public static final  List<BondsEnum> BONDS_TRAITS = List.of(
            BondsEnum.CRIMINAL_1,
            BondsEnum.CRIMINAL_2,
            BondsEnum.CRIMINAL_3,
            BondsEnum.CRIMINAL_4,
            BondsEnum.CRIMINAL_5,
            BondsEnum.CRIMINAL_6
    );

    public static final List<FlawsEnum> FLAWS_TRAITS = List.of(
            FlawsEnum.CRIMINAL_1,
            FlawsEnum.CRIMINAL_2,
            FlawsEnum.CRIMINAL_3,
            FlawsEnum.CRIMINAL_4,
            FlawsEnum.CRIMINAL_5,
            FlawsEnum.CRIMINAL_6
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
            ideals.add(IdealEnum.CRIMINAL_1);
        }
        // CHAOTIC
        if (AlignmentEnum.getChaotic().contains(alignment)) {
            ideals.add(IdealEnum.CRIMINAL_2);
        }
        // GOOD
        if (AlignmentEnum.getGood().contains(alignment)) {
            ideals.add(IdealEnum.CRIMINAL_3);
            ideals.add(IdealEnum.CRIMINAL_6);
        }
        // EVIL
        if (AlignmentEnum.getEvil().contains(alignment)) {
            ideals.add(IdealEnum.CRIMINAL_4);
        }
        // NEUTRAL
        if (AlignmentEnum.getNeutral().contains(alignment)) {
            ideals.add(IdealEnum.CRIMINAL_5);
        }
        return ideals.get(random.nextInt(ideals.size()));
    }

    @Override
    protected PersonalityTrait generatePersonalityTrait() {
        return PERSONALITY_TRAITS.get(random.nextInt(PERSONALITY_TRAITS.size()));
    }

    @Override
    public BackgroundEnum getBackgroundName() {
        return BackgroundEnum.CRIMINAL;
    }

}
