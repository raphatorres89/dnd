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
 * Dado de Vida: 1d8 por nível de bardo
 * Pontos de Vida no 1° Nível: 8 + seu modificador de
 * Constituição
 * Pontos de Vida nos Níveis Seguintes: 1d8 (ou 5) + seu
 * modificador de Constituição por nível de bardo após o
 * 1°
 * PROFICIÊNCIAS
 * Armaduras: Armaduras leves
 * Armas: Armas simples, bestas de mão, espadas longas,
 * rapieiras, espadas curtas
 * Ferramentas: Três instrumentos musicais, à sua escolha
 * Testes de Resistência: Destreza, Carisma
 * Perícias: Escolha três quaisquer
 * EQUIPAMENTO
 * Você começa com o seguinte equipamento, além do
 * equipamento concedido pelo seu antecedente:
 *  (a) uma rapieira, (b) uma espada longa ou (c) qualquer
 * arma simples
 *  (a) um pacote de diplomata ou (b) um pacote de artista
 *  (a) um lute ou (b) qualquer outro instrumento musical
 *  Armadura de couro e uma adaga
 */
@Component
public class BardClassesGenerator extends AbstractClassesGenerator {

    @Override
    protected List<SpellEnum> getSpellEnumList() {
        return Arrays.asList(
                // Truques (Cantrips)
                SpellEnum.BLADE_WARD,
                SpellEnum.DANCING_LIGHTS,
                SpellEnum.FRIENDS,
                SpellEnum.LIGHT,
                SpellEnum.MAGE_HAND,
                SpellEnum.MENDING,
                SpellEnum.MESSAGE,
                SpellEnum.MINOR_ILLUSION,
                SpellEnum.PRESTIDIGITATION,
                SpellEnum.TRUE_STRIKE,
                SpellEnum.VICIOUS_MOCKERY,

                // Nível 1
                SpellEnum.ANIMAL_FRIENDSHIP,
                SpellEnum.BANE,
                SpellEnum.CHARM_PERSON,
                SpellEnum.COMPREHEND_LANGUAGES,
                SpellEnum.CURE_WOUNDS,
                SpellEnum.DETECT_MAGIC,
                SpellEnum.DISGUISE_SELF,
                SpellEnum.DISSONANT_WHISPERS,
                SpellEnum.FAERIE_FIRE,
                SpellEnum.FEATHER_FALL,
                SpellEnum.HEALING_WORD,
                SpellEnum.HEROISM,
                SpellEnum.IDENTIFY,
                SpellEnum.ILLUSORY_SCRIPT,
                SpellEnum.LONGSTRIDER,
                SpellEnum.SILENT_IMAGE,
                SpellEnum.SLEEP,
                SpellEnum.TASHA_HIDEOUS_LAUGHTER,
                SpellEnum.THUNDERWAVE,
                SpellEnum.UNSEEN_SERVANT,

                // Nível 2
                SpellEnum.ANIMAL_MESSENGER,
                SpellEnum.BLINDNESS_DEAFNESS,
                SpellEnum.CALM_EMOTIONS,
                SpellEnum.CLOUD_OF_DAGGERS,
                SpellEnum.CROWN_OF_MADNESS,
                SpellEnum.DETECT_THOUGHTS,
                SpellEnum.ENHANCE_ABILITY,
                SpellEnum.ENTHRALL,
                SpellEnum.HEAT_METAL,
                SpellEnum.HOLD_PERSON,
                SpellEnum.INVISIBILITY,
                SpellEnum.KNOCK,
                SpellEnum.LESSER_RESTORATION,
                SpellEnum.LOCATE_ANIMALS_OR_PLANTS,
                SpellEnum.LOCATE_OBJECT,
                SpellEnum.MAGIC_MOUTH,
                SpellEnum.PHANTASMAL_FORCE,
                SpellEnum.SEE_INVISIBILITY,
                SpellEnum.SHATTER,
                SpellEnum.SILENCE,
                SpellEnum.SUGGESTION,
                SpellEnum.ZONE_OF_TRUTH,

                // Nível 3
                SpellEnum.BESTOW_CURSE,
                SpellEnum.CLAIRVOYANCE,
                SpellEnum.DISPEL_MAGIC,
                SpellEnum.FEAR,
                SpellEnum.FEIGN_DEATH,
                SpellEnum.GLYPH_OF_WARDING,
                SpellEnum.HYPNOTIC_PATTERN,
                SpellEnum.LEMUNDS_TINY_HUT,
                SpellEnum.MAJOR_IMAGE,
                SpellEnum.NONDETECTION,
                SpellEnum.PLANT_GROWTH,
                SpellEnum.SENDING,
                SpellEnum.SPEAK_WITH_DEAD,
                SpellEnum.SPEAK_WITH_PLANTS,
                SpellEnum.STINKING_CLOUD,
                SpellEnum.TONGUES,

                // Nível 4
                SpellEnum.COMPULSION,
                SpellEnum.CONFUSION,
                SpellEnum.DIMENSION_DOOR,
                SpellEnum.FREEDOM_OF_MOVEMENT,
                SpellEnum.GREATER_INVISIBILITY,
                SpellEnum.HALLUCINATORY_TERRAIN,
                SpellEnum.LOCATE_CREATURE,
                SpellEnum.POLYMORPH,

                // Nível 5
                SpellEnum.ANIMATE_OBJECTS,
                SpellEnum.AWAKEN,
                SpellEnum.DOMINATE_PERSON,
                SpellEnum.DREAM,
                SpellEnum.GEAS,
                SpellEnum.GREATER_RESTORATION,
                SpellEnum.HOLD_MONSTER,
                SpellEnum.LEGEND_LORE,
                SpellEnum.MASS_CURE_WOUNDS,
                SpellEnum.MISLEAD,
                SpellEnum.MODIFY_MEMORY,
                SpellEnum.PLANAR_BINDING,
                SpellEnum.RAISE_DEAD,
                SpellEnum.SCRYING,
                SpellEnum.SEEMING,
                SpellEnum.TELEPORTATION_CIRCLE,

                // Nível 6
                SpellEnum.EYEBITE,
                SpellEnum.FIND_THE_PATH,
                SpellEnum.GUARDS_AND_WARDS,
                SpellEnum.MASS_SUGGESTION,
                SpellEnum.OTTOS_IRRESISTIBLE_DANCE,
                SpellEnum.PROGRAMMED_ILLUSION,
                SpellEnum.TRUE_SEEING,

                // Nível 7
                SpellEnum.ETHEREALNESS,
                SpellEnum.FORCECAGE,
                SpellEnum.MIRAGE_ARCANE,
                SpellEnum.MORDENKAINENS_MAGNIFICENT_MANSION,
                SpellEnum.MORDENKAINENS_SWORD,
                SpellEnum.PROJECT_IMAGE,
                SpellEnum.REGENERATE,
                SpellEnum.RESURRECTION,
                SpellEnum.SYMBOL,
                SpellEnum.TELEPORT,

                // Nível 8
                SpellEnum.DOMINATE_MONSTER,
                SpellEnum.FEEBLEMIND,
                SpellEnum.GLIBNESS,
                SpellEnum.MIND_BLANK,
                SpellEnum.POWER_WORD_STUN,

                // Nível 9
                SpellEnum.FORESIGHT,
                SpellEnum.POWER_WORD_HEAL,
                SpellEnum.POWER_WORD_KILL,
                SpellEnum.TRUE_POLYMORPH
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
        return ClassEnum.BARD;
    }

    @Override
    public Integer getHP(Integer level, Integer constitutionModifier) {
        return getHP(level, constitutionModifier, 8);
    }

    @Override
    public List<Item> getItems() {
        return List.of(
                getMainWeapon(),
                getPack().toItem(1),
                getInstrument(),
                ArmorEnum.LEATHER.toArmor(1),
                WeaponEnum.DAGGER.toWeapon(1)
        );
    }

    private Item getInstrument() {
        if (random.nextBoolean()) {
            return ToolEnum.LUTE.toItem(1);
        }
        return getAnyInstrument();
    }

    private GearEnum getPack() {
        if (random.nextBoolean()) {
            return GearEnum.DIPLOMAT_PACK;
        }
        return GearEnum.ENTERTAINER_PACK;
    }

    private Item getMainWeapon() {
        int choice = random.nextInt(3);
        Item weapon;
        if (choice == 0) {
            weapon = WeaponEnum.RAPIER.toWeapon(1);
        } else if (choice == 1) {
            weapon = WeaponEnum.LONGSWORD.toWeapon(1);
        } else {
            weapon = getAnySimpleWeapon();
        }
        return weapon;
    }
}
