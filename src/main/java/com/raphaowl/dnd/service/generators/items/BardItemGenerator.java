package com.raphaowl.dnd.service.generators.items;

import java.util.ArrayList;
import java.util.List;

import com.raphaowl.dnd.dtos.Item;
import com.raphaowl.dnd.dtos.Weapon;
import com.raphaowl.dnd.enums.ArmorEnum;
import com.raphaowl.dnd.enums.ClassEnum;
import com.raphaowl.dnd.enums.GearEnum;
import com.raphaowl.dnd.enums.ToolEnum;
import com.raphaowl.dnd.enums.ToolTypeEnum;
import com.raphaowl.dnd.enums.WeaponEnum;
import com.raphaowl.dnd.enums.WeaponType;

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
public class BardItemGenerator extends AbstractItemGenerator{
    @Override
    public ClassEnum getClassName() {
        return ClassEnum.BARD;
    }

    @Override
    public List<Item> getItems() {
        Weapon mainWeapon = getMainWeapon();
        GearEnum pack = getPack();
        ToolEnum instrument = getInstrument();
        return List.of(
                mainWeapon,
                pack.toItem(1),
                instrument.toItem(1),
                ArmorEnum.LEATHER.toArmor(1),
                WeaponEnum.DAGGER.toWeapon(1)
        );
    }

    private ToolEnum getInstrument() {
        List<ToolEnum> instruments = ToolEnum.getByType(ToolTypeEnum.MUSICAL);
        return instruments.get(random.nextInt(instruments.size()));
    }

    private GearEnum getPack() {
        List<GearEnum> items = List.of(GearEnum.DIPLOMAT_PACK, GearEnum.ENTERTAINER_PACK);
        return items.get(random.nextInt(items.size()));
    }

    private Weapon getMainWeapon() {
        List<WeaponEnum> main = new ArrayList<>(WeaponEnum.getByType(WeaponType.SIMPLE_MELEE));
        main.add(WeaponEnum.RAPIER);
        main.add(WeaponEnum.LONGSWORD);
        WeaponEnum weaponEnum = main.get(random.nextInt(main.size()));
        return weaponEnum.toWeapon(1);
    }
}
