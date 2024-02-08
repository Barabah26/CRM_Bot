package com.example.crm.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Data
public class Students {

    @Id
    @SequenceGenerator(name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY,
            generator = "user_sequence")
    private Long telegramId;
    private String fullName;
    private String yearEntry;
    private String statement;
    private String phoneNumber;
    private String group;

}
