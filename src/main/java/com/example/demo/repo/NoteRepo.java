package com.example.demo.repo;

import com.example.demo.entity.Admin;
import com.example.demo.entity.Note;
import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepo extends JpaRepository<Note, Long> {


}
