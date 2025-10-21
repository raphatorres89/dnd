package com.raphaowl.dnd.service.generators.items;

import java.util.ArrayList;
import java.util.List;

import com.raphaowl.dnd.dtos.Item;
import com.raphaowl.dnd.enums.ArmorEnum;
import com.raphaowl.dnd.enums.ClassEnum;
import com.raphaowl.dnd.enums.GearEnum;
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
public class WarlockItemGenerator extends AbstractItemGenerator {
    @Override
    public ClassEnum getClassName() {
        return ClassEnum.WARLOCK;
    }

    @Override
    public List<Item> getItems() {
        List<Item> items = new ArrayList<>();

//       (a) uma besta leve e 20 virotes ou (b) qualquer arma simples
        if (random.nextBoolean()) {
            items.add(WeaponEnum.LIGHT_CROSSBOW.toWeapon(1));
            items.add(GearEnum.CROSSBOW_BOLTS.toItem(20));
        } else {
            items.add(getAnySimpleWeapon());
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

//       Armadura de couro, qualquer arma simples e duas adagas
        items.add(ArmorEnum.LEATHER.toArmor(1));
        items.add(getAnySimpleWeapon());
        items.add(WeaponEnum.DAGGER.toWeapon(2));

        return items;
    }
}
