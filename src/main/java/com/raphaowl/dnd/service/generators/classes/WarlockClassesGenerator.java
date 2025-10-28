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
 * Dado de Vida: 1d8 por nível de bruxo
 * Pontos de Vida no 1° Nível: 8 + seu modificador de
 * Constituição
 * Pontos de Vida nos Níveis Seguintes: 1d8 (ou 5) + seu
 * modificador de Constituição por nível de bruxo após o
 * 1°
 * PROFICIÊNCIAS
 * Armaduras: Armaduras leves
 * Armas: Armas simples
 * Ferramentas: Nenhuma
 * Testes de Resistência: Sabedoria, Carisma
 * Perícias: Escolha duas dentre Arcanismo, Enganação,
 * História, Intimidação, Investigação, Natureza e
 * Religião
 * EQUIPAMENTO
 * Você começa com o seguinte equipamento, além do
 * equipamento concedido pelo seu antecedente:
 *  (a) uma besta leve e 20 virotes ou (b) qualquer arma simples
 *  (a) uma bolsa de componentes ou (b) um foco arcano
 *  (a) um pacote de estudioso ou (b) um pacote de explorador
 *  Armadura de couro, qualquer arma simples e duas adagas
 */
@Component
public class WarlockClassesGenerator extends AbstractClassesGenerator {

    @Override
    protected List<SpellEnum> getSpellEnumList() {
        return Arrays.asList(
            // Truques (Cantrips)
            SpellEnum.BLADE_WARD,
            SpellEnum.CHILL_TOUCH,
            SpellEnum.ELDRITCH_BLAST,
            SpellEnum.FRIENDS,
            SpellEnum.MAGE_HAND,
            SpellEnum.MINOR_ILLUSION,
            SpellEnum.POISON_SPRAY,
            SpellEnum.PRESTIDIGITATION,
            SpellEnum.TRUE_STRIKE,

            // Nível 1
            SpellEnum.ARMOR_OF_AGATHYS,
            SpellEnum.ARMS_OF_HADAR,
            SpellEnum.CHARM_PERSON,
            SpellEnum.COMPREHEND_LANGUAGES,
            SpellEnum.EXPEDITIOUS_RETREAT,
            SpellEnum.HELLISH_REBUKE,
            SpellEnum.HEX,
            SpellEnum.ILLUSORY_SCRIPT,
            SpellEnum.PROTECTION_FROM_EVIL_AND_GOOD,
            SpellEnum.UNSEEN_SERVANT,
            SpellEnum.WITCH_BOLT,

            // Nível 2
            SpellEnum.CLOUD_OF_DAGGERS,
            SpellEnum.CROWN_OF_MADNESS,
            SpellEnum.DARKNESS,
            SpellEnum.ENTHRALL,
            SpellEnum.HOLD_PERSON,
            SpellEnum.INVISIBILITY,
            SpellEnum.MIRROR_IMAGE,
            SpellEnum.MISTY_STEP,
            SpellEnum.RAY_OF_ENFEEBLEMENT,
            SpellEnum.SHATTER,
            SpellEnum.SPIDER_CLIMB,
            SpellEnum.SUGGESTION,

            // Nível 3
            SpellEnum.COUNTERSPELL,
            SpellEnum.DISPEL_MAGIC,
            SpellEnum.FEAR,
            SpellEnum.FLY,
            SpellEnum.GASEOUS_FORM,
            SpellEnum.HUNGER_OF_HADAR,
            SpellEnum.HYPNOTIC_PATTERN,
            SpellEnum.MAGIC_CIRCLE,
            SpellEnum.MAJOR_IMAGE,
            SpellEnum.REMOVE_CURSE,
            SpellEnum.TONGUES,
            SpellEnum.VAMPIRIC_TOUCH,

            // Nível 4
            SpellEnum.BANISHMENT,
            SpellEnum.BLIGHT,
            SpellEnum.DIMENSION_DOOR,
            SpellEnum.HALLUCINATORY_TERRAIN,

            // Nível 5
            SpellEnum.CONTACT_OTHER_PLANE,
            SpellEnum.DREAM,
            SpellEnum.HOLD_MONSTER,
            SpellEnum.SCRYING,

            // Nível 6
            SpellEnum.ARCANE_GATE,
            SpellEnum.CIRCLE_OF_DEATH,
            SpellEnum.CONJURE_FEY,
            SpellEnum.CREATE_UNDEAD,
            SpellEnum.EYEBITE,
            SpellEnum.FLESH_TO_STONE,
            SpellEnum.MASS_SUGGESTION,
            SpellEnum.TRUE_SEEING,

            // Nível 7
            SpellEnum.ETHEREALNESS,
            SpellEnum.FINGER_OF_DEATH,
            SpellEnum.FORCECAGE,
            SpellEnum.PLANE_SHIFT,

            // Nível 8
            SpellEnum.DEMIPLANE,
            SpellEnum.DOMINATE_MONSTER,
            SpellEnum.FEEBLEMIND,
            SpellEnum.GLIBNESS,
            SpellEnum.POWER_WORD_STUN,

            // Nível 9
            SpellEnum.ASTRAL_PROJECTION,
            SpellEnum.FORESIGHT,
            SpellEnum.IMPRISONMENT,
            SpellEnum.POWER_WORD_KILL,
            SpellEnum.TRUE_POLYMORPH
        );
    }

    @Override
    public List<Spell> getSpells(Integer npcLevel) {
        return List.of();
    }

    @Override
    public ClassEnum getClassName() {
        return ClassEnum.WARLOCK;
    }

    @Override
    public Integer getHP(Integer level, Integer constitutionModifier) {
        return getHP(level, constitutionModifier, 8);
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

        if (random.nextBoolean()) {
            items.add(GearEnum.SCHOLAR_PACK.toItem(1));
        } else {
            items.add(GearEnum.EXPLORER_PACK.toItem(1));
        }

        items.add(ArmorEnum.LEATHER.toArmor(1));
        items.add(getAnySimpleWeapon());
        items.add(WeaponEnum.DAGGER.toWeapon(2));

        return items;
    }
}
