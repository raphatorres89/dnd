package com.raphaowl.dnd.service.generators.classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import com.raphaowl.dnd.dtos.Item;
import com.raphaowl.dnd.dtos.NpcStats;
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
    protected void generateSpells(Set<SpellEnum> spells, Integer npcLevel, NpcStats npcStats) {

        // --- 1. GERAÇÃO DE TRUQUES (Cantrips) ---
        int cantrips = switch (npcLevel) {
            case 1, 2, 3 -> 2;
            case 4, 5, 6, 7, 8, 9 -> 3;
            default -> 4; // Nível 10+
        };
        for (int i = 0; i < cantrips; i++) {
            spells.add(addUniqueSpell(spells, 0)); // Círculo 0 = Truques
        }

        // --- 2. CÁLCULO DE MAGIAS CONHECIDAS (knownSpells) ---
        // Progressão oficial de Bruxo (Fixa)
        int knownSpells = switch (npcLevel) {
            case 1 -> 2; case 2 -> 3; case 3 -> 4; case 4 -> 5; case 5 -> 6;
            case 6 -> 7; case 7 -> 8; case 8 -> 9; case 9 -> 10; case 10 -> 10;
            case 11 -> 11; case 12 -> 11; case 13 -> 12; case 14 -> 12; case 15 -> 13;
            case 16 -> 13; case 17 -> 14; case 18 -> 14; case 19 -> 15; case 20 -> 15;
            default -> 2;
        };

        // --- 3. NÍVEL DO SLOT DE PACTO (maxSpellLevel para slots) ---
        // Nível mais alto que o Warlock pode conjurar usando Slots de Pacto (máximo de 5)
        int pactSlotLevel =
                npcLevel <= 2 ? 1 :
                        npcLevel <= 4 ? 2 :
                                npcLevel <= 6 ? 3 :
                                        npcLevel <= 8 ? 4 : 5;

        // --- 4. DISTRIBUIÇÃO DE MAGIAS DE PACTO (1º ao 5º Círculo) ---
        // Selecionamos as 'knownSpells' dentre os círculos disponíveis (1 a pactSlotLevel)
        for (int i = 0; i < knownSpells; i++) {

            int selectedLevel;
            if (pactSlotLevel == 1) {
                selectedLevel = 1;
            } else {
                // Distribuição ponderada: 75% das magias de nível <= pactSlotLevel - 1
                int potentialLevel = (int) (Math.random() * pactSlotLevel) + 1;

                if (i < knownSpells * 0.75) {
                    selectedLevel = Math.min(potentialLevel, Math.max(1, pactSlotLevel - 1));
                } else {
                    selectedLevel = potentialLevel;
                }
                selectedLevel = Math.min(selectedLevel, pactSlotLevel);
            }

            spells.add(addUniqueSpell(spells, selectedLevel));
        }

        // --- 5. ARCANUM MÍSTICO (Magias de 6º ao 9º Círculo) ---
        // O Warlock conhece uma magia de cada Arcanum que ele possui.
        if (npcLevel >= 11) spells.add(addUniqueSpell(spells, 6)); // 6º Arcanum
        if (npcLevel >= 13) spells.add(addUniqueSpell(spells, 7)); // 7º Arcanum
        if (npcLevel >= 15) spells.add(addUniqueSpell(spells, 8)); // 8º Arcanum
        if (npcLevel >= 17) spells.add(addUniqueSpell(spells, 9)); // 9º Arcanum
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
