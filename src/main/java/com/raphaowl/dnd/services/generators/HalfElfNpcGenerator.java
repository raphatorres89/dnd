package com.raphaowl.dnd.services.generators;

import java.util.List;

import com.raphaowl.dnd.enums.ClassEnum;
import com.raphaowl.dnd.enums.GenderEnum;
import com.raphaowl.dnd.enums.RaceEnum;

import org.springframework.stereotype.Component;

@Component
public class HalfElfNpcGenerator extends AbstractNpcGenerator {

    public static final List<String> HALF_ELF_NAMES_MALE = List.of(
            "Alen", "Darik", "Elias", "Faelan", "Kael",
            "Lian", "Lucien", "Malon", "Miran", "Niran",
            "Oric", "Peren", "Rael", "Sander", "Theron",
            "Valen", "Aelion", "Bren", "Corin", "Elmar",
            "Jaral", "Lethan", "Nym", "Oren", "Quillan"
    );

    public static final List<String> HALF_ELF_NAMES_FEMALE = List.of(
            "Anara", "Bryn", "Dalia", "Elara", "Fira",
            "Jessa", "Lira", "Lyra", "Mira", "Nala",
            "Orla", "Riana", "Serra", "Thalia", "Vespera",
            "Anya", "Briana", "Caelia", "Elena", "Faye",
            "Kaelen", "Leena", "Nissa", "Rhian", "Sydell"
    );

    private static final List<ClassEnum> PREFERRED_CLASSES = List.of(
            ClassEnum.BARD, ClassEnum.SORCERER, ClassEnum.WARLOCK,
            ClassEnum.PALADIN, ClassEnum.ROGUE, ClassEnum.FIGHTER
    );

    @Override
    public RaceEnum getRaceName() {
        return RaceEnum.HALF_ELF;
    }

    @Override
    protected List<ClassEnum> getPreferredClasses() {
        return PREFERRED_CLASSES;
    }

    @Override
    protected String generateName(GenderEnum gender) {
        if (gender.equals(GenderEnum.MALE)) {
            return HALF_ELF_NAMES_MALE.get(random.nextInt(HALF_ELF_NAMES_MALE.size()));
        }
        return HALF_ELF_NAMES_FEMALE.get(random.nextInt(HALF_ELF_NAMES_FEMALE.size()));
    }
}