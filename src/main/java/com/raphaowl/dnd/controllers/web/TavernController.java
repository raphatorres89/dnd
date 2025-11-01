package com.raphaowl.dnd.controllers.web;

import com.raphaowl.dnd.dtos.Tavern;
import com.raphaowl.dnd.enums.TavernCuisine;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/taverns")
@AllArgsConstructor
public class TavernController {

    @GetMapping
    public String taverns(@RequestParam(required = false, name = "cuisine") String cuisineFilter, Model model) {
        model.addAttribute("selectedCuisine", cuisineFilter);
        model.addAttribute("cuisines", TavernCuisine.values());
        TavernCuisine tavernCuisine = TavernCuisine.from(cuisineFilter);
        model.addAttribute("tavern", new Tavern(tavernCuisine));
        return "taverns";
    }
}
