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
import com.raphaowl.dnd.enums.ToolEnum;
import com.raphaowl.dnd.enums.ToolTypeEnum;

import org.springframework.stereotype.Component;

/**
 * Proficiência em Perícias: Enganação, Prestidigitação
 * Proficiência em Ferramentas: Kit de disfarce, kit de
 * falsificação
 * Equipamento: Um conjunto de roupas finas, um kit de
 * disfarce, ferramentas de trapaça, à sua escolha (dez
 * garrafas tampadas preenchidas com líquidos coloridos,
 * um conjunto de dados viciados, um baralho de cartas
 * marcadas ou um anel de sinete de um duque
 * imaginário), e uma algibeira contendo 15po
 */
@Component
public class CharlatanBackgroundGenerator extends AbstractBackgroundGenerator {

    public static final List<PersonalityTrait> PERSONALITY_TRAITS = List.of(
            PersonalityTrait.CHARLATAN_1,
            PersonalityTrait.CHARLATAN_2,
            PersonalityTrait.CHARLATAN_3,
            PersonalityTrait.CHARLATAN_4,
            PersonalityTrait.CHARLATAN_5,
            PersonalityTrait.CHARLATAN_6,
            PersonalityTrait.CHARLATAN_7,
            PersonalityTrait.CHARLATAN_8
    );

    public static final  List<BondsEnum> BONDS_TRAITS = List.of(
            BondsEnum.CHARLATAN_1,
            BondsEnum.CHARLATAN_2,
            BondsEnum.CHARLATAN_3,
            BondsEnum.CHARLATAN_4,
            BondsEnum.CHARLATAN_5,
            BondsEnum.CHARLATAN_6
    );

    public static final List<FlawsEnum> FLAWS_TRAITS = List.of(
            FlawsEnum.CHARLATAN_1,
            FlawsEnum.CHARLATAN_2,
            FlawsEnum.CHARLATAN_3,
            FlawsEnum.CHARLATAN_4,
            FlawsEnum.CHARLATAN_5,
            FlawsEnum.CHARLATAN_6
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
            ideals.add(IdealEnum.CHARLATAN_2);
        }
        // GOOD
        if (AlignmentEnum.getGood().contains(alignment)) {
            ideals.add(IdealEnum.CHARLATAN_3);
            ideals.add(IdealEnum.CHARLATAN_5);
        }
        // EVIL
        if (AlignmentEnum.getChaotic().contains(alignment)) {
            ideals.add(IdealEnum.CHARLATAN_1);
            ideals.add(IdealEnum.CHARLATAN_4); // ANY
        }
        ideals.add(IdealEnum.CHARLATAN_6); // ANY
        return ideals.get(random.nextInt(ideals.size()));
    }

    @Override
    protected PersonalityTrait generatePersonalityTrait() {
        return PERSONALITY_TRAITS.get(random.nextInt(PERSONALITY_TRAITS.size()));
    }

    @Override
    public BackgroundEnum getBackgroundName() {
        return BackgroundEnum.CHARLATAN;
    }

    @Override
    public List<Item> getItems() {
        return List.of(
                GearEnum.CLOTHES_FINE.toItem(1),
                ToolEnum.DISGUISE_KIT.toItem(1),
                getCheatingTool(),
                GearEnum.POUCH.toItem(1),
                GearEnum.GOLD.toItem(15)
        );
    }

    private Item getCheatingTool() {
        List<ToolEnum> items = ToolEnum.getByType(ToolTypeEnum.CHEATING);
        return items.get(random.nextInt(items.size())).toItem(1);
    }
}
