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
public class WizardItemGenerator extends AbstractItemGenerator {
    @Override
    public ClassEnum getClassName() {
        return ClassEnum.WIZARD;
    }

    @Override
    public List<Item> getItems() {
        List<Item> items = new ArrayList<>();

//       (a) um bordão ou (b) uma adaga
        if (random.nextBoolean()) {
            items.add(WeaponEnum.QUARTERSTAFF.toWeapon(1));
        } else {
            items.add(WeaponEnum.DAGGER.toWeapon(1));
        }

//       (a) uma bolsa de componentes ou (b) um foco arcano
        if (random.nextBoolean()) {
            items.add(GearEnum.COMPONENT_POUCH.toItem(1));
        } else {
            items.add(getAnyArcaneFocus());
        }

//       (a) um pacote de estudioso ou (b) um pacote de explorador
        if (random.nextBoolean()) {
            items.add(GearEnum.SCHOLAR_PACK.toItem(1));
        } else {
            items.add(GearEnum.EXPLORER_PACK.toItem(1));
        }

//       Um grimório
        items.add(GearEnum.GRIMOIRE.toItem(1));

        return items;
    }
}
