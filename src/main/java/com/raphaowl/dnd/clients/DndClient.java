package com.raphaowl.dnd.clients;

import java.util.List;
import java.util.Map;

import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class DndClient {

    private final HttpGraphQlClient graphQLClient;

    public <T> List<T> list(String rootField, Map<String, Object> arguments, List<String> fields, Class<T> clazz) {
        String query = GraphQLQueryBuilder.query(
                rootField,
                arguments,
                fields);
        return graphQLClient.document(query)
                .retrieve(rootField)
                .toEntityList(clazz)
                .block();
    }

    public <T> T get(String rootField, Map<String, Object> arguments, List<String> fields, Class<T> clazz) {
        String query = GraphQLQueryBuilder.query(
                rootField,
                arguments,
                fields);
        return graphQLClient.document(query)
                .retrieve(rootField)
                .toEntity(clazz)
                .block();
    }
}
