package com.raphaowl.dnd.service.generators.race;

import java.util.List;

import com.raphaowl.dnd.dtos.Item;
import com.raphaowl.dnd.enums.ClassEnum;
import com.raphaowl.dnd.enums.WeaponEnum;

import org.springframework.stereotype.Component;

/**
 * PONTOS DE VIDA
 * Dado de Vida: 1d8 por nível de monge
 * Pontos de Vida no 1° Nível: 8 + seu modificador de
 * Constituição
 * Pontos de Vida nos Níveis Seguintes: 1d8 (ou 5) + seu
 * modificador de Constituição por nível de monge após o
 * 1°
 * PROFICIÊNCIAS
 * Armaduras: Nenhuma
 * Armas: Armas simples, espadas curtas
 * Ferramentas: Escolha um tipo de ferramenta de artesão
 * ou um instrumento musical
 * Testes de Resistência: Força, Destreza
 * Perícias: Escolha duas dentre Acrobacia, Atletismo,
 * Furtividade, História, Intuição e Religião
 * EQUIPAMENTO
 * Você começa com o seguinte equipamento, além do
 * equipamento concedido pelo seu antecedente:
 *  (a) uma espada curta ou (b) qualquer arma simples
 *  (a) um pacote de explorador ou (b) um pacote de
 * aventureiro
 *  10 dardos
 */
@Component
public class MonkRaceGenerator extends AbstractRaceGenerator {

    @Override
    public ClassEnum getClassName() {
        return ClassEnum.MONK;
    }

    @Override
    public Integer getHP(Integer level, Integer constitutionModifier) {
        return getHP(level, constitutionModifier, 10);
    }

    @Override
    public List<Item> getItems() {
        return List.of(
                getMainWeapon(),
                getExplorerOrAdventurerPack(),
                WeaponEnum.DART.toWeapon(10)
        );
    }

    private Item getMainWeapon() {
        if (random.nextBoolean()) {
            return WeaponEnum.SHORTSWORD.toWeapon(1);
        }
        return getAnySimpleWeapon();
    }
}
