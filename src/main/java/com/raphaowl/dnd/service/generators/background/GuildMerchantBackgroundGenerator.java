package com.raphaowl.dnd.service.generators.background;

import java.util.List;

import com.raphaowl.dnd.enums.BackgroundEnum;
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

    public static final List<IdealEnum> IDEALS = List.of(
            IdealEnum.GUILD_MERCHANT_1,
            IdealEnum.GUILD_MERCHANT_2,
            IdealEnum.GUILD_MERCHANT_3,
            IdealEnum.GUILD_MERCHANT_4,
            IdealEnum.GUILD_MERCHANT_5,
            IdealEnum.GUILD_MERCHANT_6
    );

    @Override
    protected IdealEnum generateIdealTrait() {
        return IDEALS.get(random.nextInt(IDEALS.size()));
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
