package com.raphaowl.dnd.service.generators;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

import com.raphaowl.dnd.enums.AlignmentEnum;
import com.raphaowl.dnd.enums.ClassEnum;
import com.raphaowl.dnd.enums.RaceEnum;

import org.springframework.stereotype.Service;

@Service
public class AlignmentWeightService {

    private static final Map<RaceEnum, Map<AlignmentEnum, Integer>> RACE_ALIGNMENT_WEIGHTS;

    private static final Map<ClassEnum, Map<AlignmentEnum, Integer>> CLASS_ALIGNMENT_WEIGHTS;

    static {
        // --- 1. Pesos por Raça ---
        Map<RaceEnum, Map<AlignmentEnum, Integer>> raceWeights = new EnumMap<>(RaceEnum.class);

        // Humanos: Tendência Neutra/Qualquer (Pesos uniformes)
        raceWeights.put(RaceEnum.HUMAN, Map.of(
                AlignmentEnum.LAWFUL_GOOD, 10, AlignmentEnum.LAWFUL_NEUTRAL, 10, AlignmentEnum.LAWFUL_EVIL, 10,
                AlignmentEnum.NEUTRAL_GOOD, 12, AlignmentEnum.NEUTRAL, 15, AlignmentEnum.NEUTRAL_EVIL, 12,
                AlignmentEnum.CHAOTIC_GOOD, 10, AlignmentEnum.CHAOTIC_NEUTRAL, 10, AlignmentEnum.CHAOTIC_EVIL, 10
        ));

        // Elfos: Tendência Caótico Bom
        raceWeights.put(RaceEnum.ELF, Map.of(
                AlignmentEnum.LAWFUL_GOOD, 5, AlignmentEnum.LAWFUL_NEUTRAL, 5, AlignmentEnum.LAWFUL_EVIL, 1,
                AlignmentEnum.NEUTRAL_GOOD, 15, AlignmentEnum.NEUTRAL, 10, AlignmentEnum.NEUTRAL_EVIL, 5,
                AlignmentEnum.CHAOTIC_GOOD, 25, AlignmentEnum.CHAOTIC_NEUTRAL, 15, AlignmentEnum.CHAOTIC_EVIL, 5
        ));

        // Anões: Tendência Leal Bom/Neutro
        raceWeights.put(RaceEnum.DWARF, Map.of(
                AlignmentEnum.LAWFUL_GOOD, 20, AlignmentEnum.LAWFUL_NEUTRAL, 15, AlignmentEnum.LAWFUL_EVIL, 5,
                AlignmentEnum.NEUTRAL_GOOD, 10, AlignmentEnum.NEUTRAL, 10, AlignmentEnum.NEUTRAL_EVIL, 5,
                AlignmentEnum.CHAOTIC_GOOD, 5, AlignmentEnum.CHAOTIC_NEUTRAL, 5, AlignmentEnum.CHAOTIC_EVIL, 1
        ));

        // ... adicione outras raças ...
        RACE_ALIGNMENT_WEIGHTS = Collections.unmodifiableMap(raceWeights);


        // --- 2. Pesos por Classe ---
        Map<ClassEnum, Map<AlignmentEnum, Integer>> classWeights = new EnumMap<>(ClassEnum.class);

        // Paladino: Forte tendência Leal Bom
        classWeights.put(ClassEnum.PALADIN, Map.of(
                AlignmentEnum.LAWFUL_GOOD, 50, AlignmentEnum.LAWFUL_NEUTRAL, 5, AlignmentEnum.LAWFUL_EVIL, 10,
                AlignmentEnum.NEUTRAL_GOOD, 5, AlignmentEnum.NEUTRAL, 1, AlignmentEnum.NEUTRAL_EVIL, 1,
                AlignmentEnum.CHAOTIC_GOOD, 1, AlignmentEnum.CHAOTIC_NEUTRAL, 1, AlignmentEnum.CHAOTIC_EVIL, 1
        ));

        // Bárbaro: Forte tendência Caótica
        classWeights.put(ClassEnum.BARBARIAN, Map.of(
                AlignmentEnum.LAWFUL_GOOD, 1, AlignmentEnum.LAWFUL_NEUTRAL, 1, AlignmentEnum.LAWFUL_EVIL, 5,
                AlignmentEnum.NEUTRAL_GOOD, 5, AlignmentEnum.NEUTRAL, 5, AlignmentEnum.NEUTRAL_EVIL, 10,
                AlignmentEnum.CHAOTIC_GOOD, 20, AlignmentEnum.CHAOTIC_NEUTRAL, 25, AlignmentEnum.CHAOTIC_EVIL, 15
        ));

        // ... adicione outras classes ...
        CLASS_ALIGNMENT_WEIGHTS = Collections.unmodifiableMap(classWeights);
    }

    /**
     * Retorna os pesos combinados de Raça e Classe para todos os alinhamentos.
     * O peso total é a soma dos pesos da Raça e da Classe para cada Alinhamento.
     */
    public Map<AlignmentEnum, Integer> getCombinedWeights(RaceEnum race, ClassEnum clazz) {
        Map<AlignmentEnum, Integer> combinedWeights = new EnumMap<>(AlignmentEnum.class);

        Map<AlignmentEnum, Integer> raceWeights = RACE_ALIGNMENT_WEIGHTS.getOrDefault(race, Collections.emptyMap());
        Map<AlignmentEnum, Integer> classWeights = CLASS_ALIGNMENT_WEIGHTS.getOrDefault(clazz, Collections.emptyMap());

        // Combina os pesos: Raça + Classe
        for (AlignmentEnum alignment : AlignmentEnum.getStandard()) {
            int weight = raceWeights.getOrDefault(alignment, 1) + // Mínimo de 1 para todos, se não definido
                    classWeights.getOrDefault(alignment, 1);
            combinedWeights.put(alignment, weight);
        }

        return combinedWeights;
    }

}
