package com.raphaowl.dnd.service.generators.items;

import java.util.List;

import com.raphaowl.dnd.dtos.Item;
import com.raphaowl.dnd.enums.ClassEnum;
import com.raphaowl.dnd.enums.GearEnum;
import com.raphaowl.dnd.enums.WeaponEnum;

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
 *  (a) um machado grande ou (b) qualquer arma marcial corpo-a-corpo
 *  (a) dois machados de mão ou (b) qualquer arma simples
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
//                 Um pacote de aventureiro e quatro azagaias
                GearEnum.ADVENTURER_PACK.toItem(1),
                WeaponEnum.JAVELIN.toWeapon(4)
        );
    }

//     (a) um machado grande ou (b) qualquer arma marcial corpo-a-corpo
    private Item getMainWeapon() {
        if (random.nextBoolean()) {
            return getAnySimpleMeleeWeapon();
        }
        return WeaponEnum.GREATAXE.toWeapon(1);
    }

//     (a) dois machados de mão ou (b) qualquer arma simples
    private Item getSubWeapon() {
        if (random.nextBoolean()) {
            return WeaponEnum.HANDAXE.toWeapon(2);
        }
        return getAnySimpleWeapon();
    }
}
