package com.raphaowl.dnd.clients;

import java.util.List;
import java.util.Map;

import com.raphaowl.dnd.dtos.Monster;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class MonsterClient {

    private final DndClient dndClient;

    public List<Monster> list(Map<String, Object> arguments, List<String> fields) {
        return dndClient.list("monsters", arguments, fields, Monster.class);
    }

    public Monster get(Map<String, Object> arguments, List<String> fields) {
        return dndClient.get("monster", arguments, fields, Monster.class);
    }
}
