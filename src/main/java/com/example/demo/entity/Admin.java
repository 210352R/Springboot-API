package com.example.demo.entity;

import com.example.demo.eventListners.AdminListner;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

@Entity
@EntityListeners(AdminListner.class)
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(exclude = "userList")
public class Admin {
    @Id
    private int id;
    private String name;
    private String address;

    @OneToOne(mappedBy = "admin", fetch = FetchType.LAZY)
    @JsonIgnore
    private Note note;






    public Admin(int id, String name, String address, Set<User> userList) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.userList = userList;
    }

    @OneToMany(mappedBy = "admin", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<User> userList;


//    @Override
//    public int hashCode() {
//        return Objects.hash(id, name, address);
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) return true;
//        if (obj == null || getClass() != obj.getClass()) return false;
//        Admin admin = (Admin) obj;
//        return id == admin.id && Objects.equals(name, admin.name) && Objects.equals(address, admin.address);
//    }
}
