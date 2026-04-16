package com.example.demo.config;

import com.example.demo.model.User;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MongoConfig extends AbstractMongoEventListener<User> {

    // Automatically sets createdAt before saving a new user
    @Override
    public void onBeforeConvert(BeforeConvertEvent<User> event) {
        User user = event.getSource();
        if (user.getCreatedAt() == null) {
            user.setCreatedAt(LocalDateTime.now());
        }
    }
}
