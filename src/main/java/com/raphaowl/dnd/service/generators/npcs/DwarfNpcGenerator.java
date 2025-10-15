package com.raphaowl.dnd.service.generators.npcs;

import java.util.List;

import com.raphaowl.dnd.enums.ClassEnum;
import com.raphaowl.dnd.enums.GenderEnum;
import com.raphaowl.dnd.enums.RaceEnum;

import org.springframework.stereotype.Component;

@Component
public class DwarfNpcGenerator extends AbstractNpcGenerator {

    public static final List<String> DWARVEN_NAMES_MALE = List.of(
            "Adrik", "Balin", "Bardin", "Bifur", "Borin",
            "Brokk", "Brom", "Darrak", "Dundar", "Durkon",
            "Einar", "Fimbul", "Flint", "Gimlan", "Gimli",
            "Gorok", "Gron", "Haldur", "Hengar", "Ironside",
            "Kaelen", "Kildrak", "Korgan", "Magnus", "Milo",
            "Nari", "Olaf", "Olin", "Orik", "Roric",
            "Rurik", "Thordin", "Thorin", "Torvin", "Tordek",
            "Ulfgar", "Vek", "Voloth", "Yorik", "Zoltan",
            "Bruenor", "Gloin", "Fili", "Kili", "Bombur",
            "Dwalin", "Balder", "Thraik", "Gargan", "Barik"
    );

    public static final List<String> DWARVEN_NAMES_FEMALE = List.of(
            "Astrid", "Barda", "Bodill", "Dagna", "Darla",
            "Dolga", "Elda", "Falka", "Finngar", "Grista",
            "Gretchen", "Gunnhild", "Helga", "Hlin", "Idril",
            "Katra", "Krystin", "Lith", "Lumra", "Marta",
            "Muriel", "Nadya", "Olga", "Orla", "Ronda",
            "Rumna", "Saga", "Skora", "Thordis", "Thora",
            "Ulara", "Vistra", "Valka", "Yrsa", "Zanna",
            "Borina", "Brola", "Darda", "Freya", "Grinda",
            "Hanna", "Kaelda", "Lana", "Milda", "Oma",
            "Petra", "Rhea", "Sif", "Tilda", "Ursa"
    );

    private static final List<ClassEnum> PREFERRED_CLASSES = List.of(
            ClassEnum.FIGHTER, ClassEnum.CLERIC, ClassEnum.BARBARIAN, ClassEnum.PALADIN, ClassEnum.RANGER
    );

    @Override
    public RaceEnum getRaceName() {
        return RaceEnum.DWARF;
    }

    @Override
    protected List<ClassEnum> getPreferredClasses() {
        return PREFERRED_CLASSES;
    }

    @Override
    protected String generateName(GenderEnum gender) {
        if (gender.equals(GenderEnum.MALE)) {
            return DWARVEN_NAMES_MALE.get(random.nextInt(DWARVEN_NAMES_MALE.size()));
        }
        return DWARVEN_NAMES_FEMALE.get(random.nextInt(DWARVEN_NAMES_FEMALE.size()));
    }
}
