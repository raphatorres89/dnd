package com.raphaowl.dnd.service.generators.race;

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
public class BardRaceGenerator extends AbstractRaceGenerator {

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

//    (a) um lute ou (b) qualquer outro instrumento musical
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
