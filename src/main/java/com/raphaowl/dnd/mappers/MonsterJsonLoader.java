package com.raphaowl.dnd.mappers;

import java.util.List;

import com.raphaowl.dnd.clients.responses.MonsterRoot;
import com.raphaowl.dnd.dtos.Monster;

public class MonsterJsonLoader extends AbstractJsonLoader<MonsterRoot, Monster> {

    @Override
    protected List<Monster> extractItemList(MonsterRoot root) {
        if (root != null && root.getData() != null) {
            return root.getData().getMonsters();
        }
        return List.of();
    }

}
