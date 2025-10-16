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
public class NobleBackgroundGenerator extends AbstractBackgroundGenerator {

    public static final List<PersonalityTrait> PERSONALITY_TRAITS = List.of(
            PersonalityTrait.NOBLE_1,
            PersonalityTrait.NOBLE_2,
            PersonalityTrait.NOBLE_3,
            PersonalityTrait.NOBLE_4,
            PersonalityTrait.NOBLE_5,
            PersonalityTrait.NOBLE_6,
            PersonalityTrait.NOBLE_7,
            PersonalityTrait.NOBLE_8
    );

    public static final  List<BondsEnum> BONDS_TRAITS = List.of(
            BondsEnum.NOBLE_1,
            BondsEnum.NOBLE_2,
            BondsEnum.NOBLE_3,
            BondsEnum.NOBLE_4,
            BondsEnum.NOBLE_5,
            BondsEnum.NOBLE_6
    );

    public static final List<FlawsEnum> FLAWS_TRAITS = List.of(
            FlawsEnum.NOBLE_1,
            FlawsEnum.NOBLE_2,
            FlawsEnum.NOBLE_3,
            FlawsEnum.NOBLE_4,
            FlawsEnum.NOBLE_5,
            FlawsEnum.NOBLE_6
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
            ideals.add(IdealEnum.NOBLE_2);
        }
        // CHAOTIC
        if (AlignmentEnum.getChaotic().contains(alignment)) {
            ideals.add(IdealEnum.NOBLE_3);
        }
        // GOOD
        if (AlignmentEnum.getGood().contains(alignment)) {
            ideals.add(IdealEnum.NOBLE_1);
            ideals.add(IdealEnum.NOBLE_6);
        }
        // EVIL
        if (AlignmentEnum.getEvil().contains(alignment)) {
            ideals.add(IdealEnum.NOBLE_4);
        }
        ideals.add(IdealEnum.NOBLE_5);
        return ideals.get(random.nextInt(ideals.size()));
    }

    @Override
    protected PersonalityTrait generatePersonalityTrait() {
        return PERSONALITY_TRAITS.get(random.nextInt(PERSONALITY_TRAITS.size()));
    }

    @Override
    public BackgroundEnum getBackgroundName() {
        return BackgroundEnum.NOBLE;
    }

}
