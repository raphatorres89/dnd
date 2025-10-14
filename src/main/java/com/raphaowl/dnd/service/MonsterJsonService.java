package com.raphaowl.dnd.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.raphaowl.dnd.dtos.Monster;
import com.raphaowl.dnd.mappers.MonsterJsonLoader;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

@Service
public class MonsterJsonService {

    private final MonsterJsonLoader jsonLoader = new MonsterJsonLoader();
    private List<Monster> allMonsters;

    public List<Monster> getAllMonsters() {
        String resourcePath = "/data/monsters.json";

        try {
            ClassPathResource resource = new ClassPathResource(resourcePath);

            try (InputStream inputStream = resource.getInputStream()) {
                return jsonLoader.loadItemsFromJson(inputStream);
            }
        } catch (IOException e) {
            System.err.println("Falha ao carregar o arquivo JSON do Classpath: " + resourcePath);
            return List.of();
        }
    }

    public Monster getMonster(String index) {
        String resourcePath = "/data/" + index + ".json";

        try {
            // Usa ClassPathResource para encontrar o recurso, seja no JAR ou no sistema de arquivos
            ClassPathResource resource = new ClassPathResource(resourcePath);

            // Obtém o recurso como um stream
            try (InputStream inputStream = resource.getInputStream()) {
                return jsonLoader.loadItemFromJson(inputStream);
            }
        } catch (IOException e) {
            System.err.println("Erro ao carregar recurso do classpath: " + resourcePath);
            e.printStackTrace();
            return null;
        }
    }
}
