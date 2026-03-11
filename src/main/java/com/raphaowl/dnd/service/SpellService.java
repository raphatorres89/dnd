package com.raphaowl.dnd.service;

import java.util.List;
import java.util.Objects;

import com.raphaowl.dnd.dtos.SpellView;
import com.raphaowl.dnd.mappers.SpellAdapter;
import com.raphaowl.dnd.repository.SpellRepository;

import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

@Service
public class SpellService {

    private final SpellRepository spellRepository;

    public SpellService(SpellRepository spellRepository) {
        this.spellRepository = spellRepository;
    }

    public List<SpellView> getSpells(int page, int size, String name, Integer level, String school) {
        List<SpellView> allSpells = spellRepository.findAll().stream()
                .map(SpellAdapter::from)
                .filter(spell -> Strings.isEmpty(name) || spell.name().toLowerCase().contains(name.toLowerCase()))
                .filter(spell -> level == null || Objects.equals(spell.level(), level))
                .filter(spell -> Strings.isEmpty(school) || spell.school().name().equalsIgnoreCase(school))
                .toList();
        int fromIndex = Math.min(page * size, allSpells.size());
        int toIndex = Math.min(fromIndex + size, allSpells.size());
        return allSpells.subList(fromIndex, toIndex);
    }

    public int countSpells(String name, Integer level, String school) {
        return (int) spellRepository.findAll().stream()
                .map(SpellAdapter::from)
                .filter(spell -> org.apache.logging.log4j.util.Strings.isEmpty(name) || spell.name().toLowerCase().contains(name.toLowerCase()))
                .filter(spell -> level == null || java.util.Objects.equals(spell.level(), level))
                .filter(spell -> org.apache.logging.log4j.util.Strings.isEmpty(school) || spell.school().name().equalsIgnoreCase(school))
                .count();
    }
}
