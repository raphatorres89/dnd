package com.raphaowl.dnd.service.generators.items;

import java.util.ArrayList;
import java.util.List;

import com.raphaowl.dnd.dtos.Item;
import com.raphaowl.dnd.enums.ClassEnum;
import com.raphaowl.dnd.enums.GearEnum;
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
public class SorcererItemGenerator extends AbstractItemGenerator {
    @Override
    public ClassEnum getClassName() {
        return ClassEnum.SORCERER;
    }

    @Override
    public List<Item> getItems() {
        List<Item> items = new ArrayList<>();

//         (a) uma besta leve e 20 virotes ou (b) qualquer arma simples
        if (random.nextBoolean()) {
            items.add(WeaponEnum.LIGHT_CROSSBOW.toWeapon(1));
            items.add(GearEnum.CROSSBOW_BOLTS.toItem(20));
        } else {
            items.add(getAnySimpleWeapon());
        }
//         (a) uma bolsa de componentes ou (b) um foco arcano
        if (random.nextBoolean()) {
            items.add(GearEnum.COMPONENT_POUCH.toItem(1));
        } else {
            items.add(getAnyArcaneFocus());
        }

//         (a) um pacote de explorador ou (b) um pacote de aventureiro
        items.add(getExplorerOrAdventurerPack());

        return items;
    }
}
