package com.raphaowl.dnd.service.generators.items;

import java.util.ArrayList;
import java.util.List;

import com.raphaowl.dnd.dtos.Armor;
import com.raphaowl.dnd.dtos.Item;
import com.raphaowl.dnd.dtos.Weapon;
import com.raphaowl.dnd.enums.ArmorEnum;
import com.raphaowl.dnd.enums.ClassEnum;
import com.raphaowl.dnd.enums.GearEnum;
import com.raphaowl.dnd.enums.WeaponEnum;
import com.raphaowl.dnd.enums.WeaponType;

import org.springframework.stereotype.Component;

/**
 * PONTOS DE VIDA
 * Dado de Vida: 1d8 por nível de clérigo
 * Pontos de Vida no 1° Nível: 8 + seu modificador de
 * Constituição
 * Pontos de Vida nos Níveis Seguintes: 1d8 (ou 5) + seu
 * modificador de Constituição por nível de clérigo após o
 * 1°
 * PROFICIÊNCIAS
 * Armaduras: Armaduras leves, armaduras médias,
 * escudos
 * Armas: Todas as armas simples
 * Ferramentas: Nenhuma
 * Testes de Resistência: Sabedoria, Carisma
 * Perícias: Escolha duas dentre História, Intuição,
 * Medicina, Persuasão e Religião
 * EQUIPAMENTO
 * Você começa com o seguinte equipamento, além do
 * equipamento concedido pelo seu antecedente:
 *  (a) uma maça ou (b) um martelo de guerra (se for
 * proficiente)
 *  (a) brunea, (b) armadura de couro ou (c) cota de malha
 * (se for proficiente)
 *  (a) um besta leve e 20 virotes ou (b) qualquer arma
 * simples
 *  (a) um pacote de sacerdote ou (b) um pacote de
 * aventureiro
 *  Um escudo e um símbolo sagrado
 */
@Component
public class ClericItemGenerator extends AbstractItemGenerator {
    @Override
    public ClassEnum getClassName() {
        return ClassEnum.CLERIC;
    }

    @Override
    public List<Item> getItems() {
        List<Item> items = new ArrayList<>();
        items.add(getMainWeapon());
        items.add(getArmor());

//         (a) um besta leve e 20 virotes ou (b) qualquer arma simples
        if (random.nextBoolean()) {
            items.add(WeaponEnum.HAND_CROSSBOW.toWeapon(1));
            items.add(GearEnum.CROSSBOW_BOLTS.toItem(20));
        } else {
            items.add(getSecondaryWeapon());
        }

        items.add(getPack());
        items.add(ArmorEnum.SHIELD.toArmor(1));
        return items;
    }

    private Item getPack() {
        List<GearEnum> items = List.of(GearEnum.PRIEST_PACK, GearEnum.ADVENTURER_PACK);
        return items.get(random.nextInt(items.size())).toItem(1);
    }

    private Weapon getSecondaryWeapon() {
        List<WeaponEnum> secondary = new ArrayList<>(WeaponEnum.getByType(WeaponType.SIMPLE_MELEE));
        return secondary.get(random.nextInt(secondary.size())).toWeapon(1);
    }

    private Armor getArmor() {
        List<ArmorEnum> armors = List.of(ArmorEnum.BREASTPLATE, ArmorEnum.LEATHER, ArmorEnum.CHAIN_MAIL);
        return armors.get(random.nextInt(armors.size())).toArmor(1);
    }

    private Weapon getMainWeapon() {
        List<WeaponEnum> main = List.of(WeaponEnum.MACE, WeaponEnum.WARHAMMER);
        return main.get(random.nextInt(main.size())).toWeapon(1);
    }
}
