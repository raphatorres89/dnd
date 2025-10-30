package com.raphaowl.dnd.dtos;

import java.util.List;
import java.util.UUID;

import com.raphaowl.dnd.enums.AlignmentEnum;
import com.raphaowl.dnd.enums.ClassEnum;
import com.raphaowl.dnd.enums.GenderEnum;
import com.raphaowl.dnd.enums.RaceEnum;

public record Npc(
        UUID id,
        String name,
        RaceEnum race,
        GenderEnum gender,
        AlignmentEnum alignment,
        ClassEnum className,
        NpcStats statistics,
        Background background,
        Integer proficiencyBonus,
        Integer level,
        Integer maxHP,
        Integer armorClass,
        List<Item> inventory,
        List<Spell> spells) {

    public List<Item> getWeapons() {
        return inventory.stream()
                .filter(item -> item instanceof Weapon)
                .toList();
    }

    public List<Spell> getAttackSpells() {
        return spells.stream()
                .filter(Spell::getIsAttack)
                .toList();
    }
}

