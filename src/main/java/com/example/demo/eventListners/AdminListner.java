package com.example.demo.eventListners;

import com.example.demo.entity.Admin;
import com.example.demo.entity.Note;
import com.example.demo.repo.NoteRepo;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import org.springframework.beans.factory.annotation.Autowired;

public class AdminListner {

    @Autowired
    private NoteRepo noteRepo;

    @PrePersist
    public void prePersist(Admin admin) {
        System.out.println("Before persisting product with ID ---------------------------------------  : " + admin.getId());
        Note noteTemp = new Note(admin,"Added Note - "+admin.getId());
        Note note = noteRepo.save(noteTemp);
        // Perform actions before the entity is persisted to the database
    }

    @PreUpdate
    public void preUpdate(Admin admin) {
        System.out.println("Before updating product with ID: " + admin.getId());
        // Perform actions before the entity is updated in the database
    }
}
