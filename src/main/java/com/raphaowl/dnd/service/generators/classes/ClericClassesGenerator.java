package com.raphaowl.dnd.service.generators.classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
 * Dado de Vida: 1d8 por nível de clérigo
 * Pontos de Vida no 1° Nível: 8 + seu modificador de
 * Constituição
 * Pontos de Vida nos Níveis Seguintes: 1d8 (ou 5) + seu
 * modificador de Constituição por nível de clérigo após o
 * 1°
 * PROFICIÊNCIAS
 * Armaduras: Armaduras leves, armaduras médias,
 * escudos
 * Armas: Todas as armas simples
 * Ferramentas: Nenhuma
 * Testes de Resistência: Sabedoria, Carisma
 * Perícias: Escolha duas dentre História, Intuição,
 * Medicina, Persuasão e Religião
 * EQUIPAMENTO
 * Você começa com o seguinte equipamento, além do
 * equipamento concedido pelo seu antecedente:
 *  (a) uma maça ou (b) um martelo de guerra (se for proficiente)
 *  (a) brunea, (b) armadura de couro ou (c) cota de malha (se for proficiente)
 *  (a) um besta leve e 20 virotes ou (b) qualquer arma simples
 *  (a) um pacote de sacerdote ou (b) um pacote de aventureiro
 *  Um escudo e um símbolo sagrado
 */
@Component
public class ClericClassesGenerator extends AbstractClassesGenerator {

    @Override
    protected List<SpellEnum> getSpellEnumList() {
        return Arrays.asList(
            // CANTRIPS (TRUQUES)
            SpellEnum.GUIDANCE,
            SpellEnum.LIGHT,
            SpellEnum.MENDING,
            SpellEnum.RESISTANCE,
            SpellEnum.SACRED_FLAME,
            SpellEnum.SPARE_THE_DYING,
            SpellEnum.THAUMATURGY,

            // NIVEL 1
            SpellEnum.BANE,
            SpellEnum.BLESS,
            SpellEnum.COMMAND,
            SpellEnum.CREATE_OR_DESTROY_WATER,
            SpellEnum.CURE_WOUNDS,
            SpellEnum.DETECT_EVIL_AND_GOOD,
            SpellEnum.DETECT_MAGIC,
            SpellEnum.DETECT_POISON_AND_DISEASE,
            SpellEnum.GUIDING_BOLT,
            SpellEnum.HEALING_WORD,
            SpellEnum.INFLICT_WOUNDS,
            SpellEnum.PROTECTION_FROM_EVIL_AND_GOOD,
            SpellEnum.PURIFY_FOOD_AND_DRINK,
            SpellEnum.SANCTUARY,
            SpellEnum.SHIELD_OF_FAITH,

            // NIVEL 2
            SpellEnum.AID,
            SpellEnum.AUGURY,
            SpellEnum.BLINDNESS_DEAFNESS,
            SpellEnum.CALM_EMOTIONS,
            SpellEnum.CONTINUAL_FLAME,
            SpellEnum.ENHANCE_ABILITY,
            SpellEnum.FIND_TRAPS,
            SpellEnum.GENTLE_REPOSE,
            SpellEnum.HOLD_PERSON,
            SpellEnum.LESSER_RESTORATION,
            SpellEnum.LOCATE_OBJECT,
            SpellEnum.PRAYER_OF_HEALING,
            SpellEnum.PROTECTION_FROM_POISON,
            SpellEnum.SILENCE,
            SpellEnum.SPIRITUAL_WEAPON,
            SpellEnum.WARDING_BOND,
            SpellEnum.ZONE_OF_TRUTH,

            // NIVEL 3
            SpellEnum.ANIMATE_DEAD,
            SpellEnum.BEACON_OF_HOPE,
            SpellEnum.BESTOW_CURSE,
            SpellEnum.CLAIRVOYANCE,
            SpellEnum.CREATE_FOOD_AND_WATER,
            SpellEnum.DAYLIGHT,
            SpellEnum.DISPEL_MAGIC,
            SpellEnum.FEIGN_DEATH,
            SpellEnum.GLYPH_OF_WARDING,
            SpellEnum.MAGIC_CIRCLE,
            SpellEnum.MASS_HEALING_WORD,
            SpellEnum.MELD_INTO_STONE,
            SpellEnum.PROTECTION_FROM_ENERGY,
            SpellEnum.REMOVE_CURSE,
            SpellEnum.REVIVIFY,
            SpellEnum.SENDING,
            SpellEnum.SPEAK_WITH_DEAD,
            SpellEnum.SPIRIT_GUARDIANS,
            SpellEnum.TONGUES,
            SpellEnum.WATER_WALK,

            // NIVEL 4
            SpellEnum.BANISHMENT,
            SpellEnum.CONTROL_WATER,
            SpellEnum.DEATH_WARD,
            SpellEnum.DIVINATION,
            SpellEnum.FREEDOM_OF_MOVEMENT,
            SpellEnum.GUARDIAN_OF_FAITH,
            SpellEnum.LOCATE_CREATURE,
            SpellEnum.STONE_SHAPE,

            // NIVEL 5
            SpellEnum.COMMUNE,
            SpellEnum.CONTAGION,
            SpellEnum.DISPEL_EVIL_AND_GOOD,
            SpellEnum.FLAME_STRIKE,
            SpellEnum.GEAS,
            SpellEnum.GREATER_RESTORATION,
            SpellEnum.HALLOW,
            SpellEnum.INSECT_PLAGUE,
            SpellEnum.LEGEND_LORE,
            SpellEnum.MASS_CURE_WOUNDS,
            SpellEnum.PLANAR_BINDING,
            SpellEnum.RAISE_DEAD,
            SpellEnum.SCRYING,

            // NIVEL 6
            SpellEnum.BLADE_BARRIER,
            SpellEnum.CREATE_UNDEAD,
            SpellEnum.FIND_THE_PATH,
            SpellEnum.FORBIDDANCE,
            SpellEnum.HARM,
            SpellEnum.HEAL,
            SpellEnum.HEROES_FEAST,
            SpellEnum.PLANAR_ALLY,
            SpellEnum.TRUE_SEEING,
            SpellEnum.WORD_OF_RECALL,

            // NIVEL 7
            SpellEnum.CONJURE_CELESTIAL,
            SpellEnum.DIVINE_WORD,
            SpellEnum.ETHEREALNESS,
            SpellEnum.FIRE_STORM,
            SpellEnum.PLANE_SHIFT,
            SpellEnum.REGENERATE,
            SpellEnum.RESURRECTION,
            SpellEnum.SYMBOL,

            // NIVEL 8
            SpellEnum.ANTIMAGIC_FIELD,
            SpellEnum.CONTROL_WEATHER,
            SpellEnum.EARTHQUAKE,
            SpellEnum.HOLY_AURA,

            // NIVEL 9
            SpellEnum.ASTRAL_PROJECTION,
            SpellEnum.GATE,
            SpellEnum.MASS_HEAL,
            SpellEnum.TRUE_RESURRECTION
        );
    }

    @Override
    public ClassEnum getClassName() {
        return ClassEnum.CLERIC;
    }

    @Override
    public Integer getHP(Integer level, Integer constitutionModifier) {
        return getHP(level, constitutionModifier, 8);
    }

    @Override
    public List<Item> getItems() {
        List<Item> items = new ArrayList<>();
        items.add(getMainWeapon());
        items.add(getArmor());

        if (random.nextBoolean()) {
            items.add(WeaponEnum.HAND_CROSSBOW.toWeapon(1));
            items.add(GearEnum.CROSSBOW_BOLTS.toItem(20));
        } else {
            items.add(getAnySimpleWeapon());
        }

        items.add(getPack());
        items.add(ArmorEnum.SHIELD.toArmor(1));
        items.add(getHolySymbol());

        return items;
    }

    @Override
    public List<Spell> getSpells(Integer npcLevel) {
        return List.of();
    }

    private Item getPack() {
        if (random.nextBoolean()) {
            GearEnum.PRIEST_PACK.toItem(1);
        }
        return GearEnum.ADVENTURER_PACK.toItem(1);
    }

    private Item getArmor() {
        int choice = random.nextInt(3);
        Item armor;
        if (choice == 0) {
            armor = ArmorEnum.BREASTPLATE.toArmor(1);
        } else if (choice == 1) {
            armor = ArmorEnum.LEATHER.toArmor(1);
        } else {
            armor = ArmorEnum.CHAIN_MAIL.toArmor(1);
        }
        return armor;
    }

    private Item getMainWeapon() {
        if (random.nextBoolean()) {
            WeaponEnum.MACE.toWeapon(1);
        }
        return WeaponEnum.WARHAMMER.toWeapon(1);
    }
}
