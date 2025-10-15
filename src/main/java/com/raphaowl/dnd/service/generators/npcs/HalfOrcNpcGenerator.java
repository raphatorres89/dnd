package com.raphaowl.dnd.service.generators.npcs;

import java.util.List;

import com.raphaowl.dnd.enums.ClassEnum;
import com.raphaowl.dnd.enums.GenderEnum;
import com.raphaowl.dnd.enums.RaceEnum;

import org.springframework.stereotype.Component;

@Component
public class HalfOrcNpcGenerator extends AbstractNpcGenerator {

    public static final List<String> HALF_ORC_NAMES_MALE = List.of(
            "Dench", "Fendrel", "Gnarsh", "Gruum", "Hord",
            "Imsh", "Kail", "Mur", "Narg", "Oth",
            "Shag", "Tark", "Ug", "Vark", "Yarg",
            "Bruz", "Keth", "Roric", "Skarn", "Tharr",
            "Gruk", "Vol", "Zud", "Harg", "Brak"
    );

    public static final List<String> HALF_ORC_NAMES_FEMALE = List.of(
            "Bara", "Emen", "Engong", "Gelek", "Isolde",
            "Lug", "Maz", "Shafi", "Sutha", "Vola",
            "Wren", "Yasa", "Zara", "Grig", "Helga",
            "Kethra", "Lort", "Mavra", "Rona", "Tish",
            "Ulla", "Vash", "Zala", "Kima", "Gash"
    );

    private static final List<ClassEnum> PREFERRED_CLASSES = List.of(
            ClassEnum.BARBARIAN, ClassEnum.FIGHTER, ClassEnum.RANGER,
            ClassEnum.PALADIN, ClassEnum.ROGUE // Rogues Brutos ou Assassinos
    );

    @Override
    public RaceEnum getRaceName() {
        return RaceEnum.HALF_ORC;
    }

    @Override
    protected List<ClassEnum> getPreferredClasses() {
        return PREFERRED_CLASSES;
    }

    @Override
    protected String generateName(GenderEnum gender) {
        if (gender.equals(GenderEnum.MALE)) {
            return HALF_ORC_NAMES_MALE.get(random.nextInt(HALF_ORC_NAMES_MALE.size()));
        }
        return HALF_ORC_NAMES_FEMALE.get(random.nextInt(HALF_ORC_NAMES_FEMALE.size()));
    }
}