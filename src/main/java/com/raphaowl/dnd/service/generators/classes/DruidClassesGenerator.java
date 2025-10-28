package com.raphaowl.dnd.service.generators.classes;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import com.raphaowl.dnd.dtos.Item;
import com.raphaowl.dnd.dtos.NpcStats;
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
    protected void generateSpells(Set<SpellEnum> spells, Integer npcLevel, NpcStats npcStats) {
        // 1. GERAÇÃO DE TRUQUES (MANTIDO)
        int cantrips = switch (npcLevel) {
            case 1, 2, 3 -> 2;
            case 4, 5, 6, 7, 8, 9 -> 3;
            default -> 4;
        };
        for (int i = 0; i < cantrips; i++) {
            spells.add(addUniqueSpell(spells, 0));
        }

        // 2. MAGIAS CONHECIDAS (MANTIDO)
        int knownSpells = switch (npcLevel) {
            case 1 -> 4; case 2 -> 5; case 3 -> 6; case 4 -> 7; case 5 -> 8;
            case 6 -> 9; case 7 -> 10; case 8 -> 11; case 9 -> 12; case 10 -> 14;
            case 11 -> 15; case 12 -> 15; case 13 -> 16; case 14 -> 18; case 15 -> 19;
            case 16 -> 19; case 17 -> 20; case 18, 19, 20 -> 22; default -> 4;
        };

        // 3. NÍVEL MÁXIMO DE MAGIA (MANTIDO)
        int maxSpellLevel =
                npcLevel <= 2 ? 1 :
                        npcLevel <= 4 ? 2 :
                                npcLevel <= 6 ? 3 :
                                        npcLevel <= 8 ? 4 :
                                                npcLevel <= 10 ? 5 :
                                                        npcLevel <= 12 ? 6 :
                                                                npcLevel <= 14 ? 7 :
                                                                        npcLevel <= 16 ? 8 : 9;

        // 4. DISTRIBUIÇÃO CORRIGIDA E PONDERADA
        for (int i = 0; i < knownSpells; i++) {
            // Gera um círculo de magia aleatório entre 1 e o nível máximo permitido.
            // É essencial que addUniqueSpell aceite um 'maxLevel' e selecione
            // o círculo da magia, dando preferência aos níveis mais baixos.

            // Se você não tem uma lógica de ponderação, você pode forçar uma distribuição simples,
            // garantindo que magias de nível mais alto sejam raras:

            int selectedLevel;
            if (npcLevel <= 2) {
                selectedLevel = 1; // Níveis iniciais: apenas magias de 1º círculo
            } else {
                // Gera um número aleatório. Magias de nível mais baixo devem ter mais chance.
                // Exemplo: 50% de chance de ser nível 1, 25% nível 2, 12.5% nível 3, etc.
                // Aqui, usamos o nível atual da iteração, mas limitado pelo maxSpellLevel.

                // Uma heurística mais simples para um gerador:
                // 75% das magias devem ser de círculos de magia <= maxSpellLevel - 1.
                int potentialLevel = (int) (Math.random() * maxSpellLevel) + 1;

                // Garantimos que magias mais poderosas (maxSpellLevel) sejam mais raras.
                if (i < knownSpells * 0.75) {
                    // 75% das magias: limitar a (max - 1) ou 1, o que for maior
                    selectedLevel = Math.min(potentialLevel, Math.max(1, maxSpellLevel - 1));
                } else {
                    // 25% das magias: podem ser do círculo mais alto
                    selectedLevel = Math.min(potentialLevel, maxSpellLevel);
                }
            }

            spells.add(addUniqueSpell(spells, selectedLevel));
        }
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
