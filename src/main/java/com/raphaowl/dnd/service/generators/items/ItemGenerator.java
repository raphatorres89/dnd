package com.raphaowl.dnd.service.generators.items;

import java.util.List;

import com.raphaowl.dnd.dtos.Item;
import com.raphaowl.dnd.enums.ClassEnum;

public interface ItemGenerator {
    ClassEnum getClassName();
    List<Item> getItems();
}
