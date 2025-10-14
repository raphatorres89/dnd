package com.raphaowl.dnd.service.generators;

import java.util.List;

import com.raphaowl.dnd.enums.ClassEnum;
import com.raphaowl.dnd.enums.GenderEnum;
import com.raphaowl.dnd.enums.RaceEnum;

import org.springframework.stereotype.Component;

@Component
public class DragonbornNpcGenerator extends AbstractNpcGenerator {

    public static final List<String> DRAGONBORN_NAMES_MALE = List.of(
            "Arjhan", "Balasar", "Donaar", "Ghesh", "Heskan",
            "Kriv", "Medrash", "Nadarr", "Pantor", "Rhos",
            "Sarkhan", "Syllin", "Torinn", "Varis", "Zark",
            "Daar", "Fax", "Izall", "Jareeth", "Kez",
            "Morthos", "Nyx", "Rath", "Sarrus", "Tem",
            "Uadjit", "Veer", "Vrak", "Xaele", "Yarjan"
    );

    public static final List<String> DRAGONBORN_NAMES_FEMALE = List.of(
            "Akra", "Biri", "Daar", "Farideh", "Harann",
            "Jaxi", "Kava", "Korinn", "Mishann", "Nala",
            "Perra", "Raiann", "Sora", "Surina", "Thava",
            "Ulla", "Vatra", "Yeva", "Zanna", "Averon",
            "Fionn", "Kaska", "Lia", "Rhaella", "Serana",
            "Tiamor", "Vessa", "Wyla", "Xanthe", "Zylos"
    );

    private static final List<ClassEnum> PREFERRED_CLASSES = List.of(
            ClassEnum.PALADIN, ClassEnum.SORCERER, ClassEnum.BARBARIAN,
            ClassEnum.FIGHTER, ClassEnum.WARLOCK
    );

    @Override
    public RaceEnum getRaceName() {
        return RaceEnum.DRAGONBORN;
    }

    @Override
    protected List<ClassEnum> getPreferredClasses() {
        return PREFERRED_CLASSES;
    }

    @Override
    protected String generateName(GenderEnum gender) {
        if (gender.equals(GenderEnum.MALE)) {
            return DRAGONBORN_NAMES_MALE.get(random.nextInt(DRAGONBORN_NAMES_MALE.size()));
        }
        return DRAGONBORN_NAMES_FEMALE.get(random.nextInt(DRAGONBORN_NAMES_FEMALE.size()));
    }
}