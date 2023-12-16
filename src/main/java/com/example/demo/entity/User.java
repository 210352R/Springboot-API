package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Objects;

// To represent database table ++++++++++++
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = "admin")
// for getters and setters ---

@Data
public class User {
    @Id
    private int id;
    private String name;
    private String address;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "admin_id")
    @JsonIgnore
    private Admin admin;

    public User(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    //    @Override
//    public int hashCode() {
//        return Objects.hash(id, name, address);
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) return true;
//        if (obj == null || getClass() != obj.getClass()) return false;
//        User user = (User) obj;
//        return id == user.id && Objects.equals(name, user.name) && Objects.equals(address, user.address);
//    }

}
