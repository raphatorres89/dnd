package com.raphaowl.dnd.service.generators.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import com.raphaowl.dnd.dtos.Item;
import com.raphaowl.dnd.enums.GearEnum;
import com.raphaowl.dnd.enums.SpellEnum;
import com.raphaowl.dnd.enums.ToolEnum;
import com.raphaowl.dnd.enums.ToolTypeEnum;
import com.raphaowl.dnd.enums.WeaponEnum;
import com.raphaowl.dnd.enums.WeaponType;

import org.springframework.stereotype.Component;

@Component
public abstract class AbstractClassesGenerator implements ClassesGenerator {

    Random random = new Random();

    protected abstract List<SpellEnum> getSpellEnumList();

    protected SpellEnum addUniqueSpell(Set<SpellEnum> spells, int level) {
        SpellEnum spell;
        do {
            spell = getAleatorySpellFromLevel(level);
        } while (spells.contains(spell));
        return spell;
    }

    private SpellEnum getAleatorySpellFromLevel(Integer level) {
        List<SpellEnum> spellsOfLevel = getSpellEnumList().stream()
                .filter(spell -> spell.getLevel() == level)
                .toList();
        return spellsOfLevel.get(random.nextInt(spellsOfLevel.size()));
    }

    protected Integer getHP(Integer level, Integer constitution, Integer dice) {
        Integer constitutionModifier = (constitution - 10) / 2;
        int pv = dice + constitutionModifier;
        for (int i = level; i > 1; i--) {
            pv += random.nextInt(1, dice) + constitutionModifier;
        }
        return pv;
    }

    protected Item getAnyMartialWeapon() {
        List<WeaponEnum> weapons = new ArrayList<>(WeaponEnum.getByType(WeaponType.MARTIAL_MELEE));
        weapons.addAll(WeaponEnum.getByType(WeaponType.MARTIAL_RANGED));
        return weapons.get(random.nextInt(weapons.size())).toWeapon(1);
    }

    protected Item getAnySimpleWeapon() {
        List<WeaponEnum> weapons = new ArrayList<>(WeaponEnum.getByType(WeaponType.SIMPLE_MELEE));
        weapons.addAll(WeaponEnum.getByType(WeaponType.SIMPLE_RANGED));
        return weapons.get(random.nextInt(weapons.size())).toWeapon(1);
    }

    protected Item getAnySimpleMeleeWeapon() {
        List<WeaponEnum> weapons = new ArrayList<>(WeaponEnum.getByType(WeaponType.SIMPLE_MELEE));
        return weapons.get(random.nextInt(weapons.size())).toWeapon(1);
    }

    protected Item getAnyInstrument() {
        List<ToolEnum> instruments = new ArrayList<>(ToolEnum.getByType(ToolTypeEnum.MUSICAL));
        return instruments.get(random.nextInt(instruments.size())).toItem(1);
    }

    protected Item getExplorerOrAdventurerPack() {
        if (random.nextBoolean()) {
            return GearEnum.EXPLORER_PACK.toItem(1);
        }
        return GearEnum.ADVENTURER_PACK.toItem(1);
    }

    protected Item getAnyArcaneFocus() {
        List<GearEnum> items = List.of(
                GearEnum.ARCANE_FOCUS_CRYSTAL,
                GearEnum.ARCANE_FOCUS_ORB,
                GearEnum.ARCANE_FOCUS_ROD,
                GearEnum.ARCANE_FOCUS_STAFF,
                GearEnum.ARCANE_FOCUS_WAND
        );
        return items.get(random.nextInt(items.size())).toItem(1);
    }

    protected Item getHolySymbol() {
        List<GearEnum> items = List.of(
                GearEnum.HOLY_SYMBOL_AMULET,
                GearEnum.HOLY_SYMBOL_EMBLEM,
                GearEnum.HOLY_SYMBOL_RELIQUARY
        );
        return items.get(random.nextInt(items.size())).toItem(1);
    }
}
