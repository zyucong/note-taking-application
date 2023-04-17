package com.roomboss.demo.controller;

import com.roomboss.demo.entity.NoteView;
import com.roomboss.demo.entity.SaveRequest;
import com.roomboss.demo.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/server")
public class ServerController {

    @Autowired
    private NoteService noteService;

    @PostMapping("/save")
    public Object saveNote(@RequestBody SaveRequest request) {
        noteService.saveNote(request);
        return ResponseEntity.status(HttpStatus.OK);
    }

    @GetMapping("/notes")
    public List<NoteView> retrieveNotes() {
        return noteService.getNotes();
    }

    @GetMapping("/note")
    public NoteView retrieveNote(@RequestParam("id") Integer id) {
        try {
            return noteService.getNote(id);
        } catch (Exception ex) {
            // a bit fail-safe for now
            return new NoteView();
        }
    }
}
