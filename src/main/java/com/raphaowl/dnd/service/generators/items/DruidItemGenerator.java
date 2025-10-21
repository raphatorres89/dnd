package com.raphaowl.dnd.service.generators.items;

import java.util.ArrayList;
import java.util.List;

import com.raphaowl.dnd.dtos.Item;
import com.raphaowl.dnd.enums.ArmorEnum;
import com.raphaowl.dnd.enums.ClassEnum;
import com.raphaowl.dnd.enums.GearEnum;
import com.raphaowl.dnd.enums.WeaponEnum;
import com.raphaowl.dnd.enums.WeaponType;

import org.springframework.stereotype.Component;

/**
 * PONTOS DE VIDA
 * Dado de Vida: 1d8 por nível de druida
 * Pontos de Vida no 1° Nível: 8 + seu modificador de
 * Constituição
 * Pontos de Vida nos Níveis Seguintes: 1d8 (ou 5) + seu
 * modificador de Constituição por nível de druida após o
 * 1°
 * PROFICIÊNCIAS
 * Armaduras: Armaduras leves, armaduras médias,
 * escudos (druidas não irão vestir armaduras ou usar
 * escudos feitos de metal)
 * Armas: Clavas, adagas, dardos, azagaias, maças,
 * bordões, cimitarras, foices, fundas e lanças.
 * Ferramentas: Kit de herbalismo
 * Testes de Resistência: Inteligência, Sabedoria
 * Perícias: Escolha duas dentre Arcanismo, Adestrar
 * Animais, Intuição, Medicina, Natureza, Percepção,
 * Religião e Sobrevivência
 * EQUIPAMENTO
 * Você começa com o seguinte equipamento, além do
 * equipamento concedido pelo seu antecedente:
 *  (a) um escudo de madeira ou (b) qualquer arma
 * simples
 * (a) uma cimitarra ou (b) qualquer arma corpo-a-corpo
 * simples
 * (a) um pacote de estudioso ou (b) um pacote de
 * explorador
 *  Armadura de couro, um pacote de aventureiro e um
 * foco druídico
 */
@Component
public class DruidItemGenerator extends AbstractItemGenerator {
    @Override
    public ClassEnum getClassName() {
        return ClassEnum.DRUID;
    }

    @Override
    public List<Item> getItems() {
        return List.of(
                getMainWeapon(),
                getSecondaryWeapon(),
                ArmorEnum.LEATHER.toArmor(1), // TODO implementar foco druídico
                getPack().toItem(1)
        );
    }

    private GearEnum getPack() {
        List<GearEnum> packs = List.of(GearEnum.SCHOLAR_PACK, GearEnum.ADVENTURER_PACK);
        return packs.get(random.nextInt(packs.size()));
    }

    private Item getMainWeapon() {
        List<Item> weapons = new ArrayList<>(
                WeaponEnum.getByType(WeaponType.SIMPLE_MELEE).stream()
                        .map(weap -> weap.toWeapon(1))
                        .toList());
        weapons.add(ArmorEnum.SHIELD.toArmor(1));
        return weapons.get(random.nextInt(weapons.size()));
    }

    private Item getSecondaryWeapon() {
        List<WeaponEnum> weapons = new ArrayList<>(WeaponEnum.getByType(WeaponType.SIMPLE_MELEE));
        weapons.add(WeaponEnum.SCIMITAR);
        return weapons.get(random.nextInt(weapons.size())).toWeapon(1);
    }
}
