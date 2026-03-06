package com.raphaowl.dnd.controllers.web;

import java.util.List;

import com.raphaowl.dnd.dtos.Spell;
import com.raphaowl.dnd.service.SpellService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping(value = "/spells")
@AllArgsConstructor
public class SpellController {

    private final SpellService spellService;

    @GetMapping
    public String spells(Model model) {
        List<Spell> allSpells = spellService.getAllSpells();
        model.addAttribute("spells", allSpells);
        return "spells";
    }
}
