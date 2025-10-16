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
public class GuildMerchantBackgroundGenerator extends AbstractBackgroundGenerator {

    public static final List<PersonalityTrait> PERSONALITY_TRAITS = List.of(
            PersonalityTrait.GUILD_MERCHANT_1,
            PersonalityTrait.GUILD_MERCHANT_2,
            PersonalityTrait.GUILD_MERCHANT_3,
            PersonalityTrait.GUILD_MERCHANT_4,
            PersonalityTrait.GUILD_MERCHANT_5,
            PersonalityTrait.GUILD_MERCHANT_6,
            PersonalityTrait.GUILD_MERCHANT_7,
            PersonalityTrait.GUILD_MERCHANT_8
    );

    public static final  List<BondsEnum> BONDS_TRAITS = List.of(
            BondsEnum.GUILD_MERCHANT_1,
            BondsEnum.GUILD_MERCHANT_2,
            BondsEnum.GUILD_MERCHANT_3,
            BondsEnum.GUILD_MERCHANT_4,
            BondsEnum.GUILD_MERCHANT_5,
            BondsEnum.GUILD_MERCHANT_6
    );

    public static final List<FlawsEnum> FLAWS_TRAITS = List.of(
            FlawsEnum.GUILD_MERCHANT_1,
            FlawsEnum.GUILD_MERCHANT_2,
            FlawsEnum.GUILD_MERCHANT_3,
            FlawsEnum.GUILD_MERCHANT_4,
            FlawsEnum.GUILD_MERCHANT_5,
            FlawsEnum.GUILD_MERCHANT_6
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
            ideals.add(IdealEnum.GUILD_MERCHANT_1);
        }
        // CHAOTIC
        if (AlignmentEnum.getChaotic().contains(alignment)) {
            ideals.add(IdealEnum.GUILD_MERCHANT_3);
        }
        // GOOD
        if (AlignmentEnum.getGood().contains(alignment)) {
            ideals.add(IdealEnum.GUILD_MERCHANT_4);
        }
        // EVIL
        if (AlignmentEnum.getEvil().contains(alignment)) {
            ideals.add(IdealEnum.GUILD_MERCHANT_5);
        }
        // NEUTRAL
        if (AlignmentEnum.getNeutral().contains(alignment)) {
            ideals.add(IdealEnum.GUILD_MERCHANT_2);
        }
        ideals.add(IdealEnum.GUILD_MERCHANT_6);
        return ideals.get(random.nextInt(ideals.size()));
    }

    @Override
    protected PersonalityTrait generatePersonalityTrait() {
        return PERSONALITY_TRAITS.get(random.nextInt(PERSONALITY_TRAITS.size()));
    }

    @Override
    public BackgroundEnum getBackgroundName() {
        return BackgroundEnum.GUILD_MERCHANT;
    }

}
