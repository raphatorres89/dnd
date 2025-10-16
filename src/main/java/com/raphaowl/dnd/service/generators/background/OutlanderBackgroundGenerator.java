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
public class OutlanderBackgroundGenerator extends AbstractBackgroundGenerator {

    public static final List<PersonalityTrait> PERSONALITY_TRAITS = List.of(
            PersonalityTrait.OUTLANDER_1,
            PersonalityTrait.OUTLANDER_2,
            PersonalityTrait.OUTLANDER_3,
            PersonalityTrait.OUTLANDER_4,
            PersonalityTrait.OUTLANDER_5,
            PersonalityTrait.OUTLANDER_6,
            PersonalityTrait.OUTLANDER_7,
            PersonalityTrait.OUTLANDER_8
    );

    public static final  List<BondsEnum> BONDS_TRAITS = List.of(
            BondsEnum.OUTLANDER_1,
            BondsEnum.OUTLANDER_2,
            BondsEnum.OUTLANDER_3,
            BondsEnum.OUTLANDER_4,
            BondsEnum.OUTLANDER_5,
            BondsEnum.OUTLANDER_6
    );

    public static final List<FlawsEnum> FLAWS_TRAITS = List.of(
            FlawsEnum.OUTLANDER_1,
            FlawsEnum.OUTLANDER_2,
            FlawsEnum.OUTLANDER_3,
            FlawsEnum.OUTLANDER_4,
            FlawsEnum.OUTLANDER_5,
            FlawsEnum.OUTLANDER_6
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
            ideals.add(IdealEnum.OUTLANDER_3);
        }
        // CHAOTIC
        if (AlignmentEnum.getChaotic().contains(alignment)) {
            ideals.add(IdealEnum.OUTLANDER_1);
        }
        // GOOD
        if (AlignmentEnum.getGood().contains(alignment)) {
            ideals.add(IdealEnum.OUTLANDER_2);
        }
        // EVIL
        if (AlignmentEnum.getEvil().contains(alignment)) {
            ideals.add(IdealEnum.OUTLANDER_4);
        }
        // NEUTRAL
        if (AlignmentEnum.getNeutral().contains(alignment)) {
            ideals.add(IdealEnum.OUTLANDER_5);
        }
        ideals.add(IdealEnum.OUTLANDER_6);
        return ideals.get(random.nextInt(ideals.size()));
    }

    @Override
    protected PersonalityTrait generatePersonalityTrait() {
        return PERSONALITY_TRAITS.get(random.nextInt(PERSONALITY_TRAITS.size()));
    }

    @Override
    public BackgroundEnum getBackgroundName() {
        return BackgroundEnum.OUTLANDER;
    }

}
