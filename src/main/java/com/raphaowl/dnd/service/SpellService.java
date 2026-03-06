package com.raphaowl.dnd.service;

import java.util.Arrays;
import java.util.List;

import com.raphaowl.dnd.dtos.Spell;
import com.raphaowl.dnd.enums.SpellEnum2;

import org.springframework.stereotype.Service;

@Service
public class SpellService {

    public List<Spell> getAllSpells() {
        return Arrays.stream(SpellEnum2.values())
                .map(SpellEnum2::toSpell)
                .toList();
    }
}
