package com.raphaowl.dnd.service.generators.classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.raphaowl.dnd.dtos.Item;
import com.raphaowl.dnd.dtos.Spell;
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
    public List<Spell> getSpells(Integer npcLevel) {
        return List.of();
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
