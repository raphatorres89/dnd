package com.raphaowl.dnd.service.generators;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.raphaowl.dnd.enums.RaceEnum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NpcFactory {
    private final Map<RaceEnum, NpcGenerator> generatorsMap;

    @Autowired
    public NpcFactory(List<NpcGenerator> generators) {
        this.generatorsMap = generators.stream()
                .collect(Collectors.toMap(
                        NpcGenerator::getRaceName,
                        Function.identity()
                ));
    }

    public NpcGenerator getGenerator(RaceEnum race) {
        NpcGenerator generator = generatorsMap.get(race);
        if (generator == null) {
            List<NpcGenerator> races = List.copyOf(generatorsMap.values());
            Random random = new Random();
            return races.get(random.nextInt(races.size()));
        }
        return generator;
    }
}
