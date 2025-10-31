package com.raphaowl.dnd.controllers.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/taverns")
@AllArgsConstructor
public class TavernController {

    @GetMapping
    public String taverns(Model model) {
        model.addAttribute("tavern", new Tavern());
        return "taverns";
    }

    public class Rumor {
        private final String description;
        private final String source;

        public Rumor(String description, String source) {
            this.description = description;
            this.source = source;
        }

        public String getDescription() { return description; }
        public String getSource() { return source; }
    }

    public class Tavern {
        private final String name = "O Caldeirão Envelhecido";
        private final String owner = "Grizelda 'A Rabugenta' Blackwood";
        private final String specialty = "Hidromel do Pântano (Licor fortíssimo e ilegal)";
        private final List<String> menu = List.of(
                "Ensopado do Dia: Carne de Ogro (3 PC)",
                "Pão de Centeio e Queijo Mofado (1 PC)",
                "Cerveja de Trigo da Casa (4 SC)",
                "Vinho Élfico Silvano (1 PO)"
        );
        private final List<Rumor> rumors = List.of(
                new Rumor("O Barão está enviando seus guardas para as ruínas do forte na floresta. Algo de valor foi encontrado.", "Um bêbado"),
                new Rumor("Dizem que as crianças que desapareceram foram levadas por Fadas, e não por Goblins.", "O Bardo local"),
                new Rumor("O ferreiro local comprou um suprimento de Ferro Frio. Não me perguntem para que.", "O Cozinheiro")
        );
        private final List<String> quests = List.of(
                "Missão Principal: Recuperar o Cachimbo da Paz roubado do Mestre da Guilda.",
                "Side Quest: Eliminar o ninho de aranhas gigantes no porão da taverna vizinha."
        );

        // Getters omitidos para brevidade (mas necessários)
        public String getName() { return name; }
        public String getOwner() { return owner; }
        public String getSpecialty() { return specialty; }
        public List<String> getMenu() { return menu; }
        public List<Rumor> getRumors() { return rumors; }
        public List<String> getQuests() { return quests; }
    }
}
