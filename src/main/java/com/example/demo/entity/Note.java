package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "your_entity_seq")
    @SequenceGenerator(name = "your_entity_seq", sequenceName = "your_entity_seq", allocationSize = 1)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "admin_id")
    @JsonIgnore
    private Admin admin;

    private String caption;


    public Note(Admin admin, String caption) {
        this.admin = admin;
        this.caption = caption;
    }
}