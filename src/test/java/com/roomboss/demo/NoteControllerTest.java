package com.roomboss.demo;

import com.roomboss.demo.controller.NoteController;
import com.roomboss.demo.entity.NoteView;
import com.roomboss.demo.entity.SaveRequest;
import com.roomboss.demo.service.NoteService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

@ExtendWith(SpringExtension.class)
@WebFluxTest(NoteController.class)
public class NoteControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private NoteService noteService;

    @Test
    public void testGetNote() throws Exception {
        NoteView note = new NoteView();
        note.setId(1);
        note.setTextNote("Hello World");
        Mockito.when(noteService.getNote(1)).thenReturn(Mono.just(note));
        webTestClient.get()
                .uri("/server/note?id=1")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody(NoteView.class)
                .value(noteView -> {
                    assert(noteView.getTextNote().equals("Hello World"));
                });
    }

    @Test
    public void testGetNotes() throws Exception {
        NoteView note1 = new NoteView.NoteViewBuilder().setId(1).setTextNote("note1").build();
        NoteView note2 = new NoteView.NoteViewBuilder().setId(2).setTextNote("note2").build();
        NoteView note3 = new NoteView.NoteViewBuilder().setId(3).setTextNote("note3").build();
        List<NoteView> notes = Arrays.asList(note1, note2, note3);
        Mockito.when(noteService.getNotes()).thenReturn(Mono.just(notes));
        webTestClient.get()
                .uri("/server/notes")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(NoteView.class)
                .hasSize(3)
                .value(list -> {
                    assert(list.get(0).getTextNote().equals("note1"));
                    assert(list.get(1).getTextNote().equals("note2"));
                    assert(list.get(2).getTextNote().equals("note3"));
                });
    }

    @Test
    public void testSaveNote() throws Exception {
        SaveRequest request = new SaveRequest();
        request.setTextNote("Hello World");
        Mockito.when(noteService.saveNote(request)).thenReturn(Mono.just("success"));
        webTestClient.post()
                .uri("/server/save")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(request), SaveRequest.class)
                .exchange()
                .expectStatus().isCreated()
                .expectBody(String.class)
                .isEqualTo("success")
                ;
    }
}
