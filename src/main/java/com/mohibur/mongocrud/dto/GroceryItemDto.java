package com.mohibur.mongocrud.dto;

import lombok.Data;

@Data
public class GroceryItemDto {
    private String id;
    private String name;
    private Integer quantity;
    private String category;
}
