package com.roomboss.demo.service;

import com.roomboss.demo.dao.NoteDao;
import com.roomboss.demo.entity.Note;
import com.roomboss.demo.entity.NoteView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NoteService {

    @Autowired
    private NoteDao noteDao;

    public List<NoteView> getNotes() {
        List<Note> notes = noteDao.findAll();
        List<NoteView> views = notes.stream()
                .map(note -> {
                    NoteView view = new NoteView();
                    view.setId(note.getId());
                    view.setNote(note.getNote());
                    return view;
                })
                .collect(Collectors.toList());
        return views;
    }
}
