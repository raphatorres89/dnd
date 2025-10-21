package com.raphaowl.dnd.service.generators.race;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.raphaowl.dnd.enums.ClassEnum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RaceFactory {
    private final Map<ClassEnum, RaceGenerator> generatorsMap;

    @Autowired
    public RaceFactory(List<RaceGenerator> generators) {
        this.generatorsMap = generators.stream()
                .collect(Collectors.toMap(
                        RaceGenerator::getClassName,
                        Function.identity()
                ));
    }

    public RaceGenerator getGenerator(ClassEnum classEnum) {
        RaceGenerator raceGenerator = generatorsMap.get(classEnum);
        if (raceGenerator == null) {
            List<RaceGenerator> items = List.copyOf(generatorsMap.values());
            Random random = new Random();
            return items.get(random.nextInt(items.size()));
        }
        return raceGenerator;
    }
}
