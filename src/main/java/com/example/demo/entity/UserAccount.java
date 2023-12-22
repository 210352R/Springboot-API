package com.example.demo.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "your_entity_seq")
    @SequenceGenerator(name = "your_entity_seq", sequenceName = "your_entity_seq", allocationSize = 1)
    private Long id;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;


    @Temporal(TemporalType.TIMESTAMP) // Use TemporalType.DATE for date only
    private LocalDateTime createdDate;


    @Column(columnDefinition = "DECIMAL(10, 2)") // Precision 10, Scale 2 (adjust as needed)
    private BigDecimal curr_amount;

    @Column(columnDefinition = "DECIMAL(10, 2)") // Precision 10, Scale 2 (adjust as needed)
    private BigDecimal total_amount;

    @Column(length = 10)
    private String state;


    public UserAccount(User user, LocalDateTime createdDate, BigDecimal curr_amount, BigDecimal total_amount, String state) {
        this.user = user;
        this.createdDate = createdDate;
        this.curr_amount = curr_amount;
        this.total_amount = total_amount;
        this.state = state;
    }
}