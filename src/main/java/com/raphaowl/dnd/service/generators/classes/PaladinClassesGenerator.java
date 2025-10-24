package com.raphaowl.dnd.service.generators.classes;

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
 * Dado de Vida: 1d10 por nível de paladino
 * Pontos de Vida no 1° Nível: 10 + seu modificador de
 * Constituição
 * Pontos de Vida nos Níveis Seguintes: 1d10 (ou 6) +
 * seu modificador de Constituição por nível de paladino
 * após o 1°
 * PROFICIÊNCIAS
 * Armaduras: Todas as armaduras, escudos
 * Armas: Armas simples, armas marciais
 * Ferramentas: Nenhum
 * Testes de Resistência: Sabedoria, Carisma
 * Perícias: Escolha duas dentre Atletismo, Intuição,
 * Intimidação, Medicina, Persuasão e Religião
 * EQUIPAMENTO
 * Você começa com o seguinte equipamento, além do
 * equipamento concedido pelo seu antecedente:
 *  (a) uma arma marcial e um escudo ou (b) duas armas marciais
 *  (a) cinco azagaias ou (b) qualquer arma simples corpoa-corpo
 *  (a) um pacote de sacerdote ou (b) um pacote de aventureiro
 *  Cota de malha e um símbolo sagrado
 */
@Component
public class PaladinClassesGenerator extends AbstractClassesGenerator {

    @Override
    public ClassEnum getClassName() {
        return ClassEnum.PALADIN;
    }

    @Override
    public Integer getHP(Integer level, Integer constitutionModifier) {
        return getHP(level, constitutionModifier, 10);
    }

    @Override
    public List<Item> getItems() {
        ArrayList<Item> items = new ArrayList<>();

        if (random.nextBoolean()) {
            items.add(getAnyMartialWeapon());
            items.add(ArmorEnum.SHIELD.toArmor(1));
        } else {
            items.add(getAnyMartialWeapon());
            items.add(getAnyMartialWeapon());
        }

        if (random.nextBoolean()) {
            items.add(WeaponEnum.JAVELIN.toWeapon(5));
        } else {
            items.add(getAnySimpleMeleeWeapon());
        }

        if (random.nextBoolean()) {
            items.add(GearEnum.PRIEST_PACK.toItem(1));
        } else {
            items.add(GearEnum.ADVENTURER_PACK.toItem(1));
        }

        items.add(ArmorEnum.CHAIN_MAIL.toArmor(1));
        items.add(getHolySymbol());

        return items;
    }
}
