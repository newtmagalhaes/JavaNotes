package com.hpc.totem_api.controllers;

import com.hpc.totem_api.domain.Note;
import com.hpc.totem_api.dto.notes.CreatedNoteDTO;
import com.hpc.totem_api.dto.notes.PostNoteDTO;
import com.hpc.totem_api.repositories.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("note/{id}")
@RestController
public class NoteDetailController {

    @Autowired
    private NoteRepository repository;

    @GetMapping
    public ResponseEntity<CreatedNoteDTO> detailedNote(@PathVariable("id") int id) {
        Optional<Note> note = repository.findById(String.valueOf(id));
        if (note.isEmpty()) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(new CreatedNoteDTO(note.get()));
    }

    @PutMapping
    public ResponseEntity<CreatedNoteDTO> updateNote(@PathVariable("id") int id, @RequestBody PostNoteDTO data) {
        Optional<Note> possibleNote = repository.findById(String.valueOf(id));
        if (possibleNote.isEmpty()) return ResponseEntity.notFound().build();

        Note note = possibleNote.get();
        note.setTitle(data.title());
        note.setBody(data.body());
        repository.save(note);
        return ResponseEntity.ok(new CreatedNoteDTO(note));
    }

    @DeleteMapping
    public ResponseEntity<Object> deleteNote(@PathVariable("id") int id) {
        Optional<Note> possibleNote = repository.findById(String.valueOf(id));
        if (possibleNote.isEmpty()) return ResponseEntity.notFound().build();

        repository.delete(possibleNote.get());
        return ResponseEntity.noContent().build();
    }
}
