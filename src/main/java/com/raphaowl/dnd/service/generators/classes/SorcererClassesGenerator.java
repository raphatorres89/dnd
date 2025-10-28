package com.raphaowl.dnd.service.generators.classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import com.raphaowl.dnd.dtos.Item;
import com.raphaowl.dnd.dtos.NpcStats;
import com.raphaowl.dnd.enums.ClassEnum;
import com.raphaowl.dnd.enums.GearEnum;
import com.raphaowl.dnd.enums.SpellEnum;
import com.raphaowl.dnd.enums.WeaponEnum;

import org.springframework.stereotype.Component;

/**
 * PONTOS DE VIDA
 * Dado de Vida: 1d6 por nível de feiticeiro
 * Pontos de Vida no 1° Nível: 6 + seu modificador de
 * Constituição
 * Pontos de Vida nos Níveis Seguintes: 1d6 (ou 4) + seu
 * modificador de Constituição por nível de feiticeiro após
 * o 1°
 * PROFICIÊNCIAS
 * Armaduras: Nenhuma
 * Armas: Adagas, dardos, fundas, bordões e bestas leves
 * Ferramentas: Nenhuma
 * Testes de Resistência: Constituição, Carisma
 * Perícias: Escolha duas dentre Arcanismo, Enganação,
 * Intuição, Intimidação, Persuasão e Religião
 * EQUIPAMENTO
 * Você começa com o seguinte equipamento, além do
 * equipamento concedido pelo seu antecedente:
 *  (a) uma besta leve e 20 virotes ou (b) qualquer arma simples
 *  (a) uma bolsa de componentes ou (b) um foco arcano
 *  (a) um pacote de explorador ou (b) um pacote de aventureiro
 */
@Component
public class SorcererClassesGenerator extends AbstractClassesGenerator {

    @Override
    protected List<SpellEnum> getSpellEnumList() {
        return Arrays.asList(
            // CANTRIPS (TRUQUES)
            SpellEnum.ACID_SPLASH,
            SpellEnum.BLADE_WARD,
            SpellEnum.CHILL_TOUCH,
            SpellEnum.DANCING_LIGHTS,
            SpellEnum.FIRE_BOLT,
            SpellEnum.FRIENDS,
            SpellEnum.LIGHT,
            SpellEnum.MAGE_HAND,
            SpellEnum.MENDING,
            SpellEnum.MESSAGE,
            SpellEnum.MINOR_ILLUSION,
            SpellEnum.POISON_SPRAY,
            SpellEnum.PRESTIDIGITATION,
            SpellEnum.RAY_OF_FROST,
            SpellEnum.SHOCKING_GRASP,
            SpellEnum.TRUE_STRIKE,

            // NIVEL 1
            SpellEnum.BURNING_HANDS,
            SpellEnum.CHARM_PERSON,
            SpellEnum.CHROMATIC_ORB,
            SpellEnum.COLOR_SPRAY,
            SpellEnum.COMPREHEND_LANGUAGES,
            SpellEnum.DETECT_MAGIC,
            SpellEnum.DISGUISE_SELF,
            SpellEnum.EXPEDITIOUS_RETREAT,
            SpellEnum.FALSE_LIFE,
            SpellEnum.FEATHER_FALL,
            SpellEnum.FOG_CLOUD,
            SpellEnum.JUMP,
            SpellEnum.MAGE_ARMOR,
            SpellEnum.MAGIC_MISSILE,
            SpellEnum.RAY_OF_SICKNESS,
            SpellEnum.SHIELD,
            SpellEnum.SILENT_IMAGE,
            SpellEnum.SLEEP,
            SpellEnum.THUNDERWAVE,
            SpellEnum.WITCH_BOLT,

            // NIVEL 2
            SpellEnum.ALTER_SELF,
            SpellEnum.BLINDNESS_DEAFNESS,
            SpellEnum.BLUR,
            SpellEnum.CLOUD_OF_DAGGERS,
            SpellEnum.CROWN_OF_MADNESS,
            SpellEnum.DARKNESS,
            SpellEnum.DARKVISION,
            SpellEnum.DETECT_THOUGHTS,
            SpellEnum.ENHANCE_ABILITY,
            SpellEnum.ENLARGE_REDUCE,
            SpellEnum.GUST_OF_WIND,
            SpellEnum.HOLD_PERSON,
            SpellEnum.INVISIBILITY,
            SpellEnum.KNOCK,
            SpellEnum.LEVITATE,
            SpellEnum.MIRROR_IMAGE,
            SpellEnum.MISTY_STEP,
            SpellEnum.PHANTASMAL_FORCE,
            SpellEnum.SCORCHING_RAY,
            SpellEnum.SEE_INVISIBILITY,
            SpellEnum.SHATTER,
            SpellEnum.SPIDER_CLIMB,
            SpellEnum.SUGGESTION,
            SpellEnum.WEB,

            // NIVEL 3
            SpellEnum.BLINK,
            SpellEnum.CLAIRVOYANCE,
            SpellEnum.COUNTERSPELL,
            SpellEnum.DAYLIGHT,
            SpellEnum.DISPEL_MAGIC,
            SpellEnum.FEAR,
            SpellEnum.FIREBALL,
            SpellEnum.FLY,
            SpellEnum.GASEOUS_FORM,
            SpellEnum.HASTE,
            SpellEnum.HYPNOTIC_PATTERN,
            SpellEnum.LIGHTNING_BOLT,
            SpellEnum.MAJOR_IMAGE,
            SpellEnum.PROTECTION_FROM_ENERGY,
            SpellEnum.SLEET_STORM,
            SpellEnum.SLOW,
            SpellEnum.STINKING_CLOUD,
            SpellEnum.TONGUES,
            SpellEnum.WATER_BREATHING,
            SpellEnum.WATER_WALK,

            // NIVEL 4
            SpellEnum.BANISHMENT,
            SpellEnum.BLIGHT,
            SpellEnum.CONFUSION,
            SpellEnum.DIMENSION_DOOR,
            SpellEnum.DOMINATE_BEAST,
            SpellEnum.GREATER_INVISIBILITY,
            SpellEnum.ICE_STORM,
            SpellEnum.POLYMORPH,
            SpellEnum.STONESKIN,
            SpellEnum.WALL_OF_FIRE,

            // NIVEL 5
            SpellEnum.ANIMATE_OBJECTS,
            SpellEnum.CLOUDKILL,
            SpellEnum.CONE_OF_COLD,
            SpellEnum.CREATION,
            SpellEnum.DOMINATE_PERSON,
            SpellEnum.HOLD_MONSTER,
            SpellEnum.INSECT_PLAGUE,
            SpellEnum.SEEMING,
            SpellEnum.TELEKINESIS,
            SpellEnum.TELEPORTATION_CIRCLE,
            SpellEnum.WALL_OF_STONE,

            // NIVEL 6
            SpellEnum.ARCANE_GATE,
            SpellEnum.CHAIN_LIGHTNING,
            SpellEnum.CIRCLE_OF_DEATH,
            SpellEnum.DISINTEGRATE,
            SpellEnum.EYEBITE,
            SpellEnum.GLOBE_OF_INVULNERABILITY,
            SpellEnum.MASS_SUGGESTION,
            SpellEnum.MOVE_EARTH,
            SpellEnum.SUNBEAM,
            SpellEnum.TRUE_SEEING,

            // NIVEL 7
            SpellEnum.DELAYED_BLAST_FIREBALL,
            SpellEnum.ETHEREALNESS,
            SpellEnum.FINGER_OF_DEATH,
            SpellEnum.FIRE_STORM,
            SpellEnum.PLANE_SHIFT,
            SpellEnum.PRISMATIC_SPRAY,
            SpellEnum.REVERSE_GRAVITY,
            SpellEnum.TELEPORT,

            // NIVEL 8
            SpellEnum.DOMINATE_MONSTER,
            SpellEnum.EARTHQUAKE,
            SpellEnum.INCENDIARY_CLOUD,
            SpellEnum.POWER_WORD_STUN,
            SpellEnum.SUNBURST,

            // NIVEL 9
            SpellEnum.GATE,
            SpellEnum.METEOR_SWARM,
            SpellEnum.POWER_WORD_KILL,
            SpellEnum.TIME_STOP,
            SpellEnum.WISH
        );
    }

    @Override
    protected void generateSpells(Set<SpellEnum> spells, Integer npcLevel, NpcStats npcStats) {

        // --- 1. GERAÇÃO DE TRUQUES (Cantrips) ---
        // Segue a progressão oficial: 4 (Nv 1-3), 5 (Nv 4-9), 6 (Nv 10+)
        int cantrips = switch (npcLevel) {
            case 1, 2, 3 -> 4;
            case 4, 5, 6, 7, 8, 9 -> 5;
            default -> 6;
        };
        for (int i = 0; i < cantrips; i++) {
            spells.add(addUniqueSpell(spells, 0)); // Círculo 0 = Truques
        }

        // --- 2. CÁLCULO DE MAGIAS CONHECIDAS (knownSpells) ---
        // Progressão fixa conforme a Tabela de Classe de Feiticeiro
        int knownSpells = switch (npcLevel) {
            case 1 -> 2; case 2 -> 3; case 3 -> 4; case 4 -> 5; case 5 -> 6;
            case 6 -> 7; case 7 -> 8; case 8 -> 9; case 9 -> 10; case 10 -> 11;
            case 11 -> 12; case 12 -> 12; case 13 -> 13; case 14 -> 13; case 15 -> 14;
            case 16 -> 14; case 17 -> 15; case 18, 19, 20 -> 15; default -> 2;
        };

        // --- 3. NÍVEL MÁXIMO DE MAGIA (maxSpellLevel) ---
        // A progressão do círculo máximo (slots) está correta
        int maxSpellLevel =
                npcLevel <= 2 ? 1 :
                        npcLevel <= 4 ? 2 :
                                npcLevel <= 6 ? 3 :
                                        npcLevel <= 8 ? 4 :
                                                npcLevel <= 10 ? 5 :
                                                        npcLevel <= 12 ? 6 :
                                                                npcLevel <= 14 ? 7 :
                                                                        npcLevel <= 16 ? 8 : 9;

        // --- 4. DISTRIBUIÇÃO PONDERADA DE MAGIAS ---
        for (int i = 0; i < knownSpells; i++) {

            int selectedLevel;

            // Em níveis muito baixos, o Feiticeiro só pode ter magias de 1º Círculo.
            if (maxSpellLevel == 1) {
                selectedLevel = 1;
            } else {
                // Heurística de Ponderação: Garante que os níveis mais baixos sejam mais comuns.
                // Calcula um nível potencial aleatório entre 1 e maxSpellLevel
                int potentialLevel = (int) (Math.random() * maxSpellLevel) + 1;

                // Força que 75% das magias sejam de círculos <= maxSpellLevel - 1.
                if (i < knownSpells * 0.75) {
                    // Limita o nível escolhido ao penúltimo círculo disponível (ou 1, se for o caso)
                    selectedLevel = Math.min(potentialLevel, Math.max(1, maxSpellLevel - 1));
                } else {
                    // Os 25% restantes podem ser do círculo mais alto
                    selectedLevel = potentialLevel;
                }
                // Garante que o nível escolhido não ultrapasse o limite real.
                selectedLevel = Math.min(selectedLevel, maxSpellLevel);
            }

            spells.add(addUniqueSpell(spells, selectedLevel));
        }
    }

    @Override
    public ClassEnum getClassName() {
        return ClassEnum.SORCERER;
    }

    @Override
    public Integer getHP(Integer level, Integer constitutionModifier) {
        return getHP(level, constitutionModifier, 6);
    }

    @Override
    public List<Item> getItems() {
        List<Item> items = new ArrayList<>();

        if (random.nextBoolean()) {
            items.add(WeaponEnum.LIGHT_CROSSBOW.toWeapon(1));
            items.add(GearEnum.CROSSBOW_BOLTS.toItem(20));
        } else {
            items.add(getAnySimpleWeapon());
        }
        if (random.nextBoolean()) {
            items.add(GearEnum.COMPONENT_POUCH.toItem(1));
        } else {
            items.add(getAnyArcaneFocus());
        }

        items.add(getExplorerOrAdventurerPack());

        return items;
    }
}
