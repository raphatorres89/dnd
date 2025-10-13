package com.raphaowl.dnd.controllers;

import com.raphaowl.dnd.dtos.Monster;
import com.raphaowl.dnd.services.MonsterService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping(value = {"/bestiary"})
@AllArgsConstructor
public class BestiaryController {

    private final MonsterService monsterService;

    @GetMapping
    public String getMonsters(Model model) {
        model.addAttribute("monsters", monsterService.getMonsters());
        return "bestiary";
    }

    @GetMapping("/{index}")
    public String getMonster(@PathVariable String index, Model model) {
        Monster monster = monsterService.getMonster(index);
        model.addAttribute("monster", monster);
        return "fragments/monster-details :: content";
    }

}
