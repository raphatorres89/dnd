package com.raphaowl.dnd.service.generators.items;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.raphaowl.dnd.enums.ClassEnum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemFactory {
    private final Map<ClassEnum, ItemGenerator> generatorsMap;

    @Autowired
    public ItemFactory(List<ItemGenerator> generators) {
        this.generatorsMap = generators.stream()
                .collect(Collectors.toMap(
                        ItemGenerator::getClassName,
                        Function.identity()
                ));
    }

    public ItemGenerator getGenerator(ClassEnum classEnum) {
        ItemGenerator itemGenerator = generatorsMap.get(classEnum);
        if (itemGenerator == null) {
            List<ItemGenerator> items = List.copyOf(generatorsMap.values());
            Random random = new Random();
            return items.get(random.nextInt(items.size()));
        }
        return itemGenerator;
    }
}
