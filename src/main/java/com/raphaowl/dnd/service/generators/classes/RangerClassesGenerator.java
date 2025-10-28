package com.raphaowl.dnd.service.generators.classes;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.raphaowl.dnd.dtos.Item;
import com.raphaowl.dnd.dtos.Spell;
import com.raphaowl.dnd.enums.ArmorEnum;
import com.raphaowl.dnd.enums.ClassEnum;
import com.raphaowl.dnd.enums.GearEnum;
import com.raphaowl.dnd.enums.SpellEnum;
import com.raphaowl.dnd.enums.WeaponEnum;

import org.springframework.stereotype.Component;

/**
 * PONTOS DE VIDA
 * Dado de Vida: 1d10 por nível de patrulheiro
 * Pontos de Vida no 1° Nível: 10 + seu modificador de
 * Constituição
 * Pontos de Vida nos Níveis Seguintes: 1d10 (ou 6) +
 * seu modificador de Constituição por nível de
 * patrulheiro após o 1°
 * PROFICIÊNCIAS
 * Armaduras: Armaduras leves, armaduras médias,
 * escudos
 * Armas: Armas simples, armas marciais
 * Ferramentas: Nenhuma
 * Testes de Resistência: Força, Destreza
 * Perícias: Escolha três dentre Adestrar Animais,
 * Atletismo, Furtividade, Intuição, Investigação,
 * Natureza, Percepção e Sobrevivência
 * EQUIPAMENTO
 * Você começa com o seguinte equipamento, além do
 * equipamento concedido pelo seu antecedente:
 *  (a) brunea ou (b) armadura de couro
 *  (a) duas espadas curtas ou (b) duas armas simples corpo-a-corpo
 *  (a) um pacote de explorador ou (b) um pacote de aventureiro
 *  Um arco longo e uma aljava com 20 flechas
 */
@Component
public class RangerClassesGenerator extends AbstractClassesGenerator {

    @Override
    protected List<SpellEnum> getSpellEnumList() {
        return Arrays.asList(
            // NIVEL 1
            SpellEnum.ALARM,
            SpellEnum.ANIMAL_FRIENDSHIP,
            SpellEnum.CURE_WOUNDS,
            SpellEnum.DETECT_MAGIC,
            SpellEnum.DETECT_POISON_AND_DISEASE,
            SpellEnum.ENSNARING_STRIKE,
            SpellEnum.FOG_CLOUD,
            SpellEnum.GOODBERRY,
            SpellEnum.HAIL_OF_THORNS,
            SpellEnum.HUNTERS_MARK,
            SpellEnum.JUMP,
            SpellEnum.LONGSTRIDER,
            SpellEnum.SPEAK_WITH_ANIMALS,

            // NIVEL 2
            SpellEnum.ANIMAL_MESSENGER,
            SpellEnum.BARKSKIN,
            SpellEnum.BEAST_SENSE,
            SpellEnum.CORDON_OF_ARROWS,
            SpellEnum.DARKVISION,
            SpellEnum.FIND_TRAPS,
            SpellEnum.LESSER_RESTORATION,
            SpellEnum.LOCATE_ANIMALS_OR_PLANTS,
            SpellEnum.LOCATE_OBJECT,
            SpellEnum.PASS_WITHOUT_TRACE,
            SpellEnum.PROTECTION_FROM_POISON,
            SpellEnum.SILENCE,
            SpellEnum.SPIKE_GROWTH,

            // NIVEL 3
            SpellEnum.CONJURE_ANIMALS,
            SpellEnum.CONJURE_BARRAGE,
            SpellEnum.DAYLIGHT,
            SpellEnum.LIGHTNING_ARROW,
            SpellEnum.NONDETECTION,
            SpellEnum.PLANT_GROWTH,
            SpellEnum.PROTECTION_FROM_ENERGY,
            SpellEnum.SPEAK_WITH_PLANTS,
            SpellEnum.WATER_BREATHING,
            SpellEnum.WATER_WALK,
            SpellEnum.WIND_WALL,

            // NIVEL 4
            SpellEnum.CONJURE_WOODLAND_BEINGS,
            SpellEnum.FREEDOM_OF_MOVEMENT,
            SpellEnum.GRASPING_VINE,
            SpellEnum.LOCATE_CREATURE,
            SpellEnum.STONESKIN,

            // NIVEL 5
            SpellEnum.COMMUNE_WITH_NATURE,
            SpellEnum.CONJURE_VOLLEY,
            SpellEnum.SWIFT_QUIVER,
            SpellEnum.TREE_STRIDE
        );
    }

    @Override
    public ClassEnum getClassName() {
        return ClassEnum.RANGER;
    }

    @Override
    public Integer getHP(Integer level, Integer constitutionModifier) {
        return getHP(level, constitutionModifier, 10);
    }

    @Override
    public List<Item> getItems() {
        List<Item> items = new ArrayList<>();

        if (random.nextBoolean()) {
            ArmorEnum.BREASTPLATE.toArmor(1);
        } else {
            ArmorEnum.LEATHER.toArmor(1);
        }

        if (random.nextBoolean()) {
            items.add(getAnySimpleMeleeWeapon());
            items.add(getAnySimpleMeleeWeapon());
        } else {
            items.add(WeaponEnum.SHORTSWORD.toWeapon(2));
        }

        items.add(getExplorerOrAdventurerPack());

        items.add(WeaponEnum.LONGBOW.toWeapon(1));
        items.add(GearEnum.ARROWS.toItem(20));
        items.add(GearEnum.QUIVER.toItem(1));

        return items;
    }

    @Override
    public List<Spell> getSpells(Integer npcLevel) {
        Set<SpellEnum> spells = new HashSet<>();
        if (npcLevel >= 2) {
            spells.add(addUniqueSpell(spells, 1));
            spells.add(addUniqueSpell(spells, 1));
        }
        if (npcLevel >= 3) {
            spells.add(addUniqueSpell(spells, 1));
        }
        if (npcLevel >= 5) {
            spells.add(addUniqueSpell(spells, 2));
        }
        if (npcLevel >= 7) {
            spells.add(addUniqueSpell(spells, 2));
        }
        if (npcLevel >= 9) {
            spells.add(addUniqueSpell(spells, 3));
        }
        if (npcLevel >= 11) {
            spells.add(addUniqueSpell(spells, 3));
        }
        if (npcLevel >= 13) {
            spells.add(addUniqueSpell(spells, 4));
        }
        if (npcLevel >= 15) {
            spells.add(addUniqueSpell(spells, 4));
        }
        if (npcLevel >= 17) {
            spells.add(addUniqueSpell(spells, 5));
        }
        if (npcLevel >= 19) {
            spells.add(addUniqueSpell(spells, 5));
        }
        return spells.stream()
                .map(spell -> spell.toSpell(npcLevel))
                .toList();
    }
}
