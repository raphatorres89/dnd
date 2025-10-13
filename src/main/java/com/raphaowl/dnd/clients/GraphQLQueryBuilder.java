package com.raphaowl.dnd.clients;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GraphQLQueryBuilder {

    public static String query(String rootField, Map<String, Object> arguments, List<String> fields) {
        String argsPart = arguments.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + formatValue(entry.getValue()))
                .collect(Collectors.joining(", "));

        String fieldsPart = String.join("\n    ", fields);

        String args = argsPart.isEmpty() ? "" : "(" + argsPart + ")";

        return String.format("""
            query {
              %s%s {
                %s
              }
            }
            """, rootField, args, fieldsPart);
    }

    private static String formatValue(Object value) {
        if (value instanceof String) {
            return "\"" + value + "\"";
        }
        if (value instanceof Number || value instanceof Boolean) {
            return value.toString();
        }
        return "\"" + value.toString() + "\"";
    }
}
