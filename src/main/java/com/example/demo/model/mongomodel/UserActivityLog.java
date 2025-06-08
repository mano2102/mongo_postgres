package com.example.demo.model.mongomodel;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "user_activity_logs")
public class UserActivityLog {

    @Id
    private String id;

    private String userId;

    private String action;

    private LocalDateTime timestamp;

    private Map<String, Object> details;  // extra info like productId, page, etc.
}
