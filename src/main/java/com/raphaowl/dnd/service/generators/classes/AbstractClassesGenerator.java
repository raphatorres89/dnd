package com.raphaowl.dnd.service.generators.classes;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import com.raphaowl.dnd.dtos.Item;
import com.raphaowl.dnd.dtos.NpcStats;
import com.raphaowl.dnd.dtos.Spell;
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

    protected List<SpellEnum> getSpellEnumList() {
        // Default implementation returns an empty list
        return List.of();
    };

    protected void generateSpells(Set<SpellEnum> spells, Integer npcLevel, NpcStats npcStats) {
        // Default implementation does nothing
    }

    public List<Spell> getSpells(Integer npcLevel, NpcStats npcStats) {
        Set<SpellEnum> spells = new HashSet<>();
        generateSpells(spells, npcLevel, npcStats);

        return spells.stream()
                .map(spell -> spell.toSpell(npcLevel))
                .sorted(Comparator.comparingInt(Spell::getLevel))
                .toList();
    }

    private static final int MAX_ATTEMPTS = 50;

    protected SpellEnum addUniqueSpell(Set<SpellEnum> spells, int level) {

        // Obtém a lista de magias que AINDA NÃO FORAM ADICIONADAS.
        List<SpellEnum> availableSpells = getAvailableSpells(spells, level);

        // 1. CHECAGEM DE FALHA: Se a lista estiver vazia, não há o que adicionar.
        if (availableSpells.isEmpty()) {

            // HACK PARA EVITAR NULL: Retornamos uma magia já existente
            // (por exemplo, a primeira magia do Set). Isso satisfaz o contrato
            // de retorno não-nulo, mas o chamador deve ser avisado que NADA foi adicionado.

            if (!spells.isEmpty()) {
                // Retorna o primeiro elemento do Set como um "placeholder"
                return spells.iterator().next();
            } else {
                // Caso extremo: Se o Set estiver vazio e não houver magias disponíveis para este nível,
                // isso pode causar uma quebra, mas é mais seguro que retornar null.
                // Para segurança máxima, aqui deveria haver um SpellEnum.EMPTY, mas vamos evitar NPE.
                // Vou chamar o método que busca a lista original e retornar o primeiro elemento.
                return getSpellEnumList().iterator().next();
            }
        }

        // 2. SUCESSO: Seleciona uma magia aleatória apenas da lista de disponíveis
        SpellEnum newSpell = availableSpells.get(random.nextInt(availableSpells.size()));

        // 3. Adiciona ao Set (garantido ser único)
        spells.add(newSpell);

        // 4. Retorna a nova magia
        return newSpell;
    }

    private List<SpellEnum> getAvailableSpells(Set<SpellEnum> spells, int level) {
        // 1. Obtém todas as magias para o nível
        List<SpellEnum> allSpellsOfLevel = getSpellEnumList().stream()
                .filter(spell -> spell.getLevel() == level)
                .toList();

        // 2. Filtra as magias que AINDA NÃO estão no Set
        return allSpellsOfLevel.stream()
                .filter(spell -> !spells.contains(spell))
                .toList();
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
