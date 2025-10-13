package com.raphaowl.dnd.services;

import java.util.List;
import java.util.Map;

import com.raphaowl.dnd.clients.MonsterClient;
import com.raphaowl.dnd.dtos.Monster;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MonsterService {

    private final MonsterClient monsterClient;

    public List<Monster> getMonsters() {
        return monsterClient.list(
                Map.of("limit", 100),
                List.of("index",
                        "name",
                        "size",
                        "challenge_rating",
                        "image"));
    }

    public Monster getMonster(String index) {
        return monsterClient.get(
                Map.of("index", index),
                List.of("charisma",
                        "dexterity",
                        "constitution",
                        "name",
                        "strength",
                        "wisdom",
                        "xp",
                        "updated_at",
                        "type",
                        "subtype",
                        "size",
                        "languages",
                        "intelligence",
                        "index",
                        "image",
                        "hit_points_roll",
                        "hit_points",
                        "hit_dice",
                        "damage_vulnerabilities",
                        "damage_resistances",
                        "damage_immunities",
                        "condition_immunities{name}",
                        "challenge_rating",
                        "alignment"
                ));
    }
}
