package com.mohibur.mongocrud.configuration;

import com.mohibur.mongocrud.model.BaseModel;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.data.mongodb.core.mapping.event.BeforeSaveEvent;

import java.time.Instant;

public class MongoEventListener extends AbstractMongoEventListener<BaseModel> {
    @Override
    public void onBeforeConvert(BeforeConvertEvent<BaseModel> event) {
        super.onBeforeConvert(event);
        BaseModel entity = event.getSource();
        if (entity.getCreatedAt() == null) {
            entity.setCreatedAt(Instant.now());
        }
        entity.setUpdatedAt(Instant.now());
    }

    @Override
    public void onBeforeSave(BeforeSaveEvent<BaseModel> event) {
        super.onBeforeSave(event);
        BaseModel entity = event.getSource();
        if (entity.getCreatedAt() == null) {
            entity.setCreatedAt(Instant.now());
        }
        entity.setUpdatedAt(Instant.now());
    }
}
