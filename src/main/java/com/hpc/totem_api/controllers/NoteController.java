package com.hpc.totem_api.controllers;

import com.hpc.totem_api.domain.Note;
import com.hpc.totem_api.dto.notes.CreatedNoteDTO;
import com.hpc.totem_api.dto.notes.GetNoteDTO;
import com.hpc.totem_api.dto.notes.PostNoteDTO;
import com.hpc.totem_api.services.NoteServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("note")
public class NoteController {

    @Autowired
    private NoteServiceInterface noteService;

    @GetMapping
    public ResponseEntity<List<GetNoteDTO>> getAllNotes() {
        return ResponseEntity.ok(noteService.findAllNotes());
    }

    @PostMapping
    public ResponseEntity<CreatedNoteDTO> createNote(@RequestBody PostNoteDTO data) {
        return ResponseEntity.status(HttpStatus.CREATED).body(noteService.createNote(data));
    }
}
