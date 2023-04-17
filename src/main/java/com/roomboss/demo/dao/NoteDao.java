package com.roomboss.demo.dao;

import com.roomboss.demo.entity.Note;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteDao extends CrudRepository<Note, Integer> {
}
