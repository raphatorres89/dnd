package com.raphaowl.dnd.mappers;

import java.util.ArrayList;
import java.util.List;

import com.raphaowl.dnd.clients.responses.SpellData;
import com.raphaowl.dnd.dtos.SpellView;
import com.raphaowl.dnd.enums.ComponentEnum;
import com.raphaowl.dnd.enums.MagicSchool;
import com.raphaowl.dnd.utils.RangeFormatter;

import org.springframework.context.i18n.LocaleContextHolder;

public class SpellAdapter {

    public static SpellView from(SpellData spellData) {
        if (spellData == null) {
            return null;
        }

        return new SpellView(
                spellData.slug(),
                spellData.name(),
                spellData.spellLevel(),
                MagicSchool.from(spellData.school()),
                null,
                null,
                convertComponents(spellData.components()),
        null,
                RangeFormatter.format(spellData.range(), LocaleContextHolder.getLocale()));
    }

    private static List<ComponentEnum> convertComponents(String components) {
        String[] componentsArray = components.split(",");
        List<ComponentEnum> componentList = new ArrayList<>();
        for (String component : componentsArray) {
            String trimmed = component.trim();
            switch (trimmed) {
                case "V" -> componentList.add(ComponentEnum.V);
                case "S" -> componentList.add(ComponentEnum.S);
                case "M" -> componentList.add(ComponentEnum.M);
            }
        }
        return componentList;
    }
}
