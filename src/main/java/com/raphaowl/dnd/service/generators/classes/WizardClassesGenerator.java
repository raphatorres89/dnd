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
 * Dado de Vida: 1d6 por nível de mago
 * Pontos de Vida no 1° Nível: 6 + seu modificador de
 * Constituição
 * Pontos de Vida nos Níveis Seguintes: 1d6 (ou 4) + seu
 * modificador de Constituição por nível de mago após o
 * 1°
 * PROFICIÊNCIAS
 * Armaduras: Nenhuma
 * Armas: Adagas, dardos, fundas, bordões, bestas leves
 * Ferramentas: Nenhuma
 * Testes de Resistência: Inteligência, Sabedoria
 * Perícias: Escolha duas dentre Arcanismo, História,
 * Intuição, Investigação, Medicina e Religião
 * EQUIPAMENTO
 * Você começa com o seguinte equipamento, além do
 * equipamento concedido pelo seu antecedente:
 *  (a) um bordão ou (b) uma adaga
 *  (a) uma bolsa de componentes ou (b) um foco arcano
 *  (a) um pacote de estudioso ou (b) um pacote de explorador
 *  Um grimório
 */
@Component
public class WizardClassesGenerator extends AbstractClassesGenerator {

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
            SpellEnum.ALARM,
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
            SpellEnum.FIND_FAMILIAR,
            SpellEnum.FOG_CLOUD,
            SpellEnum.GREASE,
            SpellEnum.IDENTIFY,
            SpellEnum.ILLUSORY_SCRIPT,
            SpellEnum.JUMP,
            SpellEnum.LONGSTRIDER,
            SpellEnum.MAGE_ARMOR,
            SpellEnum.MAGIC_MISSILE,
            SpellEnum.PROTECTION_FROM_EVIL_AND_GOOD,
            SpellEnum.RAY_OF_SICKNESS,
            SpellEnum.SHIELD,
            SpellEnum.SILENT_IMAGE,
            SpellEnum.SLEEP,
            SpellEnum.TASHA_HIDEOUS_LAUGHTER,
            SpellEnum.TENSERS_FLOATING_DISC,
            SpellEnum.THUNDERWAVE,
            SpellEnum.UNSEEN_SERVANT,
            SpellEnum.WITCH_BOLT,

            // NIVEL 2
            SpellEnum.ALTER_SELF,
            SpellEnum.ARCANE_LOCK,
            SpellEnum.BLINDNESS_DEAFNESS,
            SpellEnum.BLUR,
            SpellEnum.CLOUD_OF_DAGGERS,
            SpellEnum.CONTINUAL_FLAME,
            SpellEnum.CROWN_OF_MADNESS,
            SpellEnum.DARKNESS,
            SpellEnum.DARKVISION,
            SpellEnum.DETECT_THOUGHTS,
            SpellEnum.ENLARGE_REDUCE,
            SpellEnum.FLAMING_SPHERE,
            SpellEnum.GENTLE_REPOSE,
            SpellEnum.GUST_OF_WIND,
            SpellEnum.HOLD_PERSON,
            SpellEnum.INVISIBILITY,
            SpellEnum.KNOCK,
            SpellEnum.LEVITATE,
            SpellEnum.LOCATE_OBJECT,
            SpellEnum.MAGIC_MOUTH,
            SpellEnum.MAGIC_WEAPON,
            SpellEnum.MELFS_ACID_ARROW,
            SpellEnum.MIRROR_IMAGE,
            SpellEnum.MISTY_STEP,
            SpellEnum.NYSTULS_MAGIC_AURA,
            SpellEnum.PHANTASMAL_FORCE,
            SpellEnum.RAY_OF_ENFEEBLEMENT,
            SpellEnum.ROPE_TRICK,
            SpellEnum.SCORCHING_RAY,
            SpellEnum.SEE_INVISIBILITY,
            SpellEnum.SHATTER,
            SpellEnum.SPIDER_CLIMB,
            SpellEnum.SUGGESTION,
            SpellEnum.WEB,

            // NIVEL 3
            SpellEnum.ANIMATE_DEAD,
            SpellEnum.BESTOW_CURSE,
            SpellEnum.BLINK,
            SpellEnum.CLAIRVOYANCE,
            SpellEnum.COUNTERSPELL,
            SpellEnum.DISPEL_MAGIC,
            SpellEnum.FEAR,
            SpellEnum.FEIGN_DEATH,
            SpellEnum.FIREBALL,
            SpellEnum.FLY,
            SpellEnum.GASEOUS_FORM,
            SpellEnum.GLYPH_OF_WARDING,
            SpellEnum.HASTE,
            SpellEnum.HYPNOTIC_PATTERN,
            SpellEnum.LIGHTNING_BOLT,
            SpellEnum.MAGIC_CIRCLE,
            SpellEnum.MAJOR_IMAGE,
            SpellEnum.NONDETECTION,
            SpellEnum.PHANTOM_STEED,
            SpellEnum.PROTECTION_FROM_ENERGY,
            SpellEnum.REMOVE_CURSE,
            SpellEnum.SENDING,
            SpellEnum.SLEET_STORM,
            SpellEnum.SLOW,
            SpellEnum.STINKING_CLOUD,
            SpellEnum.TONGUES,
            SpellEnum.VAMPIRIC_TOUCH,
            SpellEnum.WATER_BREATHING,

            // NIVEL 4
            SpellEnum.ARCANE_EYE,
            SpellEnum.BANISHMENT,
            SpellEnum.BLIGHT,
            SpellEnum.CONFUSION,
            SpellEnum.CONJURE_MINOR_ELEMENTALS,
            SpellEnum.CONTROL_WATER,
            SpellEnum.DIMENSION_DOOR,
            SpellEnum.EVARDS_BLACK_TENTACLES,
            SpellEnum.FABRICATE,
            SpellEnum.FIRE_SHIELD,
            SpellEnum.GREATER_INVISIBILITY,
            SpellEnum.HALLUCINATORY_TERRAIN,
            SpellEnum.ICE_STORM,
            SpellEnum.LEOMUNDS_SECRET_CHEST,
            SpellEnum.LOCATE_CREATURE,
            SpellEnum.MORDENKAINENS_FAITHFUL_HOUND,
            SpellEnum.MORDENKAINENS_PRIVATE_SANCTUM,
            SpellEnum.OTILUKES_RESILIENT_SPHERE,
            SpellEnum.PHANTASMAL_KILLER,
            SpellEnum.POLYMORPH,
            SpellEnum.STONE_SHAPE,
            SpellEnum.STONESKIN,
            SpellEnum.WALL_OF_FIRE,

            // NIVEL 5
            SpellEnum.ANIMATE_OBJECTS,
            SpellEnum.BIGBYS_HAND,
            SpellEnum.CLOUDKILL,
            SpellEnum.CONE_OF_COLD,
            SpellEnum.CONTACT_OTHER_PLANE,
            SpellEnum.CREATION,
            SpellEnum.DOMINATE_PERSON,
            SpellEnum.DREAM,
            SpellEnum.GEAS,
            SpellEnum.HOLD_MONSTER,
            SpellEnum.LEGEND_LORE,
            SpellEnum.MISLEAD,
            SpellEnum.MODIFY_MEMORY,
            SpellEnum.PASSWALL,
            SpellEnum.PLANAR_BINDING,
            SpellEnum.RARYS_TELEPATHIC_BOND,
            SpellEnum.SCRYING,
            SpellEnum.SEEMING,
            SpellEnum.TELEKINESIS,
            SpellEnum.TELEPORTATION_CIRCLE,
            SpellEnum.WALL_OF_FORCE,
            SpellEnum.WALL_OF_STONE,

            // NIVEL 6
            SpellEnum.ARCANE_GATE,
            SpellEnum.CHAIN_LIGHTNING,
            SpellEnum.CIRCLE_OF_DEATH,
            SpellEnum.CONTINGENCY,
            SpellEnum.CREATE_UNDEAD,
            SpellEnum.DISINTEGRATE,
            SpellEnum.DRAWMIJS_INSTANT_SUMMONS,
            SpellEnum.EYEBITE,
            SpellEnum.GLOBE_OF_INVULNERABILITY,
            SpellEnum.GUARDS_AND_WARDS,
            SpellEnum.MAGIC_JAR,
            SpellEnum.MASS_SUGGESTION,
            SpellEnum.MOVE_EARTH,
            SpellEnum.OTILUKES_FREEZING_SPHERE,
            SpellEnum.OTTOS_IRRESISTIBLE_DANCE,
            SpellEnum.PROGRAMMED_ILLUSION,
            SpellEnum.SUNBEAM,
            SpellEnum.TRUE_SEEING,
            SpellEnum.WALL_OF_ICE,

            // NIVEL 7
            SpellEnum.DELAYED_BLAST_FIREBALL,
            SpellEnum.ETHEREALNESS,
            SpellEnum.FINGER_OF_DEATH,
            SpellEnum.FORCECAGE,
            SpellEnum.MIRAGE_ARCANE,
            SpellEnum.MORDENKAINENS_MAGNIFICENT_MANSION,
            SpellEnum.MORDENKAINENS_SWORD,
            SpellEnum.PLANE_SHIFT,
            SpellEnum.PRISMATIC_SPRAY,
            SpellEnum.PROJECT_IMAGE,
            SpellEnum.REVERSE_GRAVITY,
            SpellEnum.SIMULACRUM,
            SpellEnum.SYMBOL,
            SpellEnum.TELEPORT,

            // NIVEL 8
            SpellEnum.ANTIMAGIC_FIELD,
            SpellEnum.ANTIPATHY_SYMPATHY,
            SpellEnum.CLONE,
            SpellEnum.CONTROL_WEATHER,
            SpellEnum.DEMIPLANE,
            SpellEnum.DOMINATE_MONSTER,
            SpellEnum.FEEBLEMIND,
            SpellEnum.INCENDIARY_CLOUD,
            SpellEnum.MAZE,
            SpellEnum.MIND_BLANK,
            SpellEnum.POWER_WORD_STUN,
            SpellEnum.SUNBURST,
            SpellEnum.TELEPATHY,
            SpellEnum.TRAP_THE_SOUL,

            // NIVEL 9
            SpellEnum.ASTRAL_PROJECTION,
            SpellEnum.FORESIGHT,
            SpellEnum.GATE,
            SpellEnum.IMPRISONMENT,
            SpellEnum.METEOR_SWARM,
            SpellEnum.POWER_WORD_KILL,
            SpellEnum.PRISMATIC_WALL,
            SpellEnum.SHAPECHANGE,
            SpellEnum.TIME_STOP,
            SpellEnum.TRUE_POLYMORPH,
            SpellEnum.WEIRD,
            SpellEnum.WISH
        );
    }

    @Override
    public List<Spell> getSpells(Integer npcLevel) {
        return List.of();
    }

    @Override
    public ClassEnum getClassName() {
        return ClassEnum.WIZARD;
    }

    @Override
    public Integer getHP(Integer level, Integer constitutionModifier) {
        return getHP(level, constitutionModifier, 6);
    }

    @Override
    public List<Item> getItems() {
        List<Item> items = new ArrayList<>();

        if (random.nextBoolean()) {
            items.add(WeaponEnum.QUARTERSTAFF.toWeapon(1));
        } else {
            items.add(WeaponEnum.DAGGER.toWeapon(1));
        }

        if (random.nextBoolean()) {
            items.add(GearEnum.COMPONENT_POUCH.toItem(1));
        } else {
            items.add(getAnyArcaneFocus());
        }

        if (random.nextBoolean()) {
            items.add(GearEnum.SCHOLAR_PACK.toItem(1));
        } else {
            items.add(GearEnum.EXPLORER_PACK.toItem(1));
        }

        items.add(GearEnum.GRIMOIRE.toItem(1));

        return items;
    }
}
