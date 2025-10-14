package com.raphaowl.dnd.service;

import java.util.List;

import com.raphaowl.dnd.dtos.Monster;
import com.raphaowl.dnd.mappers.MonsterJsonLoader;

import org.springframework.stereotype.Service;

@Service
public class MonsterJsonService {

    private final MonsterJsonLoader jsonLoader = new MonsterJsonLoader();
    private List<Monster> allMonsters;

    public List<Monster> getAllMonsters() {
        if (allMonsters == null) {
            String jsonPath = "src/main/resources/data/monsters.json";
            allMonsters = jsonLoader.loadItemsFromJson(jsonPath);
        }
        return allMonsters;
    }

    public Monster getMonster(String index) {
        String jsonPath = String.format("src/main/resources/data/%s.json", index);
        return jsonLoader.loadItemFromJson(jsonPath);
    }
}
