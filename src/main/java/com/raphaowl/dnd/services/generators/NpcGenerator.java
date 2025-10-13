package com.raphaowl.dnd.services.generators;

import com.raphaowl.dnd.dtos.Npc;
import com.raphaowl.dnd.dtos.NpcFilterDto;
import com.raphaowl.dnd.enums.RaceEnum;

public interface NpcGenerator {
    RaceEnum getRaceName();
    Npc generate(NpcFilterDto filter);
}
