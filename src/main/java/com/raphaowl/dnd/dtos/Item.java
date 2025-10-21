package com.raphaowl.dnd.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {
        private Integer quantity;
        private String name;
        private Double price;
        private Double weight;
}
