package com.raphaowl.dnd.service.generators.classes;

import java.util.Arrays;
import java.util.List;

import com.raphaowl.dnd.dtos.Item;
import com.raphaowl.dnd.dtos.Spell;
import com.raphaowl.dnd.enums.ArmorEnum;
import com.raphaowl.dnd.enums.ClassEnum;
import com.raphaowl.dnd.enums.GearEnum;
import com.raphaowl.dnd.enums.SpellEnum;
import com.raphaowl.dnd.enums.ToolEnum;
import com.raphaowl.dnd.enums.WeaponEnum;

import org.springframework.stereotype.Component;

/**
 * PONTOS DE VIDA
 * Dado de Vida: 1d8 por nível de druida
 * Pontos de Vida no 1° Nível: 8 + seu modificador de
 * Constituição
 * Pontos de Vida nos Níveis Seguintes: 1d8 (ou 5) + seu
 * modificador de Constituição por nível de druida após o
 * 1°
 * PROFICIÊNCIAS
 * Armaduras: Armaduras leves, armaduras médias,
 * escudos (druidas não irão vestir armaduras ou usar
 * escudos feitos de metal)
 * Armas: Clavas, adagas, dardos, azagaias, maças,
 * bordões, cimitarras, foices, fundas e lanças.
 * Ferramentas: Kit de herbalismo
 * Testes de Resistência: Inteligência, Sabedoria
 * Perícias: Escolha duas dentre Arcanismo, Adestrar
 * Animais, Intuição, Medicina, Natureza, Percepção,
 * Religião e Sobrevivência
 * EQUIPAMENTO
 * Você começa com o seguinte equipamento, além do
 * equipamento concedido pelo seu antecedente:
 *  (a) um escudo de madeira ou (b) qualquer arma simples
 * (a) uma cimitarra ou (b) qualquer arma corpo-a-corpo simples
 * (a) um pacote de estudioso ou (b) um pacote de explorador
 *  Armadura de couro, um pacote de aventureiro e um foco druídico
 */
@Component
public class DruidClassesGenerator extends AbstractClassesGenerator {

    @Override
    protected List<SpellEnum> getSpellEnumList() {
        return Arrays.asList(
            // CANTRIPS (TRUQUES)
            SpellEnum.DRUIDCRAFT,
            SpellEnum.GUIDANCE,
            SpellEnum.MENDING,
            SpellEnum.POISON_SPRAY,
            SpellEnum.PRODUCE_FLAME,
            SpellEnum.RESISTANCE,
            SpellEnum.SHILLELAGH,
            SpellEnum.THORN_WHIP,

            // NIVEL 1
            SpellEnum.ANIMAL_FRIENDSHIP,
            SpellEnum.CHARM_PERSON,
            SpellEnum.CREATE_OR_DESTROY_WATER,
            SpellEnum.CURE_WOUNDS,
            SpellEnum.DETECT_MAGIC,
            SpellEnum.DETECT_POISON_AND_DISEASE,
            SpellEnum.ENTANGLE,
            SpellEnum.FAERIE_FIRE,
            SpellEnum.FOG_CLOUD,
            SpellEnum.GOODBERRY,
            SpellEnum.HEALING_WORD,
            SpellEnum.JUMP,
            SpellEnum.LONGSTRIDER,
            SpellEnum.PURIFY_FOOD_AND_DRINK,
            SpellEnum.SPEAK_WITH_ANIMALS,
            SpellEnum.THUNDERWAVE,

            // NIVEL 2
            SpellEnum.ANIMAL_MESSENGER,
            SpellEnum.BARKSKIN,
            SpellEnum.BEAST_SENSE,
            SpellEnum.DARKVISION,
            SpellEnum.ENHANCE_ABILITY,
            SpellEnum.FIND_TRAPS,
            SpellEnum.FLAME_BLADE,
            SpellEnum.FLAMING_SPHERE,
            SpellEnum.GUST_OF_WIND,
            SpellEnum.HEAT_METAL,
            SpellEnum.HOLD_PERSON,
            SpellEnum.LESSER_RESTORATION,
            SpellEnum.LOCATE_ANIMALS_OR_PLANTS,
            SpellEnum.LOCATE_OBJECT,
            SpellEnum.MOONBEAM,
            SpellEnum.PASS_WITHOUT_TRACE,
            SpellEnum.PROTECTION_FROM_POISON,
            SpellEnum.SPIKE_GROWTH,

            // NIVEL 3
            SpellEnum.CALL_LIGHTNING,
            SpellEnum.CONJURE_ANIMALS,
            SpellEnum.DAYLIGHT,
            SpellEnum.DISPEL_MAGIC,
            SpellEnum.FEIGN_DEATH,
            SpellEnum.MELD_INTO_STONE,
            SpellEnum.PLANT_GROWTH,
            SpellEnum.PROTECTION_FROM_ENERGY,
            SpellEnum.SLEET_STORM,
            SpellEnum.SPEAK_WITH_PLANTS,
            SpellEnum.WATER_BREATHING,
            SpellEnum.WATER_WALK,
            SpellEnum.WIND_WALL,

            // NIVEL 4
            SpellEnum.BLIGHT,
            SpellEnum.CONFUSION,
            SpellEnum.CONJURE_MINOR_ELEMENTALS,
            SpellEnum.CONJURE_WOODLAND_BEINGS,
            SpellEnum.CONTROL_WATER,
            SpellEnum.DOMINATE_BEAST,
            SpellEnum.FREEDOM_OF_MOVEMENT,
            SpellEnum.GIANT_INSECT,
            SpellEnum.GRASPING_VINE,
            SpellEnum.HALLUCINATORY_TERRAIN,
            SpellEnum.ICE_STORM,
            SpellEnum.LOCATE_CREATURE,
            SpellEnum.POLYMORPH,
            SpellEnum.STONE_SHAPE,
            SpellEnum.STONESKIN,
            SpellEnum.WALL_OF_FIRE,

            // NIVEL 5
            SpellEnum.ANTILIFE_SHELL,
            SpellEnum.AWAKEN,
            SpellEnum.COMMUNE_WITH_NATURE,
            SpellEnum.CONJURE_ELEMENTAL,
            SpellEnum.CONTAGION,
            SpellEnum.GEAS,
            SpellEnum.GREATER_RESTORATION,
            SpellEnum.INSECT_PLAGUE,
            SpellEnum.MASS_CURE_WOUNDS,
            SpellEnum.PLANAR_BINDING,
            SpellEnum.REINCARNATE,
            SpellEnum.SCRYING,
            SpellEnum.TREE_STRIDE,
            SpellEnum.WALL_OF_STONE,

            // NIVEL 6
            SpellEnum.CONJURE_FEY,
            SpellEnum.FIND_THE_PATH,
            SpellEnum.HEAL,
            SpellEnum.HEROES_FEAST,
            SpellEnum.MOVE_EARTH,
            SpellEnum.SUNBEAM,
            SpellEnum.TRANSPORT_VIA_PLANTS,
            SpellEnum.WALL_OF_THORNS,
            SpellEnum.WIND_WALK,

            // NIVEL 7
            SpellEnum.FIRE_STORM,
            SpellEnum.MIRAGE_ARCANE,
            SpellEnum.PLANE_SHIFT,
            SpellEnum.REGENERATE,
            SpellEnum.REVERSE_GRAVITY,

            // NIVEL 8
            SpellEnum.ANIMAL_SHAPES,
            SpellEnum.ANTIPATHY_SYMPATHY,
            SpellEnum.CONTROL_WEATHER,
            SpellEnum.EARTHQUAKE,
            SpellEnum.FEEBLEMIND,
            SpellEnum.SUNBURST,
            SpellEnum.TSUNAMI,

            // NIVEL 9
            SpellEnum.FORESIGHT,
            SpellEnum.SHAPECHANGE,
            SpellEnum.STORM_OF_VENGEANCE,
            SpellEnum.TRUE_RESURRECTION
        );
    }

    @Override
    public List<Spell> getSpells(Integer npcLevel) {
        return List.of();
    }

    @Override
    public ClassEnum getClassName() {
        return ClassEnum.DRUID;
    }

    @Override
    public Integer getHP(Integer level, Integer constitutionModifier) {
        return getHP(level, constitutionModifier, 8);
    }

    @Override
    public List<Item> getItems() {
        return List.of(
                getMainWeapon(),
                getSecondaryWeapon(),
                getPack().toItem(1),
                ArmorEnum.LEATHER.toArmor(1),
                GearEnum.ADVENTURER_PACK.toItem(1),
                getDruidicFocus(),
                ToolEnum.HERBALISM_KIT.toItem(1)
        );
    }

    private Item getDruidicFocus() {
        List<GearEnum> focuses = List.of(
                GearEnum.DRUIDIC_FOCUS_SPRIG,
                GearEnum.DRUIDIC_FOCUS_TOTEM,
                GearEnum.DRUIDIC_FOCUS_WOODEN_STAFF,
                GearEnum.DRUIDIC_FOCUS_YEW_WAND);
        return focuses.get(random.nextInt(focuses.size())).toItem(1);
    }

//    (a) um pacote de estudioso ou (b) um pacote de explorador
    private GearEnum getPack() {
        List<GearEnum> packs = List.of(GearEnum.SCHOLAR_PACK, GearEnum.ADVENTURER_PACK);
        return packs.get(random.nextInt(packs.size()));
    }

    private Item getMainWeapon() {
        if (random.nextBoolean()) {
            ArmorEnum.SHIELD.toArmor(1);
        }
        return getAnySimpleWeapon();
    }

//    (a) uma cimitarra ou (b) qualquer arma corpo-a-corpo simples
    private Item getSecondaryWeapon() {
        if (random.nextBoolean()) {
            WeaponEnum.SCIMITAR.toWeapon(1);
        }
        return getAnySimpleMeleeWeapon();
    }
}
