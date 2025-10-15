package com.raphaowl.dnd.service.generators.background;

import java.util.Random;

import com.raphaowl.dnd.dtos.Background;
import com.raphaowl.dnd.enums.PersonalityTrait;

import org.springframework.stereotype.Component;

@Component
public abstract class AbstractBackgroundGenerator implements BackgroundGenerator {

    protected final Random random = new Random();

    protected abstract PersonalityTrait generatePersonalityTrait();

    public Background generate() {
        return new Background(
                getBackgroundName(),
                generatePersonalityTrait()
        );
    }
}
