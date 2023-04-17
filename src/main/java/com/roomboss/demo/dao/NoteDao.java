package com.roomboss.demo.dao;

import com.roomboss.demo.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteDao extends JpaRepository<Note, Integer> {
}
