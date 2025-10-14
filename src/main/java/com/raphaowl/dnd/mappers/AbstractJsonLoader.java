package com.raphaowl.dnd.mappers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

// R = Root DTO (e.g., MonsterRoot) - Usado para carregar listas
// D = Data DTO (e.g., MonsterData) - Usado para carregar listas
// T = Item DTO (e.g., Monster) - O objeto que você quer carregar (lista ou único)
public abstract class AbstractJsonLoader<R, D, T> {

    protected final ObjectMapper objectMapper = new ObjectMapper();

    private final Type rootType;
    private final Class<T> itemClass; // Novo: Para carregar o objeto T diretamente

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

    // Mantém o método abstrato para a lista (JSON aninhado)
    protected abstract List<T> extractItemList(R root);

    // O método extractItem que você adicionou não é mais necessário,
    // pois a lógica de desserialização do item único será genérica e direta.
    // protected abstract T extractItem(T root); // Removido

    /**
     * Carrega o JSON do arquivo e retorna a lista de itens (usando R, D, T).
     * @param jsonFilePath O caminho para o arquivo JSON.
     * @return A lista de itens do tipo T, ou uma lista vazia em caso de erro.
     */
    public List<T> loadItemsFromJson(String jsonFilePath) {
        if (rootType == null) {
            // ... (mensagem de erro)
            return Collections.emptyList();
        }

        // ... (resto do código loadItemsFromJson é o mesmo)
        TypeReference<R> typeReference = new TypeReference<R>() {
            @Override
            public Type getType() {
                return rootType;
            }
        };

        try {
            R root = objectMapper.readValue(new File(jsonFilePath), typeReference);
            return extractItemList(root);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Erro ao ler ou mapear o arquivo JSON da lista: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    /**
     * NOVO: Carrega o JSON do arquivo e retorna um único item do tipo T (e.g., Monster).
     * @param jsonFilePath O caminho para o arquivo JSON (que contém apenas o objeto T).
     * @return O objeto T, ou null em caso de erro.
     */
    public T loadItemFromJson(String jsonFilePath) {
        if (itemClass == null) {
            System.err.println("Erro de configuração: AbstractJsonLoader não inicializado corretamente com tipos genéricos.");
            return null;
        }

        try {
            // Usa o itemClass (Monster.class) diretamente para desserializar
            return objectMapper.readValue(new File(jsonFilePath), itemClass);

        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Erro ao ler ou mapear o arquivo JSON do item único: " + e.getMessage());
            return null;
        }
    }
}