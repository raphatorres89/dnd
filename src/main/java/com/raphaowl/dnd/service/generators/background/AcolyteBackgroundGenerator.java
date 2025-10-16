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
public class AcolyteBackgroundGenerator extends AbstractBackgroundGenerator {

    public static final List<PersonalityTrait> PERSONALITY_TRAITS = List.of(
            PersonalityTrait.ACOLYTE_1,
            PersonalityTrait.ACOLYTE_2,
            PersonalityTrait.ACOLYTE_3,
            PersonalityTrait.ACOLYTE_4,
            PersonalityTrait.ACOLYTE_5,
            PersonalityTrait.ACOLYTE_6,
            PersonalityTrait.ACOLYTE_7,
            PersonalityTrait.ACOLYTE_8
    );

    public static final  List<BondsEnum> BONDS_TRAITS = List.of(
            BondsEnum.ACOLYTE_1,
            BondsEnum.ACOLYTE_2,
            BondsEnum.ACOLYTE_3,
            BondsEnum.ACOLYTE_4,
            BondsEnum.ACOLYTE_5,
            BondsEnum.ACOLYTE_6
    );

    public static final List<FlawsEnum> FLAWS_TRAITS = List.of(
            FlawsEnum.ACOLYTE_1,
            FlawsEnum.ACOLYTE_2,
            FlawsEnum.ACOLYTE_3,
            FlawsEnum.ACOLYTE_4,
            FlawsEnum.ACOLYTE_5,
            FlawsEnum.ACOLYTE_6
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
            ideals.add(IdealEnum.ACOLYTE_1);
            ideals.add(IdealEnum.ACOLYTE_4);
            ideals.add(IdealEnum.ACOLYTE_5);
        }
        // GOOD
        if (AlignmentEnum.getGood().contains(alignment)) {
            ideals.add(IdealEnum.ACOLYTE_2);
        }
        // EVIL
        if (AlignmentEnum.getChaotic().contains(alignment)) {
            ideals.add(IdealEnum.ACOLYTE_3);
        }
        ideals.add(IdealEnum.ACOLYTE_6); // ANY
        return ideals.get(random.nextInt(ideals.size()));
    }

    @Override
    protected PersonalityTrait generatePersonalityTrait() {
        return PERSONALITY_TRAITS.get(random.nextInt(PERSONALITY_TRAITS.size()));
    }

    @Override
    public BackgroundEnum getBackgroundName() {
        return BackgroundEnum.ACOLYTE;
    }

}
