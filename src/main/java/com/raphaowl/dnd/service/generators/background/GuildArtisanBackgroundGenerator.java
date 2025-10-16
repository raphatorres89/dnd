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
public class GuildArtisanBackgroundGenerator extends AbstractBackgroundGenerator {

    public static final List<PersonalityTrait> PERSONALITY_TRAITS = List.of(
            PersonalityTrait.GUILD_ARTISAN_1,
            PersonalityTrait.GUILD_ARTISAN_2,
            PersonalityTrait.GUILD_ARTISAN_3,
            PersonalityTrait.GUILD_ARTISAN_4,
            PersonalityTrait.GUILD_ARTISAN_5,
            PersonalityTrait.GUILD_ARTISAN_6,
            PersonalityTrait.GUILD_ARTISAN_7,
            PersonalityTrait.GUILD_ARTISAN_8
    );

    public static final  List<BondsEnum> BONDS_TRAITS = List.of(
            BondsEnum.GUILD_ARTISAN_1,
            BondsEnum.GUILD_ARTISAN_2,
            BondsEnum.GUILD_ARTISAN_3,
            BondsEnum.GUILD_ARTISAN_4,
            BondsEnum.GUILD_ARTISAN_5,
            BondsEnum.GUILD_ARTISAN_6
    );

    public static final List<FlawsEnum> FLAWS_TRAITS = List.of(
            FlawsEnum.GUILD_ARTISAN_1,
            FlawsEnum.GUILD_ARTISAN_2,
            FlawsEnum.GUILD_ARTISAN_3,
            FlawsEnum.GUILD_ARTISAN_4,
            FlawsEnum.GUILD_ARTISAN_5,
            FlawsEnum.GUILD_ARTISAN_6
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
            ideals.add(IdealEnum.GUILD_ARTISAN_1);
        }
        // CHAOTIC
        if (AlignmentEnum.getChaotic().contains(alignment)) {
            ideals.add(IdealEnum.GUILD_ARTISAN_3);
        }
        // GOOD
        if (AlignmentEnum.getGood().contains(alignment)) {
            ideals.add(IdealEnum.GUILD_ARTISAN_2);
        }
        // EVIL
        if (AlignmentEnum.getEvil().contains(alignment)) {
            ideals.add(IdealEnum.GUILD_ARTISAN_4);
        }
        // NEUTRAL
        if (AlignmentEnum.getNeutral().contains(alignment)) {
            ideals.add(IdealEnum.GUILD_ARTISAN_5);
        }
        ideals.add(IdealEnum.GUILD_ARTISAN_6);
        return ideals.get(random.nextInt(ideals.size()));
    }

    @Override
    protected PersonalityTrait generatePersonalityTrait() {
        return PERSONALITY_TRAITS.get(random.nextInt(PERSONALITY_TRAITS.size()));
    }

    @Override
    public BackgroundEnum getBackgroundName() {
        return BackgroundEnum.GUILD_ARTISAN;
    }

}
