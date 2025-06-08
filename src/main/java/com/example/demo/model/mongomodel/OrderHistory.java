package com.example.demo.model.mongomodel;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collation="order_history")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderHistory {
    @Id
    private String id;
    private String orderId;
    private String userId;
    private String orderData;
    private LocalDate timestamp;

}
