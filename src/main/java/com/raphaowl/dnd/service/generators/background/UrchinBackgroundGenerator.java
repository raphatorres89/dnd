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

    public static final  List<BondsEnum> BONDS_TRAITS = List.of(
            BondsEnum.URCHIN_1,
            BondsEnum.URCHIN_2,
            BondsEnum.URCHIN_3,
            BondsEnum.URCHIN_4,
            BondsEnum.URCHIN_5,
            BondsEnum.URCHIN_6
    );

    public static final List<FlawsEnum> FLAWS_TRAITS = List.of(
            FlawsEnum.URCHIN_1,
            FlawsEnum.URCHIN_2,
            FlawsEnum.URCHIN_3,
            FlawsEnum.URCHIN_4,
            FlawsEnum.URCHIN_5,
            FlawsEnum.URCHIN_6
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
            ideals.add(IdealEnum.URCHIN_2);
        }
        // CHAOTIC
        if (AlignmentEnum.getChaotic().contains(alignment)) {
            ideals.add(IdealEnum.URCHIN_3);
        }
        // GOOD
        if (AlignmentEnum.getGood().contains(alignment)) {
            ideals.add(IdealEnum.URCHIN_1);
        }
        // EVIL
        if (AlignmentEnum.getEvil().contains(alignment)) {
            ideals.add(IdealEnum.URCHIN_4);
        }
        // NEUTRAL
        if (AlignmentEnum.getNeutral().contains(alignment)) {
            ideals.add(IdealEnum.URCHIN_5);
        }
        ideals.add(IdealEnum.URCHIN_6);
        return ideals.get(random.nextInt(ideals.size()));
    }

    @Override
    protected PersonalityTrait generatePersonalityTrait() {
        return PERSONALITY_TRAITS.get(random.nextInt(PERSONALITY_TRAITS.size()));
    }

    @Override
    public BackgroundEnum getBackgroundName() {
        return BackgroundEnum.URCHIN;
    }

}
