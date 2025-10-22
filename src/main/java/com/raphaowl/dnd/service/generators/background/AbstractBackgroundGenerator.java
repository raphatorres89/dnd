package com.raphaowl.dnd.service.generators.background;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.raphaowl.dnd.dtos.Background;
import com.raphaowl.dnd.dtos.Item;
import com.raphaowl.dnd.enums.AlignmentEnum;
import com.raphaowl.dnd.enums.BondsEnum;
import com.raphaowl.dnd.enums.FlawsEnum;
import com.raphaowl.dnd.enums.IdealEnum;
import com.raphaowl.dnd.enums.PersonalityTrait;
import com.raphaowl.dnd.enums.ToolEnum;
import com.raphaowl.dnd.enums.ToolTypeEnum;

import org.springframework.stereotype.Component;

@Component
public abstract class AbstractBackgroundGenerator implements BackgroundGenerator {

    protected final Random random = new Random();

    protected abstract PersonalityTrait generatePersonalityTrait();

    protected abstract IdealEnum generateIdeal(AlignmentEnum alignment);

    protected abstract BondsEnum generateBonds();

    protected abstract FlawsEnum generateFlaws();

    public Background generate(AlignmentEnum alignment) {
        return new Background(
                getBackgroundName(),
                generatePersonalityTrait(),
                generateIdeal(alignment),
                generateBonds(),
                generateFlaws()
        );
    }

    protected Item getAnyArtisanTool() {
        List<ToolEnum> items = ToolEnum.getByType(ToolTypeEnum.ARTISAN);
        return items.get(random.nextInt(items.size())).toItem(1);
    }

    protected Item getAnyMusicalInstrument() {
        List<ToolEnum> items = ToolEnum.getByType(ToolTypeEnum.MUSICAL);
        return items.get(random.nextInt(items.size())).toItem(1);
    }
}
