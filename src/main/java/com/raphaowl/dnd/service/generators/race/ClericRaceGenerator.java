package com.raphaowl.dnd.service.generators.race;

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
 *  (a) uma maça ou (b) um martelo de guerra (se for proficiente)
 *  (a) brunea, (b) armadura de couro ou (c) cota de malha (se for proficiente)
 *  (a) um besta leve e 20 virotes ou (b) qualquer arma simples
 *  (a) um pacote de sacerdote ou (b) um pacote de aventureiro
 *  Um escudo e um símbolo sagrado
 */
@Component
public class ClericRaceGenerator extends AbstractRaceGenerator {

    @Override
    public ClassEnum getClassName() {
        return ClassEnum.CLERIC;
    }

    @Override
    public Integer getHP(Integer level, Integer constitutionModifier) {
        return getHP(level, constitutionModifier, 8);
    }

    @Override
    public List<Item> getItems() {
        List<Item> items = new ArrayList<>();
        items.add(getMainWeapon());
        items.add(getArmor());

        if (random.nextBoolean()) {
            items.add(WeaponEnum.HAND_CROSSBOW.toWeapon(1));
            items.add(GearEnum.CROSSBOW_BOLTS.toItem(20));
        } else {
            items.add(getAnySimpleWeapon());
        }

        items.add(getPack());
        items.add(ArmorEnum.SHIELD.toArmor(1));
        items.add(getHolySymbol());

        return items;
    }

    private Item getPack() {
        if (random.nextBoolean()) {
            GearEnum.PRIEST_PACK.toItem(1);
        }
        return GearEnum.ADVENTURER_PACK.toItem(1);
    }

    private Item getArmor() {
        int choice = random.nextInt(3);
        Item armor;
        if (choice == 0) {
            armor = ArmorEnum.BREASTPLATE.toArmor(1);
        } else if (choice == 1) {
            armor = ArmorEnum.LEATHER.toArmor(1);
        } else {
            armor = ArmorEnum.CHAIN_MAIL.toArmor(1);
        }
        return armor;
    }

    private Item getMainWeapon() {
        if (random.nextBoolean()) {
            WeaponEnum.MACE.toWeapon(1);
        }
        return WeaponEnum.WARHAMMER.toWeapon(1);
    }
}
