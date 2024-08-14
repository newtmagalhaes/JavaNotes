package com.hpc.totem_api.controllers;

import com.hpc.totem_api.domain.Note;
import com.hpc.totem_api.dto.notes.CreatedNoteDTO;
import com.hpc.totem_api.dto.notes.GetNoteDTO;
import com.hpc.totem_api.dto.notes.PostNoteDTO;
import com.hpc.totem_api.repositories.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("note")
public class NoteController {

    @Autowired
    private NoteRepository repository;

    @GetMapping
    public ResponseEntity<List<GetNoteDTO>> getAllNotes() {
        var notes = repository.findAll().stream().map(GetNoteDTO::new).toList();
        return ResponseEntity.ok(notes);
    }

    @PostMapping
    public ResponseEntity<CreatedNoteDTO> createNote(@RequestBody PostNoteDTO data) {
        Note noteData = new Note(data);
        repository.save(noteData);
        var responseData = new CreatedNoteDTO(noteData);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseData);
    }
}

