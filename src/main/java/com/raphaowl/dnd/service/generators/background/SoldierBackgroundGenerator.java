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

    public static final  List<BondsEnum> BONDS_TRAITS = List.of(
            BondsEnum.SOLDIER_1,
            BondsEnum.SOLDIER_2,
            BondsEnum.SOLDIER_3,
            BondsEnum.SOLDIER_4,
            BondsEnum.SOLDIER_5,
            BondsEnum.SOLDIER_6
    );

    public static final List<FlawsEnum> FLAWS_TRAITS = List.of(
            FlawsEnum.SOLDIER_1,
            FlawsEnum.SOLDIER_2,
            FlawsEnum.SOLDIER_3,
            FlawsEnum.SOLDIER_4,
            FlawsEnum.SOLDIER_5,
            FlawsEnum.SOLDIER_6
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
            ideals.add(IdealEnum.SOLDIER_2);
        }
        // CHAOTIC
        if (AlignmentEnum.getChaotic().contains(alignment)) {
            ideals.add(IdealEnum.SOLDIER_3);
        }
        // GOOD
        if (AlignmentEnum.getGood().contains(alignment)) {
            ideals.add(IdealEnum.SOLDIER_1);
        }
        // EVIL
        if (AlignmentEnum.getEvil().contains(alignment)) {
            ideals.add(IdealEnum.SOLDIER_4);
        }
        // NEUTRAL
        if (AlignmentEnum.getNeutral().contains(alignment)) {
            ideals.add(IdealEnum.SOLDIER_5);
        }
        ideals.add(IdealEnum.SOLDIER_6);
        return ideals.get(random.nextInt(ideals.size()));
    }

    @Override
    protected PersonalityTrait generatePersonalityTrait() {
        return PERSONALITY_TRAITS.get(random.nextInt(PERSONALITY_TRAITS.size()));
    }

    @Override
    public BackgroundEnum getBackgroundName() {
        return BackgroundEnum.SOLDIER;
    }

}
