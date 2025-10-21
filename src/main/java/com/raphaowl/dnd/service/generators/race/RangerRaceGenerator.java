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
 * Dado de Vida: 1d10 por nível de patrulheiro
 * Pontos de Vida no 1° Nível: 10 + seu modificador de
 * Constituição
 * Pontos de Vida nos Níveis Seguintes: 1d10 (ou 6) +
 * seu modificador de Constituição por nível de
 * patrulheiro após o 1°
 * PROFICIÊNCIAS
 * Armaduras: Armaduras leves, armaduras médias,
 * escudos
 * Armas: Armas simples, armas marciais
 * Ferramentas: Nenhuma
 * Testes de Resistência: Força, Destreza
 * Perícias: Escolha três dentre Adestrar Animais,
 * Atletismo, Furtividade, Intuição, Investigação,
 * Natureza, Percepção e Sobrevivência
 * EQUIPAMENTO
 * Você começa com o seguinte equipamento, além do
 * equipamento concedido pelo seu antecedente:
 *  (a) brunea ou (b) armadura de couro
 *  (a) duas espadas curtas ou (b) duas armas simples corpo-a-corpo
 *  (a) um pacote de explorador ou (b) um pacote de aventureiro
 *  Um arco longo e uma aljava com 20 flechas
 */
@Component
public class RangerRaceGenerator extends AbstractRaceGenerator {

    @Override
    public ClassEnum getClassName() {
        return ClassEnum.RANGER;
    }

    @Override
    public Integer getHP(Integer level, Integer constitutionModifier) {
        return getHP(level, constitutionModifier, 10);
    }

    @Override
    public List<Item> getItems() {
        List<Item> items = new ArrayList<>();

        if (random.nextBoolean()) {
            ArmorEnum.BREASTPLATE.toArmor(1);
        } else {
            ArmorEnum.LEATHER.toArmor(1);
        }

        if (random.nextBoolean()) {
            items.add(getAnySimpleMeleeWeapon());
            items.add(getAnySimpleMeleeWeapon());
        } else {
            items.add(WeaponEnum.SHORTSWORD.toWeapon(2));
        }

        items.add(getExplorerOrAdventurerPack());

        items.add(WeaponEnum.LONGBOW.toWeapon(1));
        items.add(GearEnum.ARROWS.toItem(20));

        return items;
    }
}
