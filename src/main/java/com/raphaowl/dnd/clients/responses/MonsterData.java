package com.raphaowl.dnd.clients.responses;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.raphaowl.dnd.dtos.Monster;

import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class MonsterData {
    private List<Monster> monsters;
}
