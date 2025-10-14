package com.raphaowl.dnd.service.generators;

import java.util.List;

import com.raphaowl.dnd.enums.ClassEnum;
import com.raphaowl.dnd.enums.GenderEnum;
import com.raphaowl.dnd.enums.RaceEnum;

import org.springframework.stereotype.Component;

@Component
public class ElvenNpcGenerator extends AbstractNpcGenerator {

    public static final List<String> ELVEN_NAMES_MALE = List.of(
            "Adran", "Aelar", "Aramil", "Arion", "Aust",
            "Beiro", "Berrian", "Carric", "Enialis", "Erevan",
            "Faelar", "Folkwin", "Galinndan", "Hadarai", "Himo",
            "Immeral", "Korian", "Lianorn", "Laucian", "Lucien",
            "Mendel", "Merric", "Naeris", "Oriel", "Peren",
            "Quarion", "Raelon", "Riardon", "Rithwin", "Roland",
            "Seldor", "Shandalar", "Theren", "Veldrun", "Vernon",
            "Aerion", "Elaraen", "Faunel", "Irmor", "Lomion",
            "Maegor", "Nym", "Paeral", "Quill", "Sariel",
            "Syldor", "Taryon", "Tevron", "Ullian", "Valen"
    );

    public static final List<String> ELVEN_NAMES_FEMALE = List.of(
            "Adrie", "Althaea", "Anastrianna", "Andraste", "Antinua",
            "Bethrynna", "Caelynn", "Daeira", "Eleniel", "Enna",
            "Faral", "Firael", "Ilia", "Kithri", "Laenor",
            "Leena", "Lia", "Lysianna", "Meriel", "Mialee",
            "Naivara", "Nala", "Phloenia", "Quelenna", "Sariel",
            "Syllin", "Thea", "Valanthe", "Wyn", "Yara",
            "Aeriel", "Brynn", "Caelia", "Dendra", "Elora",
            "Faylen", "Ilyana", "Jelenneth", "Keyleth", "Lariel",
            "Mireille", "Nyssa", "Phaedra", "Rina", "Shava",
            "Triel", "Viviana", "Winter", "Yavanna", "Zylara"
    );

    private final List<ClassEnum> PREFERRED_CLASSES = List.of(
            ClassEnum.WIZARD, ClassEnum.ROGUE, ClassEnum.RANGER
    );

    @Override
    public RaceEnum getRaceName() {
        return RaceEnum.ELF;
    }

    @Override
    protected List<ClassEnum> getPreferredClasses() {
        return PREFERRED_CLASSES;
    }

    @Override
    protected String generateName(GenderEnum gender) {
        if (gender.equals(GenderEnum.MALE)) {
            return ELVEN_NAMES_MALE.get(random.nextInt(ELVEN_NAMES_MALE.size()));
        }
        return ELVEN_NAMES_FEMALE.get(random.nextInt(ELVEN_NAMES_FEMALE.size()));
    }
}
