package com.raphaowl.dnd.service.generators.classes;

import java.util.ArrayList;
import java.util.List;

import com.raphaowl.dnd.dtos.Item;
import com.raphaowl.dnd.enums.ArmorEnum;
import com.raphaowl.dnd.enums.ClassEnum;
import com.raphaowl.dnd.enums.GearEnum;
import com.raphaowl.dnd.enums.ToolEnum;
import com.raphaowl.dnd.enums.WeaponEnum;

import org.springframework.stereotype.Component;

/**
 * PONTOS DE VIDA
 * Dado de Vida: 1d8 por nível de ladino
 * Pontos de Vida no 1° Nível: 8 + seu modificador de
 * Constituição
 * Pontos de Vida nos Níveis Seguintes: 1d8 (ou 5) + seu
 * modificador de Constituição por nível de ladino após o
 * 1°
 * PROFICIÊNCIAS
 * Armaduras: Armaduras leves
 * Armas: Armas simples, bestas de mão, espadas longas,
 * rapieiras, espadas curtas
 * Ferramentas: Ferramentas de ladrão
 * Testes de Resistência: Destreza, Inteligência
 * Perícias: Escolha quatro dentre Acrobacia, Atletismo,
 * Atuação, Enganação, Furtividade, Intimidação,
 * Intuição, Investigação, Percepção, Persuasão e
 * Prestidigitação
 * EQUIPAMENTO
 * Você começa com o seguinte equipamento, além do
 * equipamento concedido pelo seu antecedente:
 *  (a) uma rapieira ou (b) uma espada longa
 *  (a) um arco curto e uma aljava com 20 flechas ou (b) uma espada curta
 *  (a) um pacote de assaltante ou (b) um pacote de aventureiro ou (c) um pacote de explorador
 *  Armadura de couro, duas adagas e ferramentas de ladrão
 */
@Component
public class RogueClassesGenerator extends AbstractClassesGenerator {

    @Override
    public ClassEnum getClassName() {
        return ClassEnum.ROGUE;
    }

    @Override
    public Integer getHP(Integer level, Integer constitutionModifier) {
        return getHP(level, constitutionModifier, 8);
    }

    @Override
    public List<Item> getItems() {
        ArrayList<Item> items = new ArrayList<>();

        if (random.nextBoolean()) {
            items.add(WeaponEnum.RAPIER.toWeapon(1));
        } else {
            items.add(WeaponEnum.LONGSWORD.toWeapon(1));
        }

        if (random.nextBoolean()) {
            items.add(WeaponEnum.SHORTBOW.toWeapon(1));
            items.add(GearEnum.ARROWS.toItem(20));
            items.add(GearEnum.QUIVER.toItem(1));
        } else {
            items.add(WeaponEnum.SHORTSWORD.toWeapon(1));
        }

        int packChoice = random.nextInt(3);
        if (packChoice == 0) {
            items.add(GearEnum.BURGLARS_PACK.toItem(1));
        } else if (packChoice == 1) {
            items.add(GearEnum.ADVENTURER_PACK.toItem(1));
        } else {
            items.add(GearEnum.EXPLORER_PACK.toItem(1));
        }

        items.add(ArmorEnum.LEATHER.toArmor(1));
        items.add(WeaponEnum.DAGGER.toWeapon(2));
        items.add(ToolEnum.THIEVES_TOOLS.toItem(1));

        return items;
    }
}
