package com.raphaowl.dnd.service.generators.classes;

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
 *  (a) um escudo de madeira ou (b) qualquer arma simples
 * (a) uma cimitarra ou (b) qualquer arma corpo-a-corpo simples
 * (a) um pacote de estudioso ou (b) um pacote de explorador
 *  Armadura de couro, um pacote de aventureiro e um foco druídico
 */
@Component
public class DruidClassesGenerator extends AbstractClassesGenerator {

    @Override
    public ClassEnum getClassName() {
        return ClassEnum.DRUID;
    }

    @Override
    public Integer getHP(Integer level, Integer constitutionModifier) {
        return getHP(level, constitutionModifier, 8);
    }

    @Override
    public List<Item> getItems() {
        return List.of(
                getMainWeapon(),
                getSecondaryWeapon(),
                getPack().toItem(1),
                ArmorEnum.LEATHER.toArmor(1),
                GearEnum.ADVENTURER_PACK.toItem(1),
                getDruidicFocus(),
                ToolEnum.HERBALISM_KIT.toItem(1)
        );
    }

    private Item getDruidicFocus() {
        List<GearEnum> focuses = List.of(
                GearEnum.DRUIDIC_FOCUS_SPRIG,
                GearEnum.DRUIDIC_FOCUS_TOTEM,
                GearEnum.DRUIDIC_FOCUS_WOODEN_STAFF,
                GearEnum.DRUIDIC_FOCUS_YEW_WAND);
        return focuses.get(random.nextInt(focuses.size())).toItem(1);
    }

//    (a) um pacote de estudioso ou (b) um pacote de explorador
    private GearEnum getPack() {
        List<GearEnum> packs = List.of(GearEnum.SCHOLAR_PACK, GearEnum.ADVENTURER_PACK);
        return packs.get(random.nextInt(packs.size()));
    }

    private Item getMainWeapon() {
        if (random.nextBoolean()) {
            ArmorEnum.SHIELD.toArmor(1);
        }
        return getAnySimpleWeapon();
    }

//    (a) uma cimitarra ou (b) qualquer arma corpo-a-corpo simples
    private Item getSecondaryWeapon() {
        if (random.nextBoolean()) {
            WeaponEnum.SCIMITAR.toWeapon(1);
        }
        return getAnySimpleMeleeWeapon();
    }
}
