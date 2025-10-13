package com.raphaowl.dnd.clients.requests;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GraphQLRequest {
    private String query;
    private Map<String, Object> variables;

}
