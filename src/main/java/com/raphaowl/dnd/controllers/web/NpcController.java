package com.raphaowl.dnd.controllers.web;

import java.util.List;

import com.raphaowl.dnd.dtos.Npc;
import com.raphaowl.dnd.dtos.NpcFilterDto;
import com.raphaowl.dnd.service.NpcService;
import com.raphaowl.dnd.utils.ModCalculator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/npcs")
@AllArgsConstructor
public class NpcController {

    private final NpcService npcService;

    @GetMapping
    public String npcs() {
        return "npcs";
    }

    @GetMapping("/generate")
    public String generateNpcs(
            NpcFilterDto filter,
            @RequestParam(defaultValue = "4") int count,
            Model model
    ) {

        List<Npc> npcs = npcService.generateNpcs(filter, count);
        model.addAttribute("npcs", npcs);
        model.addAttribute("modCalculator", (ModCalculator) this::calculateModifier);
        return "fragments/npc-card :: cards";
    }

    private Integer calculateModifier(Integer score) {
        return (int) Math.floor((score - 10) / 2.0);
    }
}
