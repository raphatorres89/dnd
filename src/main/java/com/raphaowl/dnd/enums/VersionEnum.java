package com.raphaowl.dnd.enums;

import lombok.Getter;

@Getter
public enum VersionEnum {
    V2014("2014"),
    V2024("2024");

    private final String year;

    VersionEnum(String year) {
        this.year = year;
    }
}
