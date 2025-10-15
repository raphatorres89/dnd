package com.raphaowl.dnd.service.generators.npcs;

import java.util.List;

import com.raphaowl.dnd.enums.ClassEnum;
import com.raphaowl.dnd.enums.GenderEnum;
import com.raphaowl.dnd.enums.RaceEnum;

import org.springframework.stereotype.Component;

@Component
public class GnomeNpcGenerator extends AbstractNpcGenerator {

    public static final List<String> GNOME_NAMES_MALE = List.of(
            "Alston", "Boddynock", "Brocc", "Burgell", "Dimble",
            "Eldon", "Erky", "Flick", "Gerbo", "Glim",
            "Jeb", "Kellen", "Namfoodle", "Orryn", "Perrin",
            "Roondar", "Seebo", "Sindri", "Wiggens", "Wrenn",
            "Zook", "Fonkin", "Gimble", "Grizz", "Kol",
            "Morb", "Noodle", "Oswin", "Quinn", "Rolo",
            "Snoof", "Thistle", "Timm", "Wally", "Zany"
    );

    public static final List<String> GNOME_NAMES_FEMALE = List.of(
            "Bimpnottin", "Breena", "Caramip", "Carlin", "Donella",
            "Dora", "Ella", "Lilli", "Loopmottin", "Lorilla",
            "Mardell", "Nova", "Oda", "Profita", "Shamil",
            "Tana", "Waywocket", "Zanna", "Aria", "Bel",
            "Dimble", "Fria", "Gemma", "Kira", "Mina",
            "Nissa", "Pippa", "Rella", "Sasha", "Trix",
            "Vivi", "Willa", "Yula", "Zola", "Bee"
    );

    private static final List<ClassEnum> PREFERRED_CLASSES = List.of(
            ClassEnum.WIZARD, ClassEnum.ROGUE,
            ClassEnum.BARD, ClassEnum.FIGHTER // Foco em Destreza (Swashbuckler/Duelista)
    );

    @Override
    public RaceEnum getRaceName() {
        return RaceEnum.GNOME;
    }

    @Override
    protected List<ClassEnum> getPreferredClasses() {
        return PREFERRED_CLASSES;
    }

    @Override
    protected String generateName(GenderEnum gender) {
        if (gender.equals(GenderEnum.MALE)) {
            return GNOME_NAMES_MALE.get(random.nextInt(GNOME_NAMES_MALE.size()));
        }
        return GNOME_NAMES_FEMALE.get(random.nextInt(GNOME_NAMES_FEMALE.size()));
    }
}