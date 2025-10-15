package com.raphaowl.dnd.service.generators.npcs;

import java.util.List;

import com.raphaowl.dnd.enums.ClassEnum;
import com.raphaowl.dnd.enums.GenderEnum;
import com.raphaowl.dnd.enums.RaceEnum;

import org.springframework.stereotype.Component;

@Component
public class HumanNpcGenerator extends AbstractNpcGenerator {

    private static final List<String> HUMAN_NAMES_MALE = List.of(
            "Aric", "Bram", "Caleb", "Darian", "Elias",
            "Fenn", "Gavin", "Harlan", "Ian", "Joric",
            "Kael", "Loras", "Merek", "Niles", "Owen",
            "Perrin", "Quinn", "Roric", "Silas", "Torvin",
            "Uther", "Valerius", "Willem", "Xavier", "Yoren",
            "Alton", "Boris", "Corbin", "Drustan", "Edric",
            "Finnian", "Gregor", "Hugh", "Ivar", "Jasper",
            "Kendall", "Leif", "Malachi", "Nolan", "Orin",
            "Patryk", "Quintus", "Rein", "Stellan", "Theron",
            "Ulric", "Vance", "Wyatt", "Xander", "Yancy"
    );

    private static final List<String> HUMAN_NAMES_FEMALE = List.of(
            "Anya", "Brienne", "Cerys", "Dahlia", "Elara",
            "Fiona", "Gemma", "Helena", "Isolde", "Jessa",
            "Kaelen", "Lyra", "Mira", "Niamh", "Orla",
            "Petra", "Quilla", "Rowan", "Seraphina", "Tamsin",
            "Una", "Valena", "Willow", "Xylona", "Yvette",
            "Alana", "Brenna", "Clara", "Deirdre", "Edith",
            "Freya", "Gisela", "Hilda", "Ingrid", "Jocelyn",
            "Kendra", "Linnea", "Maeve", "Nova", "Ondine",
            "Piper", "Quinnlyn", "Rhea", "Sydell", "Terra",
            "Ursa", "Vespera", "Wren", "Xenia", "Yara"
    );

    @Override
    protected List<ClassEnum> getPreferredClasses() {
        return List.of(ClassEnum.values());
    }

    @Override
    public RaceEnum getRaceName() {
        return RaceEnum.HUMAN;
    }

    @Override
    protected String generateName(GenderEnum gender) {
        if (gender.equals(GenderEnum.MALE)) {
            return HUMAN_NAMES_MALE.get(random.nextInt(HUMAN_NAMES_MALE.size()));
        }
        return HUMAN_NAMES_FEMALE.get(random.nextInt(HUMAN_NAMES_FEMALE.size()));
    }
}
