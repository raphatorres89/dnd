package com.raphaowl.dnd.service.generators.background;

import com.raphaowl.dnd.dtos.Background;
import com.raphaowl.dnd.enums.BackgroundEnum;

public interface BackgroundGenerator {
    BackgroundEnum getBackgroundName();
    Background generate();
}
