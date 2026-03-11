package com.raphaowl.dnd.controllers.web;

import java.util.List;

import com.raphaowl.dnd.dtos.SpellView;
import com.raphaowl.dnd.service.SpellService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping(value = "/spells")
@AllArgsConstructor
public class SpellController {

    private final SpellService spellService;

    @GetMapping
    public String spells(@RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer level,
            @RequestParam(required = false) String school,
            Model model) {
        List<SpellView> spells = spellService.getSpells(page, size, name, level, school);
        int totalSpells = spellService.countSpells(name, level, school);
        int totalPages = (int) Math.ceil((double) totalSpells / size);
        model.addAttribute("spells", spells);
        model.addAttribute("page", page);
        model.addAttribute("size", size);
        model.addAttribute("name", name);
        model.addAttribute("level", level);
        model.addAttribute("school", school);
        model.addAttribute("totalPages", totalPages);
        return "spells";
    }
}
