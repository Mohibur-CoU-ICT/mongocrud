package com.mohibur.mongocrud.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.Instant;

@Data
@JsonIgnoreProperties({"createdAt", "createdBy", "updatedAt", "updatedBy"})
public class BaseModel {
    @CreatedBy
    @Field("created_by")
    private String createdBy;

    @CreatedDate
    @Field("created_at")
    private Instant createdAt;

    @LastModifiedBy
    @Field("updated_by")
    private String updatedBy;

    @LastModifiedDate
    @Field("updated_at")
    private Instant updatedAt;
}
