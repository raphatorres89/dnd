package com.raphaowl.dnd.controllers.web;

import java.util.List;

import com.raphaowl.dnd.dtos.Npc;
import com.raphaowl.dnd.dtos.NpcFilterDto;
import com.raphaowl.dnd.service.NpcService;

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
            @RequestParam(defaultValue = "6") int count,
            Model model
    ) {

        List<Npc> npcs = npcService.generateNpcs(filter, count);
        model.addAttribute("npcs", npcs);

        return "fragments/npc-card :: cards";
    }
}
