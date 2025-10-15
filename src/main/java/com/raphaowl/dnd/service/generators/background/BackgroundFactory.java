package com.raphaowl.dnd.service.generators.background;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.raphaowl.dnd.enums.BackgroundEnum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BackgroundFactory {
    private final Map<BackgroundEnum, BackgroundGenerator> generatorsMap;

    @Autowired
    public BackgroundFactory(List<BackgroundGenerator> generators) {
        this.generatorsMap = generators.stream()
                .collect(Collectors.toMap(
                        BackgroundGenerator::getBackgroundName,
                        Function.identity()
                ));
    }

    public BackgroundGenerator getGenerator(BackgroundEnum backgroundEnum) {
        BackgroundGenerator generator = generatorsMap.get(backgroundEnum);
        if (generator == null) {
            List<BackgroundGenerator> backgrounds = List.copyOf(generatorsMap.values());
            Random random = new Random();
            return backgrounds.get(random.nextInt(backgrounds.size()));
        }
        return generator;
    }
}
