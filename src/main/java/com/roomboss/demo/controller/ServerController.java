package com.roomboss.demo.controller;

import com.roomboss.demo.dao.NoteDao;
import com.roomboss.demo.entity.NoteView;
import com.roomboss.demo.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/server")
public class ServerController {

    @Autowired
    private NoteDao noteDao;

    @Autowired
    private NoteService noteService;

    @PostMapping("/save")
    public Object saveNote(@RequestBody String note) {
        return null;
    }

    @GetMapping("/notes")
    public List<NoteView> retrieveNotes() {
        return noteService.getNotes();
    }

    @GetMapping("/note")
    public Object retrieveNote(@RequestParam("id") int id) {
        return null;
    }
}
