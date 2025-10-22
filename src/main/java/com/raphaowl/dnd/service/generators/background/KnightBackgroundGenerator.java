package com.raphaowl.dnd.service.generators.background;

import java.util.ArrayList;
import java.util.List;

import com.raphaowl.dnd.dtos.Item;
import com.raphaowl.dnd.enums.AlignmentEnum;
import com.raphaowl.dnd.enums.BackgroundEnum;
import com.raphaowl.dnd.enums.BondsEnum;
import com.raphaowl.dnd.enums.FlawsEnum;
import com.raphaowl.dnd.enums.GearEnum;
import com.raphaowl.dnd.enums.IdealEnum;
import com.raphaowl.dnd.enums.PersonalityTrait;

import org.springframework.stereotype.Component;

/**
 * SAME AS NOBLE
 */
@Component
public class KnightBackgroundGenerator extends AbstractBackgroundGenerator {

    public static final List<PersonalityTrait> PERSONALITY_TRAITS = List.of(
            PersonalityTrait.KNIGHT_1,
            PersonalityTrait.KNIGHT_2,
            PersonalityTrait.KNIGHT_3,
            PersonalityTrait.KNIGHT_4,
            PersonalityTrait.KNIGHT_5,
            PersonalityTrait.KNIGHT_6,
            PersonalityTrait.KNIGHT_7,
            PersonalityTrait.KNIGHT_8
    );

    public static final  List<BondsEnum> BONDS_TRAITS = List.of(
            BondsEnum.KNIGHT_1,
            BondsEnum.KNIGHT_2,
            BondsEnum.KNIGHT_3,
            BondsEnum.KNIGHT_4,
            BondsEnum.KNIGHT_5,
            BondsEnum.KNIGHT_6
    );

    public static final List<FlawsEnum> FLAWS_TRAITS = List.of(
            FlawsEnum.KNIGHT_1,
            FlawsEnum.KNIGHT_2,
            FlawsEnum.KNIGHT_3,
            FlawsEnum.KNIGHT_4,
            FlawsEnum.KNIGHT_5,
            FlawsEnum.KNIGHT_6
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
            ideals.add(IdealEnum.KNIGHT_1);
            ideals.add(IdealEnum.KNIGHT_6);
        }
        // CHAOTIC
        if (AlignmentEnum.getChaotic().contains(alignment)) {
            ideals.add(IdealEnum.KNIGHT_3);
        }
        // GOOD
        if (AlignmentEnum.getGood().contains(alignment)) {
            ideals.add(IdealEnum.KNIGHT_2);
        }
        // EVIL
        if (AlignmentEnum.getEvil().contains(alignment)) {
            ideals.add(IdealEnum.KNIGHT_4);
        }
        ideals.add(IdealEnum.KNIGHT_5);
        return ideals.get(random.nextInt(ideals.size()));
    }

    @Override
    protected PersonalityTrait generatePersonalityTrait() {
        return PERSONALITY_TRAITS.get(random.nextInt(PERSONALITY_TRAITS.size()));
    }

    @Override
    public BackgroundEnum getBackgroundName() {
        return BackgroundEnum.KNIGHT;
    }

    @Override
    public List<Item> getItems() {
        return List.of(
                GearEnum.CLOTHES_FINE.toItem(1),
                GearEnum.SIGNET_RING.toItem(1),
                GearEnum.LINEAGE_SCROLL.toItem(1),
                GearEnum.POUCH.toItem(1),
                GearEnum.GOLD.toItem(25)
        );
    }
}
