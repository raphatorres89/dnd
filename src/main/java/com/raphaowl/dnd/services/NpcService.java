package com.raphaowl.dnd.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import com.raphaowl.dnd.dtos.Npc;
import com.raphaowl.dnd.dtos.NpcFilterDto;
import com.raphaowl.dnd.services.generators.NpcFactory;
import com.raphaowl.dnd.services.generators.NpcGenerator;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class NpcService {

    private final NpcFactory npcFactory;
    public List<Npc> generateNpcs(NpcFilterDto filter, int count) {
        List<Npc> npcs = new ArrayList<>();

        IntStream.range(0, count).forEach(i -> {
            NpcGenerator generator = npcFactory.getGenerator(filter.race());
            npcs.add(generator.generate(filter));
        });

        return npcs;
    }
}