package com.raphaowl.dnd.service.generators.npcs;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import com.raphaowl.dnd.dtos.Npc;
import com.raphaowl.dnd.dtos.NpcFilterDto;
import com.raphaowl.dnd.enums.AlignmentEnum;
import com.raphaowl.dnd.enums.ClassEnum;
import com.raphaowl.dnd.enums.GenderEnum;
import com.raphaowl.dnd.service.generators.alignment.AlignmentGenerator;
import com.raphaowl.dnd.service.generators.background.BackgroundFactory;
import com.raphaowl.dnd.service.generators.background.BackgroundGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public abstract class AbstractNpcGenerator implements NpcGenerator {

    protected final Random random = new Random();
    private static final double PREFERRED_CLASS_CHANCE = 0.80;

    @Autowired
    private AlignmentGenerator alignmentGenerator;
    @Autowired
    private BackgroundFactory backgroundFactory;

    protected abstract String generateName(GenderEnum gender);
    protected abstract List<ClassEnum> getPreferredClasses();

    @Override
    public Npc generate(NpcFilterDto filter) {

        GenderEnum gender = selectGender(filter.gender());

        ClassEnum clazz = selectClass(filter.className());

        AlignmentEnum alignment = alignmentGenerator.generateAlignment(getRaceName(), clazz);

        BackgroundGenerator backgroundGenerator = backgroundFactory.getGenerator(filter.background());

        return new Npc(
                generateName(gender),
                getRaceName(),
                gender,
                alignment,
                clazz,
                null,
                backgroundGenerator.generate());
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
