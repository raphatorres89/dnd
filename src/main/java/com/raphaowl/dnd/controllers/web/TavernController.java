package com.raphaowl.dnd.controllers.web;

import com.raphaowl.dnd.dtos.Tavern;

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
}
