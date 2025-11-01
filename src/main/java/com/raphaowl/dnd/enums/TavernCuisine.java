package com.raphaowl.dnd.enums;

import java.util.Random;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TavernCuisine {
    DRINKS("ra ra-beer"), // Comida comum (Modest/Comfortable do artigo)
    COMMON_FAERUNIAN("ra ra-knife-fork"), // Comida comum (Modest/Comfortable do artigo)
    ARISTOCRATIC_HALL("ra ra-roast-chicken"), // Comida nobre (Wealthy/Aristocratic do artigo)
    MONSTROUS_SPECIALTIES("ra ra-crab-claw"), // Foco em Monster Food e Exotic (o que já temos)
    ELVEN_FOREST_FARE("ra ra-zigzag-leaf"), // Culinária Élfica
    UNDERDARK_DELICACIES("ra ra-spider-face"), // Culinária da Sub-Escuridão
    SIMPLE_ORCISH("ra ra-maggot"); // Comida bruta e barata (Squalid/Monster Food do artigo)

    private static final Random random = new Random();
    private static final TavernCuisine[] VALUES = values();

    private String iconClass;

    public static TavernCuisine getRandomName() {
        return VALUES[random.nextInt(VALUES.length)];
    }

    public static TavernCuisine from(String name) {
        for (TavernCuisine cuisine : VALUES) {
            if (cuisine.name().equalsIgnoreCase(name)) {
                return cuisine;
            }
        }
        return null;
    }
}
