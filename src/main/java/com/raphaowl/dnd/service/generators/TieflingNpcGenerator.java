package com.raphaowl.dnd.service.generators;

import java.util.List;

import com.raphaowl.dnd.enums.ClassEnum;
import com.raphaowl.dnd.enums.GenderEnum;
import com.raphaowl.dnd.enums.RaceEnum;

import org.springframework.stereotype.Component;

@Component
public class TieflingNpcGenerator extends AbstractNpcGenerator {

    public static final List<String> TIEFLING_NAMES_MALE = List.of(
            "Akmenos", "Amnon", "Barakas", "Damakos", "Ekemon",
            "Iados", "Kairon", "Leucis", "Melech", "Mordai",
            "Morthos", "Pelaios", "Skamos", "Therai", "Zalt",
            "Cinder", "Jax", "Lazarus", "Nyx", "Styx"
    );

    public static final List<String> TIEFLING_NAMES_FEMALE = List.of(
            "Akta", "Anakis", "Bryseis", "Damaia", "Kallista",
            "Kethra", "Lea", "Mairon", "Myzaria", "Nemeia",
            "Orianna", "Phelaia", "Rieta", "Thriza", "Vespera",
            "Asmodeus", "Lilith", "Malphas", "Zariel", "Succubus"
    );

    // Nomes de Virtude (Unissex)
    public static final List<String> TIEFLING_NAMES_VIRTUE = List.of(
            "Art", "Carrion", "Chant", "Creed", "Despair",
            "Excellence", "Fear", "Glory", "Hope", "Ideal",
            "Music", "Nowhere", "Poetry", "Quest", "Random",
            "Reverence", "Sorrow", "Torment", "Worry", "Zeal"
    );

    private static final List<ClassEnum> PREFERRED_CLASSES = List.of(
            ClassEnum.WARLOCK, ClassEnum.SORCERER, ClassEnum.BARD,
            ClassEnum.ROGUE, ClassEnum.PALADIN, ClassEnum.FIGHTER // Geralmente com foco em Carisma
    );

    @Override
    public RaceEnum getRaceName() {
        return RaceEnum.TIEFLING;
    }

    @Override
    protected List<ClassEnum> getPreferredClasses() {
        return PREFERRED_CLASSES;
    }

    @Override
    protected String generateName(GenderEnum gender) {
        // Tieflings têm uma chance de usar nomes de virtude
        if (random.nextDouble() < 0.20) { // 20% de chance de ser um Nome de Virtude
            return TIEFLING_NAMES_VIRTUE.get(random.nextInt(TIEFLING_NAMES_VIRTUE.size()));
        }

        // Caso contrário, usa nomes específicos de gênero
        if (gender.equals(GenderEnum.MALE)) {
            return TIEFLING_NAMES_MALE.get(random.nextInt(TIEFLING_NAMES_MALE.size()));
        }
        return TIEFLING_NAMES_FEMALE.get(random.nextInt(TIEFLING_NAMES_FEMALE.size()));
    }
}