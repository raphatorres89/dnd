package com.raphaowl.dnd.service.generators.items;

import java.util.ArrayList;
import java.util.List;

import com.raphaowl.dnd.dtos.Item;
import com.raphaowl.dnd.dtos.Weapon;
import com.raphaowl.dnd.enums.ClassEnum;
import com.raphaowl.dnd.enums.GearEnum;
import com.raphaowl.dnd.enums.WeaponEnum;
import com.raphaowl.dnd.enums.WeaponType;

import org.springframework.stereotype.Component;

/**
 * PONTOS DE VIDA
 * Dado de Vida: 1d12 por nível de bárbaro
 * Pontos de Vida no 1° Nível: 12 + seu modificador de
 * Constituição
 * Pontos de Vida nos Níveis Seguintes: 1d12 (ou 7) +
 * seu modificador de Constituição por nível de bárbaro
 * após o 1°
 * PROFICIÊNCIAS
 * Armaduras: Armaduras leves, armaduras médias e
 * escudos
 * Armas: Armas simples, armas marciais
 * Ferramentas: Nenhuma
 * Testes de Resistência: Força, Constituição
 * Perícias: Escolha duas dentre Adestrar Animais,
 * Atletismo, Intimidação, Natureza, Percepção e
 * Sobrevivência
 *
 * EQUIPAMENTO
 * Você começa com o seguinte equipamento, além do
 * equipamento concedido pelo seu antecedente:
 *  (a) um machado grande ou (b) qualquer arma marcial
 * corpo-a-corpo
 *  (a) dois machados de mão ou (b) qualquer arma
 * simples
 *  Um pacote de aventureiro e quatro azagaias
 */
@Component
public class BarbarianItemGenerator extends AbstractItemGenerator {
    @Override
    public ClassEnum getClassName() {
        return ClassEnum.BARBARIAN;
    }

    @Override
    public List<Item> getItems() {
        return List.of(
                getMainWeapon(),
                getSubWeapon(),
                GearEnum.ADVENTURER_PACK.toItem(1),
                WeaponEnum.JAVELIN.toWeapon(4)
        );
    }

    private Weapon getMainWeapon() {
        List<WeaponEnum> main = new ArrayList<>(WeaponEnum.getByType(WeaponType.MARTIAL_MELEE));
        main.add(WeaponEnum.BATTLEAXE);
        WeaponEnum weaponEnum = main.get(random.nextInt(main.size()));
        return weaponEnum.toWeapon(1);
    }

    private Weapon getSubWeapon() {
        List<WeaponEnum> main = new ArrayList<>(WeaponEnum.getByType(WeaponType.SIMPLE_MELEE));
        main.add(WeaponEnum.HANDAXE);
        WeaponEnum weaponEnum = main.get(random.nextInt(main.size()));
        if (weaponEnum.equals(WeaponEnum.HANDAXE)) {
            return weaponEnum.toWeapon(2);
        }
        return weaponEnum.toWeapon(1);
    }
}
