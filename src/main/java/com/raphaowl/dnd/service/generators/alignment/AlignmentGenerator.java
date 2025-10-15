package com.raphaowl.dnd.service.generators.alignment;

import java.util.Map;
import java.util.Random;

import com.raphaowl.dnd.enums.AlignmentEnum;
import com.raphaowl.dnd.enums.ClassEnum;
import com.raphaowl.dnd.enums.RaceEnum;

import org.springframework.stereotype.Service;

@Service
public class AlignmentGenerator {
    private final AlignmentWeightService weightService;
    private final Random random = new Random();

    public AlignmentGenerator(AlignmentWeightService weightService) {
        this.weightService = weightService;
    }

    public AlignmentEnum generateAlignment(RaceEnum race, ClassEnum clazz) {
        Map<AlignmentEnum, Integer> weights = weightService.getCombinedWeights(race, clazz);
        return selectRandomWeighted(weights);
    }

    /**
     * Seleciona um Alinhamento baseado em seu peso (probabilidade).
     */
    private AlignmentEnum selectRandomWeighted(Map<AlignmentEnum, Integer> weights) {
        // 1. Calcular o peso total de todos os alinhamentos
        int totalWeight = weights.values().stream().mapToInt(Integer::intValue).sum();

        // 2. Gerar um número aleatório entre 0 e (Peso Total - 1)
        int randomNumber = random.nextInt(totalWeight);

        // 3. Iterar e subtrair o peso de cada item até que o número aleatório seja alcançado
        for (Map.Entry<AlignmentEnum, Integer> entry : weights.entrySet()) {
            randomNumber -= entry.getValue();
            if (randomNumber < 0) {
                return entry.getKey();
            }
        }

        // Deve sempre retornar um valor antes de chegar aqui, mas como fallback:
        return AlignmentEnum.NEUTRAL;
    }
}
