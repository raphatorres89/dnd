package com.raphaowl.dnd.service.generators.npcs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import com.raphaowl.dnd.dtos.Background;
import com.raphaowl.dnd.dtos.Item;
import com.raphaowl.dnd.dtos.Npc;
import com.raphaowl.dnd.dtos.NpcFilterDto;
import com.raphaowl.dnd.dtos.NpcStats;
import com.raphaowl.dnd.enums.AbilityScoreEnum;
import com.raphaowl.dnd.enums.AlignmentEnum;
import com.raphaowl.dnd.enums.ClassEnum;
import com.raphaowl.dnd.enums.GenderEnum;
import com.raphaowl.dnd.service.generators.alignment.AlignmentGenerator;
import com.raphaowl.dnd.service.generators.background.BackgroundFactory;
import com.raphaowl.dnd.service.generators.background.BackgroundGenerator;
import com.raphaowl.dnd.service.generators.race.RaceFactory;
import com.raphaowl.dnd.service.generators.race.RaceGenerator;
import com.raphaowl.dnd.service.generators.stats.NpcStatsGenerator;

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
    @Autowired
    private NpcStatsGenerator npcStatsGenerator;
    @Autowired
    private RaceFactory raceFactory;

    protected abstract String generateName(GenderEnum gender);
    protected abstract List<ClassEnum> getPreferredClasses();

    @Override
    public Npc generate(NpcFilterDto filter) {
        GenderEnum gender = selectGender(filter.gender());
        ClassEnum clazz = selectClass(filter.className());
        AlignmentEnum alignment = alignmentGenerator.generateAlignment(getRaceName(), clazz);
        BackgroundGenerator backgroundGenerator = backgroundFactory.getGenerator(filter.background());
        Background background = backgroundGenerator.generate(alignment);
        RaceGenerator raceGenerator = raceFactory.getGenerator(clazz);
        List<Item> items = new ArrayList<>();
        items.addAll(raceGenerator.getItems());
        items.addAll(backgroundGenerator.getItems());

        Integer challengeRating = filter.challengeRating();
        Integer proficiencyBonus = calculateProficiencyBonus(challengeRating);

        NpcStats npcStats = npcStatsGenerator.generateStats(clazz, getRaceName(), filter.challengeRating());
        Integer hp = raceGenerator.getHP(filter.challengeRating(), npcStats.attributes().get(AbilityScoreEnum.CON));

        return new Npc(
                new UUID(random.nextLong(), random.nextLong()),
                generateName(gender),
                getRaceName(),
                gender,
                alignment,
                clazz,
                npcStats,
                background,
                proficiencyBonus,
                challengeRating,
                hp,
                null,
                items);
    }

    private Integer calculateProficiencyBonus(double challengeRating) {
        if (challengeRating < 5) {
            return 2;
        } else if (challengeRating < 9) {
            return 3;
        } else if (challengeRating < 13) {
            return 4;
        } else if (challengeRating < 17) {
            return 5;
        } else {
            return 6;
        }
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
