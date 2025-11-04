package com.raphaowl.dnd.controllers.web;

import java.util.List;

import com.raphaowl.dnd.dtos.Monster;
import com.raphaowl.dnd.service.MonsterService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping(value = {"/monsters"})
@AllArgsConstructor
public class MonsterController {

    private final MonsterService monsterService;

    @GetMapping
    public String getMonsters(Model model) {
        List<Monster> allMonsters = monsterService.getAllMonsters();
        model.addAttribute("monsters", allMonsters);
        return "monsters";
    }

    @GetMapping("/{index}")
    public String getMonster(@PathVariable String index, Model model) {
        Monster monster = monsterService.getMonster(index);
        model.addAttribute("monster", monster);
        return "fragments/monster-details :: content";
    }

}
