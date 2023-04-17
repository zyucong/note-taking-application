package com.roomboss.demo.service;

import com.roomboss.demo.dao.NoteDao;
import com.roomboss.demo.entity.Note;
import com.roomboss.demo.entity.NoteView;
import com.roomboss.demo.entity.SaveRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class NoteService {

    @Autowired
    private NoteDao noteDao;

    public List<NoteView> getNotes() {
        Iterable<Note> notes = noteDao.findAll();
        List<NoteView> views = Streamable.of(notes).toList().stream()
                .map(note -> {
                    NoteView view = new NoteView();
                    view.setId(note.getId());
                    view.setTextNote(note.getTextNote());
                    return view;
                })
                .collect(Collectors.toList());
        return views;
    }

    public NoteView getNote(int id) throws Exception {
        if (!noteDao.findById(id).isPresent()) {
            throw new Exception();
        }
        Note note = noteDao.findById(id).get();
        Logger.getAnonymousLogger().info(note.toString());
        NoteView view = new NoteView();
        view.setId(note.getId());
        view.setTextNote(note.getTextNote());
        return view;
    }

    public void saveNote(SaveRequest request) {
        Note note = new Note();
        note.setTextNote(request.getTextNote());
        note.setCreateTime(System.currentTimeMillis());
        note.setUpdateTime(System.currentTimeMillis());
        noteDao.save(note);
    }
}
