package com.mohibur.mongocrud.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Document
public class GroceryItem {
    @Id
    private String id;
    private String name;
    private Integer quantity;
    private String category;
}
