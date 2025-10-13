package com.raphaowl.dnd.services.generators;

import java.util.List;

import com.raphaowl.dnd.enums.ClassEnum;
import com.raphaowl.dnd.enums.GenderEnum;
import com.raphaowl.dnd.enums.RaceEnum;

import org.springframework.stereotype.Component;

@Component
public class HalflingNpcGenerator extends AbstractNpcGenerator {

    public static final List<String> HALFLING_NAMES_MALE = List.of(
            "Alton", "Beau", "Cade", "Corrin", "Eldon",
            "Errich", "Finnan", "Garret", "Lyle", "Milo",
            "Osborn", "Perrin", "Reed", "Roscoe", "Wellby",
            "Bart", "Clem", "Pip", "Tobin", "Willie",
            "Jude", "Samwise", "Merry", "Pippin", "Frodo"
    );

    public static final List<String> HALFLING_NAMES_FEMALE = List.of(
            "Andie", "Bree", "Callie", "Cora", "Euphemia",
            "Jillian", "Kithri", "Lavinia", "Lidda", "Merla",
            "Nedda", "Paela", "Portia", "Seraphina", "Shaena",
            "Verna", "Wella", "Yola", "Esmeralda", "Lola",
            "Rose", "Tansy", "Daisy", "Lily", "Poppy"
    );

    private static final List<ClassEnum> PREFERRED_CLASSES = List.of(
            ClassEnum.ROGUE, ClassEnum.BARD, ClassEnum.FIGHTER,
            ClassEnum.RANGER, ClassEnum.CLERIC // Clérigos da Paz ou da Fortuna
    );

    @Override
    public RaceEnum getRaceName() {
        return RaceEnum.HALFLING;
    }

    @Override
    protected List<ClassEnum> getPreferredClasses() {
        return PREFERRED_CLASSES;
    }

    @Override
    protected String generateName(GenderEnum gender) {
        if (gender.equals(GenderEnum.MALE)) {
            return HALFLING_NAMES_MALE.get(random.nextInt(HALFLING_NAMES_MALE.size()));
        }
        return HALFLING_NAMES_FEMALE.get(random.nextInt(HALFLING_NAMES_FEMALE.size()));
    }
}