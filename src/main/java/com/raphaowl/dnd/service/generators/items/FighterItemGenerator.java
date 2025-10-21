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
 * Dado de Vida: 1d10 por nível de guerreiro
 * Pontos de Vida no 1° Nível: 10 + seu modificador de
 * Constituição
 * Pontos de Vida nos Níveis Seguintes: 1d10 (ou 6) +
 * seu modificador de Constituição por nível de guerreiro
 * após o 1°
 * PROFICIÊNCIAS
 * Armaduras: Todas as armaduras, escudos
 * Armas: Armas simples, armas marciais
 * Ferramentas: nenhum
 * Testes de Resistência: Força, Constituição
 * Perícias: Escolha duas dentre Acrobacia, Adestrar
 * Animais, Atletismo, História, Intuição, Intimidação,
 * Percepção e Sobrevivência
 * EQUIPAMENTO
 * Você começa com o seguinte equipamento, além do
 * equipamento concedido pelo seu antecedente:
 *  (a) cota de malha ou (b) gibão de peles, arco longo e 20
 * flechas
 *  (a) uma arma marcial e um escudo ou (b) duas armas
 * marciais
 *  (a) uma besta leve e 20 virotes ou (b) dois machados de
 * arremesso
 *  (a) um pacote de aventureiro ou (b) um pacote de
 * explorador
 */
@Component
public class FighterItemGenerator extends  AbstractItemGenerator {
    @Override
    public ClassEnum getClassName() {
        return ClassEnum.FIGHTER;
    }

    @Override
    public List<Item> getItems() {
        ArrayList<Item> items = new ArrayList<Item>();

//       (a) cota de malha ou (b) gibão de peles, arco longo e 20
        if (random.nextBoolean()) {
            items.add(ArmorEnum.CHAIN_MAIL.toArmor(1));
        } else {
            items.add(ArmorEnum.STUDDED_LEATHER.toArmor(1));
            items.add(WeaponEnum.LONGBOW.toWeapon(1));
            items.add(GearEnum.ARROWS.toItem(20));
        }

//       (a) uma arma marcial e um escudo ou (b) duas armas marciais
        items.add(getRandomMartialWeapon());
        if (random.nextBoolean()) {
            items.add(ArmorEnum.SHIELD.toArmor(1));
        } else {
            items.add(getRandomMartialWeapon());
        }

//       (a) uma besta leve e 20 virotes ou (b) dois machados de arremesso
        if (random.nextBoolean()) {
            items.add(WeaponEnum.LIGHT_CROSSBOW.toWeapon(1));
            items.add(GearEnum.CROSSBOW_BOLTS.toItem(20));
        } else {
            items.add(WeaponEnum.HANDAXE.toWeapon(2));
        }

//       (a) um pacote de aventureiro ou (b) um pacote de explorador
        if (random.nextBoolean()) {
            items.add(GearEnum.ADVENTURER_PACK.toItem(1));
        } else {
            items.add(GearEnum.EXPLORER_PACK.toItem(1));
        }
        return items;
    }

    private Item getRandomMartialWeapon() {
        List<WeaponEnum> martial = new ArrayList<>(WeaponEnum.getByType(WeaponType.MARTIAL_MELEE));
        martial.addAll(WeaponEnum.getByType(WeaponType.MARTIAL_RANGED));
        return martial.get(random.nextInt(martial.size())).toWeapon(1);
    }

    private GearEnum getPack() {
        List<GearEnum> items = List.of(GearEnum.PRIEST_PACK, GearEnum.ADVENTURER_PACK);
        return items.get(random.nextInt(items.size()));
    }

    private Weapon getSecondaryWeapon() {
        List<WeaponEnum> secondary = new ArrayList<>(WeaponEnum.getByType(WeaponType.SIMPLE_MELEE));
        secondary.add(WeaponEnum.LIGHT_CROSSBOW);
        return secondary.get(random.nextInt(secondary.size())).toWeapon(1);
    }

    private Armor getArmor() {
        List<ArmorEnum> armors = List.of(ArmorEnum.BREASTPLATE, ArmorEnum.LEATHER, ArmorEnum.CHAIN_MAIL);
        return armors.get(random.nextInt(armors.size())).toArmor(1);
    }

    private Item getMainItem() {
        List<Item> main = List.of(ArmorEnum.CHAIN_MAIL.toArmor(1));
        return main.get(random.nextInt(main.size()));
    }
}
