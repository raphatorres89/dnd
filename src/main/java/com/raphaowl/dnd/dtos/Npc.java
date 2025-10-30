package com.raphaowl.dnd.dtos;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.raphaowl.dnd.enums.AlignmentEnum;
import com.raphaowl.dnd.enums.ClassEnum;
import com.raphaowl.dnd.enums.DamageEnum;
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

    public List<Weapon> getWeapons() {
        return inventory.stream()
                .filter(item -> item instanceof Weapon)
                .map(weapon -> (Weapon) weapon)
                .toList();
    }

    public List<Spell> getAttackSpells() {
        return spells.stream()
                .filter(Spell::getIsAttack)
                .toList();
    }

    public List<AttackDto> getAllAttacks() {
        List<AttackDto> attackDtoList = new ArrayList<>();
        getWeapons().stream()
                .map(weapon -> new AttackDto(
                        weapon.getIconClass(),
                        weapon.getName(),
                        weapon.getAttack().getDamageDice(),
                        weapon.getAttack().getDamageType(),
                        false))
                .forEach(attackDtoList::add);

        getAttackSpells().stream()
                .map(spell -> new AttackDto(
                        spell.getDamageType().getIconClass(),
                        spell.getName(),
                        spell.getDamage(),
                        spell.getDamageType(),
                        true))
                .forEach(attackDtoList::add);

        return attackDtoList;
    }

    public record AttackDto(
            String iconClass,
            String name,
            String damage,
            DamageEnum type,
            boolean isSpell) {}
}

