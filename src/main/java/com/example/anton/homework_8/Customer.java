package com.example.anton.homework_8;

import lombok.*;

import java.math.BigDecimal;
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Customer {
    private String uuid;
    private String name;
    private Timestamp birthday;
    private BigDecimal account;
}
