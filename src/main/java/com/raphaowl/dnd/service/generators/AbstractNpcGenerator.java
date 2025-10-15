package com.raphaowl.dnd.service.generators;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import com.raphaowl.dnd.dtos.Npc;
import com.raphaowl.dnd.dtos.NpcFilterDto;
import com.raphaowl.dnd.enums.AlignmentEnum;
import com.raphaowl.dnd.enums.CharacteristicEnum;
import com.raphaowl.dnd.enums.ClassEnum;
import com.raphaowl.dnd.enums.GenderEnum;
import com.raphaowl.dnd.enums.MotivationEnum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public abstract class AbstractNpcGenerator implements NpcGenerator {

    protected final Random random = new Random();
    private static final double PREFERRED_CLASS_CHANCE = 0.80;

    @Autowired
    private AlignmentGenerator alignmentGenerator;

    protected abstract String generateName(GenderEnum gender);
    protected abstract List<ClassEnum> getPreferredClasses();

    @Override
    public Npc generate(NpcFilterDto filter) {

        GenderEnum gender = selectGender(filter.gender());

        ClassEnum clazz = selectClass(filter.className());

        AlignmentEnum alignment = alignmentGenerator.generateAlignment(getRaceName(), clazz);

        CharacteristicEnum characteristic = CharacteristicEnum.values()[random.nextInt(CharacteristicEnum.values().length)];

        MotivationEnum motivation = MotivationEnum.values()[random.nextInt(MotivationEnum.values().length)];

        return new Npc(
                generateName(gender),
                getRaceName(),
                gender,
                alignment,
                clazz,
                null,
                characteristic,
                motivation);
    }

    private GenderEnum selectGender(GenderEnum genderFilter) {
        if (genderFilter != null) {
            return genderFilter;
        }
        List<GenderEnum> allGenders = Arrays.asList(GenderEnum.values());
        return allGenders.get(random.nextInt(allGenders.size()));
    }

    private ClassEnum selectClass(ClassEnum classFilter) {
        if (classFilter != null) {
            return classFilter;
        }

        if (random.nextDouble() < PREFERRED_CLASS_CHANCE) {
            List<ClassEnum> preferredClasses = getPreferredClasses();
            return preferredClasses.get(random.nextInt(preferredClasses.size()));
        } else {
            List<ClassEnum> allClasses = Arrays.asList(ClassEnum.values());
            return allClasses.get(random.nextInt(allClasses.size()));
        }
    }

}
