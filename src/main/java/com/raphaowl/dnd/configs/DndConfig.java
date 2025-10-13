package com.raphaowl.dnd.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class DndConfig {

    private final DndApiProperties dndApiProperties;

    public DndConfig(DndApiProperties dndApiProperties) {
        this.dndApiProperties = dndApiProperties;
    }

    @Bean
    public HttpGraphQlClient httpGraphQlClient() {
        String apiUrl = String.format("%s/%s", dndApiProperties.url(), dndApiProperties.version());
        WebClient webClient = WebClient.builder()
                .baseUrl(apiUrl)
                .build();
        return HttpGraphQlClient.builder(webClient).build();
    }
}
