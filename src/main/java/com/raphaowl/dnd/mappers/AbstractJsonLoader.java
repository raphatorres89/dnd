package com.raphaowl.dnd.mappers;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

// R = Root DTO (e.g., MonsterRoot) - Usado para carregar listas
// D = Data DTO (e.g., MonsterData) - Usado para carregar listas
// T = Item DTO (e.g., Monster) - O objeto que você quer carregar (lista ou único)
public abstract class AbstractJsonLoader<R, D, T> {

    protected final ObjectMapper objectMapper = new ObjectMapper();

    private final Type rootType;
    private final Class<T> itemClass;

    @SuppressWarnings("unchecked")
    public AbstractJsonLoader() {
        Type superClass = getClass().getGenericSuperclass();
        if (superClass instanceof ParameterizedType) {
            ParameterizedType pType = (ParameterizedType) superClass;
            // Pega o primeiro tipo genérico (R)
            this.rootType = pType.getActualTypeArguments()[0];
            // Pega o terceiro tipo genérico (T) e o converte para Class<T>
            this.itemClass = (Class<T>) pType.getActualTypeArguments()[2];
        } else {
            this.rootType = null;
            this.itemClass = null;
        }
    }

    protected abstract List<T> extractItemList(R root);

    public List<T> loadItemsFromJson(InputStream inputStream) {
        if (rootType == null || inputStream == null) {
            System.err.println("Erro de configuração: Tipos genéricos não definidos ou InputStream é nulo.");
            return Collections.emptyList();
        }

        TypeReference<R> typeReference = new TypeReference<R>() {
            @Override
            public Type getType() {
                return rootType;
            }
        };

        try {
            R root = objectMapper.readValue(inputStream, typeReference);

            return extractItemList(root);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Erro ao ler ou mapear o InputStream JSON da lista: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    public T loadItemFromJson(InputStream inputStream) {
        if (itemClass == null) {
            System.err.println("Erro de configuração: AbstractJsonLoader não inicializado corretamente com tipos genéricos.");
            return null;
        }

        try {
            return objectMapper.readValue(inputStream, itemClass);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Erro ao ler ou mapear o arquivo JSON do item único: " + e.getMessage());
            return null;
        }
    }
}