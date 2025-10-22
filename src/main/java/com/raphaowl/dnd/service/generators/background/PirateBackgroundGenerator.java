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
import com.raphaowl.dnd.enums.WeaponEnum;

import org.springframework.stereotype.Component;

/**
 * SAME AS THE SAILOR BACKGROUND
 */
@Component
public class PirateBackgroundGenerator extends AbstractBackgroundGenerator {

    public static final List<PersonalityTrait> PERSONALITY_TRAITS = List.of(
            PersonalityTrait.PIRATE_1,
            PersonalityTrait.PIRATE_2,
            PersonalityTrait.PIRATE_3,
            PersonalityTrait.PIRATE_4,
            PersonalityTrait.PIRATE_5,
            PersonalityTrait.PIRATE_6,
            PersonalityTrait.PIRATE_7,
            PersonalityTrait.PIRATE_8
    );

    public static final  List<BondsEnum> BONDS_TRAITS = List.of(
            BondsEnum.PIRATE_1,
            BondsEnum.PIRATE_2,
            BondsEnum.PIRATE_3,
            BondsEnum.PIRATE_4,
            BondsEnum.PIRATE_5,
            BondsEnum.PIRATE_6
    );

    public static final List<FlawsEnum> FLAWS_TRAITS = List.of(
            FlawsEnum.PIRATE_1,
            FlawsEnum.PIRATE_2,
            FlawsEnum.PIRATE_3,
            FlawsEnum.PIRATE_4,
            FlawsEnum.PIRATE_5,
            FlawsEnum.PIRATE_6
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
            ideals.add(IdealEnum.PIRATE_3);
        }
        // CHAOTIC
        if (AlignmentEnum.getChaotic().contains(alignment)) {
            ideals.add(IdealEnum.PIRATE_1);
        }
        // GOOD
        if (AlignmentEnum.getGood().contains(alignment)) {
            ideals.add(IdealEnum.PIRATE_6);
        }
        // EVIL
        if (AlignmentEnum.getEvil().contains(alignment)) {
            ideals.add(IdealEnum.PIRATE_2);
        }
        // NEUTRAL
        if (AlignmentEnum.getNeutral().contains(alignment)) {
            ideals.add(IdealEnum.PIRATE_5);
        }
        ideals.add(IdealEnum.PIRATE_4);
        return ideals.get(random.nextInt(ideals.size()));
    }

    @Override
    protected PersonalityTrait generatePersonalityTrait() {
        return PERSONALITY_TRAITS.get(random.nextInt(PERSONALITY_TRAITS.size()));
    }

    @Override
    public BackgroundEnum getBackgroundName() {
        return BackgroundEnum.PIRATE;
    }

    @Override
    public List<Item> getItems() {
        return List.of(
                WeaponEnum.GLAIVE.toWeapon(1),
                GearEnum.ROPE_SILK.toItem(1),
                // TODO implementar bugigangas
                GearEnum.CLOTHES_COMMON.toItem(1),
                GearEnum.POUCH.toItem(1),
                GearEnum.GOLD.toItem(10)
        );
    }
}
