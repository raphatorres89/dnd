package com.raphaowl.dnd.configs;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "dnd5e")
public record DndApiProperties(
        String url,
        String version
) {
}
