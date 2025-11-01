package com.raphaowl.dnd.dtos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Stream;

import com.raphaowl.dnd.enums.FoodAndDrink;
import com.raphaowl.dnd.enums.RumorSource;
import com.raphaowl.dnd.enums.TavernCuisine;
import com.raphaowl.dnd.enums.TavernName;
import com.raphaowl.dnd.enums.TavernOwner;
import com.raphaowl.dnd.enums.TavernQuest;
import com.raphaowl.dnd.enums.TavernRumor;
import com.raphaowl.dnd.enums.TavernSpecialty;

import lombok.Getter;

@Getter
public class Tavern {
    private final TavernCuisine cuisine;
    private final TavernName name;
    private final TavernOwner owner;
    private final TavernSpecialty specialty;
    private final List<RumorEntry> rumors;
    private final List<MenuEntry> menu;
    private final List<TavernQuest> quests;

    public Tavern(TavernCuisine tavernCuisine) {
        this.name = TavernName.getRandomName();
        this.cuisine = tavernCuisine != null ? tavernCuisine : TavernCuisine.getRandomName();
        this.owner = TavernOwner.getRandomName();
        this.specialty = TavernSpecialty.getRandomName();
        this.rumors = aleatoryRumors();
        this.menu = aleatoryMenu();
        this.quests = aleatoryQuests();
    }

    private List<TavernQuest> aleatoryQuests() {
        Set<TavernQuest> uniqueQuests = new HashSet<>();

        while (uniqueQuests.size() < 3) {
            uniqueQuests.add(TavernQuest.getRandomName());
        }
        return List.copyOf(uniqueQuests);
    }

    private List<MenuEntry> aleatoryMenu() {
        Random random = new Random();
        List<MenuEntry> menu = new ArrayList<>();

        // 1. GARANTIA DE BEBIDAS (DRINK)
        // ---------------------------------------------------------------------
        List<FoodAndDrink> availableDrinks =
                new ArrayList<>(Stream.of(FoodAndDrink.values())
                                        .filter(item -> item.getCuisineType() == TavernCuisine.DRINKS)
                                        .toList());

        // Determina o número de bebidas (garante 3, max 5)
        int numDrinks = random.nextInt(2) + 3;

        // Embaralha as bebidas e seleciona o número desejado
        Collections.shuffle(availableDrinks, random);
        List<FoodAndDrink> selectedDrinks = availableDrinks.stream()
                .limit(numDrinks)
                .toList();

        // Adiciona as bebidas ao menu (map para MenuEntry)
        selectedDrinks.forEach(item -> menu.add(generateMenuEntry(item, random)));


        // 2. SELEÇÃO DE COMIDA TEMÁTICA
        // ---------------------------------------------------------------------
        List<FoodAndDrink> availableFood = new ArrayList<>(Stream.of(FoodAndDrink.values())
                                                                   .filter(item -> item.getCuisineType() == this.cuisine)
                                                                   // Exclui a categoria DRINK para evitar repetição acidental
                                                                   .filter(item -> item.getCuisineType() != TavernCuisine.DRINKS)
                                                                   .toList());

        // Se a culinária principal não tiver itens suficientes, complementa com Comum (COMMON_FAERUNIAN)
        if (availableFood.size() < 6) {
            List<FoodAndDrink> commonItems = Stream.of(FoodAndDrink.values())
                    .filter(item -> item.getCuisineType() == TavernCuisine.COMMON_FAERUNIAN)
                    .toList();
            availableFood.addAll(commonItems.subList(0, Math.min(6 - availableFood.size(), commonItems.size())));
        }

        // Determina o número total de itens que o menu final deve ter (ex: 10 a 12)
        int maxMenuSize = random.nextInt(3) + 10; // 10, 11 ou 12 itens

        // Calcula quantos pratos de comida ainda precisamos
        int numFoodNeeded = maxMenuSize - menu.size();

        // Embaralha a comida disponível e seleciona o necessário
        Collections.shuffle(availableFood, random);
        List<FoodAndDrink> selectedFood = availableFood.stream()
                .limit(numFoodNeeded)
                .toList();

        // Adiciona os pratos de comida ao menu (map para MenuEntry)
        selectedFood.forEach(item -> menu.add(generateMenuEntry(item, random)));

        return menu;
    }

    private MenuEntry generateMenuEntry(FoodAndDrink item, Random random) {
        // Pequeno ajuste de preço (ex: +/- 1 unidade)
        int priceAdjustment = item.getPriceUnit() == FoodAndDrink.PriceLevel.GOLD ?
                random.nextInt(3) - 1 : // Ajuste menor para ouro
                random.nextInt(5) - 1; // Ajuste para cobre/prata

        int finalPrice = item.getBasePrice() + priceAdjustment;
        return new MenuEntry(item, Math.max(1, finalPrice));
    }

    private List<RumorEntry> aleatoryRumors() {
        Set<TavernRumor> uniqueRumors = new HashSet<>();
        List<RumorEntry> rumors = new ArrayList<>();

        while (uniqueRumors.size() < 3) {
            TavernRumor randomTavern = TavernRumor.getRandomName();

            if (uniqueRumors.add(randomTavern)) {
                RumorSource source = RumorSource.getRandomName();
                rumors.add(new RumorEntry(randomTavern, source));
            }
        }
        return rumors;
    }

    public record RumorEntry(TavernRumor rumor, RumorSource source) {}
    public record MenuEntry(FoodAndDrink item, Integer price) {}
}
