package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = "user")
@Data
public class Withdrowal {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "withdrowal_entity_seq")
    @SequenceGenerator(name = "withdrowal_entity_seq", sequenceName = "withdrowal_entity_seq", allocationSize = 1)
    @Column(length = 10)
    private Long trans_id;


    // Add  User ------
    // for one withdrawal -- > one and only User

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;


    @Temporal(TemporalType.TIMESTAMP) // Use TemporalType.DATE for date only
    private LocalDateTime setDate;


    @Column(columnDefinition = "DECIMAL(10, 2)") // Precision 10, Scale 2 (adjust as needed)
    private BigDecimal total_amount;

    @Temporal(TemporalType.TIMESTAMP) // Use TemporalType.DATE for date only
    private LocalDateTime getDate;


    @Column(length = 10)
    private String status;


    @OneToOne(mappedBy = "withdrowal", fetch = FetchType.LAZY)
    @JsonIgnore
    private ActivityLog activityLog;

    public Withdrowal(User user, LocalDateTime setDate, BigDecimal total_amount,  String status) {
        this.user = user;
        this.setDate = setDate;
        this.total_amount = total_amount;
        this.status = status;
    }

}
