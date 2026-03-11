package com.raphaowl.dnd.repository;

import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import jakarta.annotation.PostConstruct;

import com.raphaowl.dnd.clients.responses.SpellData;

import org.springframework.stereotype.Service;

import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

@Service
public class SpellRepository {

    private Map<String, SpellData> spells;

    @PostConstruct
    public void init() {
        ObjectMapper mapper = new ObjectMapper();

        InputStream is = getClass()
                .getClassLoader()
                .getResourceAsStream("data/spells.json");

        List<SpellData> list = mapper.readValue(
                is,
                new TypeReference<List<SpellData>>() {}
        );

        spells = list.stream()
                .collect(Collectors.toMap(
                        SpellData::slug,
                        Function.identity()
                ));
    }

    public SpellData findBySlug(String slug) {
        return spells.get(slug);
    }

    public List<SpellData> findAll() {
        return spells.values().stream().toList();
    }
}
