package com.raphaowl.dnd.service.generators.items;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public abstract class AbstractItemGenerator implements ItemGenerator {

    Random random = new Random();
}
