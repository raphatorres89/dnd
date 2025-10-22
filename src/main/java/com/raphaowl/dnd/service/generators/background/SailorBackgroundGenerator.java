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
 * Proficiência em Perícias: Atletismo, Percepção
 * Proficiência em Ferramentas: Ferramentas de
 * navegador, veículo (aquático)
 * Equipamento: Uma malagueta (clava), 15 metros de
 * corda de seda, uma amuleto da sorte como um pé de
 * coelho ou uma pequena pedra com um furo no centro
 * (ou você pode rolar uma bugiganga da tabela
 * Bugigangas no capítulo 5), um conjunto de trajes
 * comuns e uma algibeira contendo 10 po
 */
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

    @Override
    public List<Item> getItems() {
        return List.of(
                WeaponEnum.GLAIVE.toWeapon(1),
                GearEnum.ROPE_SILK.toItem(1),
                // TODO implementar bugiganga
                GearEnum.CLOTHES_COMMON.toItem(1),
                GearEnum.POUCH.toItem(1),
                GearEnum.GOLD.toItem(10)
        );
    }
}
