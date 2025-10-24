package com.raphaowl.dnd.service.generators.npcs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

import com.raphaowl.dnd.dtos.Armor;
import com.raphaowl.dnd.dtos.Background;
import com.raphaowl.dnd.dtos.Item;
import com.raphaowl.dnd.dtos.Npc;
import com.raphaowl.dnd.dtos.NpcFilterDto;
import com.raphaowl.dnd.dtos.NpcStats;
import com.raphaowl.dnd.enums.AbilityScoreEnum;
import com.raphaowl.dnd.enums.AlignmentEnum;
import com.raphaowl.dnd.enums.ArmorTypeEnum;
import com.raphaowl.dnd.enums.ClassEnum;
import com.raphaowl.dnd.enums.GenderEnum;
import com.raphaowl.dnd.service.generators.alignment.AlignmentGenerator;
import com.raphaowl.dnd.service.generators.background.BackgroundFactory;
import com.raphaowl.dnd.service.generators.background.BackgroundGenerator;
import com.raphaowl.dnd.service.generators.classes.ClassesFactory;
import com.raphaowl.dnd.service.generators.classes.ClassesGenerator;
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
    private ClassesFactory classesFactory;

    protected abstract String generateName(GenderEnum gender);
    protected abstract List<ClassEnum> getPreferredClasses();

    @Override
    public Npc generate(NpcFilterDto filter) {
        GenderEnum gender = selectGender(filter.gender());
        ClassEnum clazz = selectClass(filter.className());
        AlignmentEnum alignment = alignmentGenerator.generateAlignment(getRaceName(), clazz);
        BackgroundGenerator backgroundGenerator = backgroundFactory.getGenerator(filter.background());
        Background background = backgroundGenerator.generate(alignment);
        ClassesGenerator classesGenerator = classesFactory.getGenerator(clazz);
        List<Item> items = new ArrayList<>();
        items.addAll(classesGenerator.getItems());
        items.addAll(backgroundGenerator.getItems());

        Integer challengeRating = filter.level();
        Integer proficiencyBonus = calculateProficiencyBonus(challengeRating);

        NpcStats npcStats = npcStatsGenerator.generateStats(clazz, getRaceName(), filter.level());
        Integer hp = classesGenerator.getHP(filter.level(), npcStats.attributes().get(AbilityScoreEnum.CON));
        Integer armorClass = calculateArmorClass(npcStats, items);

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
                armorClass,
                items);
    }

    private static int calculateArmorClass(NpcStats npcStats, List<Item> items) {
        Integer armorClass = 0;

        Optional<Item> shieldOpt = items.stream()
                .filter(item -> item instanceof Armor && ((Armor) item).getType() == ArmorTypeEnum.SHIELD)
                .findFirst();

        if (shieldOpt.isPresent()) {
            Armor shield = (Armor) shieldOpt.get();
            armorClass += shield.getAc();
        }

        Optional<Item> armorOpt = items.stream()
                .filter(item -> item instanceof Armor && ((Armor) item).getType() != ArmorTypeEnum.SHIELD)
                .findFirst();

        if (armorOpt.isPresent()) {
            Armor armor = (Armor) armorOpt.get();
            int baseAC = armor.getAc();
            if (armor.getType() == ArmorTypeEnum.LIGHT) {
                return armorClass + baseAC + Math.floorDiv(npcStats.attributes().get(AbilityScoreEnum.DEX) - 10, 2);
            } else if (armor.getType() == ArmorTypeEnum.MEDIUM) {
                return armorClass + baseAC + Math.min(Math.floorDiv(npcStats.attributes().get(AbilityScoreEnum.DEX) - 10, 2), 2);
            } else {
                return armorClass + baseAC;
            }
        }
        return 10 + Math.floorDiv(npcStats.attributes().get(AbilityScoreEnum.DEX) - 10, 2);
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
