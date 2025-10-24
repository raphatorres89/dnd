package com.raphaowl.dnd.service.generators.classes;

import java.util.List;

import com.raphaowl.dnd.dtos.Item;
import com.raphaowl.dnd.enums.ClassEnum;

public interface ClassesGenerator {
    ClassEnum getClassName();
    List<Item> getItems();
    Integer getHP(Integer level, Integer constitutionModifier);
}
