package com.raphaowl.dnd.enums;

import java.util.stream.Stream;

import com.fasterxml.jackson.annotation.JsonCreator;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MonsterEnum {
    TINY(1),
    SMALL(2),
    MEDIUM(3),
    LARGE(4),
    HUGE(5),
    GARGANTUAN(6);

    private final int primaryIcons;

    @JsonCreator
    public static MonsterEnum fromString(String value) {
        if (value == null) {
            return null;
        }
        String normalized = value.trim().toLowerCase();

        return Stream.of(MonsterEnum.values())
                .filter(g -> g.name().toLowerCase().equals(normalized))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Nome não reconhecido: " + value));
    }
}
