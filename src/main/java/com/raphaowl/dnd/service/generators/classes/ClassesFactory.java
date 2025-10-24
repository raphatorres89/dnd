package com.raphaowl.dnd.service.generators.classes;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.raphaowl.dnd.enums.ClassEnum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassesFactory {
    private final Map<ClassEnum, ClassesGenerator> generatorsMap;

    @Autowired
    public ClassesFactory(List<ClassesGenerator> generators) {
        this.generatorsMap = generators.stream()
                .collect(Collectors.toMap(
                        ClassesGenerator::getClassName,
                        Function.identity()
                ));
    }

    public ClassesGenerator getGenerator(ClassEnum classEnum) {
        ClassesGenerator classesGenerator = generatorsMap.get(classEnum);
        if (classesGenerator == null) {
            List<ClassesGenerator> items = List.copyOf(generatorsMap.values());
            Random random = new Random();
            return items.get(random.nextInt(items.size()));
        }
        return classesGenerator;
    }
}
