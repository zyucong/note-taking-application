package com.roomboss.demo.controller;

import com.roomboss.demo.entity.NoteView;
import com.roomboss.demo.entity.SaveRequest;
import com.roomboss.demo.service.NoteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/server")
public class NoteController {

    @Autowired
    private NoteService noteService;

    private static final Logger logger = LoggerFactory.getLogger(NoteController.class);

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<String> saveNote(@RequestBody SaveRequest request) {
        noteService.saveNote(request);
        return Mono.just("success");
    }

    @GetMapping("/notes")
    public Mono<List<NoteView>> retrieveNotes() {
        return noteService.getNotes();
    }

    @GetMapping("/note")
    public Mono<NoteView> retrieveNote(@RequestParam("id") Integer id) {
        try {
            return noteService.getNote(id);
        } catch (Exception ex) {
            // a bit fail-safe for now
            return Mono.just(new NoteView());
        }
    }
}
