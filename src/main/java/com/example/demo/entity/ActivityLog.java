package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = "admin")
@Data
public class ActivityLog {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "activity_log_seq")
    @SequenceGenerator(name = "activity_log_seq", sequenceName = "activity_log_seq", allocationSize = 1)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "admin_id")
    @JsonIgnore
    private Admin admin;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Trans_Id")
    @JsonIgnore
    private Withdrowal withdrowal;

    @Temporal(TemporalType.TIMESTAMP) // Use TemporalType.DATE for date only
    private LocalDateTime Date;

    @Column(length = 10)
    private String state;

//    @Column(length = 255)
    private String comment;

    public ActivityLog(Admin admin, Withdrowal withdrowal, LocalDateTime date, String state, String comment) {
        this.admin = admin;
        this.withdrowal = withdrowal;
        this.Date = date;
        this.state = state;
        this.comment = comment;
    }
}
