package com.raphaowl.dnd.controllers.web;

import com.raphaowl.dnd.service.QuestService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/quests")
@AllArgsConstructor
public class QuestController {

    private final QuestService questService;

    @GetMapping
    public String quests(Model model) {
        model.addAttribute("quest", questService.getQuest());
        return "quests";
    }
}
