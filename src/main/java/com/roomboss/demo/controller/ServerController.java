package com.roomboss.demo.controller;

import com.roomboss.demo.entity.NoteView;
import com.roomboss.demo.entity.SaveRequest;
import com.roomboss.demo.service.NoteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/server")
public class ServerController {

    @Autowired
    private NoteService noteService;

    private static final Logger logger = LoggerFactory.getLogger(ServerController.class);


    @PostMapping("/save")
    public Object saveNote(@RequestBody SaveRequest request) {
        noteService.saveNote(request);
        return ResponseEntity.ok("success");
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
