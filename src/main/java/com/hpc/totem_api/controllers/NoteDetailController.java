package com.hpc.totem_api.controllers;

import com.hpc.totem_api.dto.notes.GetDetailNoteDTO;
import com.hpc.totem_api.dto.notes.PostNoteDTO;
import com.hpc.totem_api.dto.notes.UpdatedNoteDTO;
import com.hpc.totem_api.exception.NoteNotFoundException;
import com.hpc.totem_api.services.NoteServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("note/{id}")
@RestController
public class NoteDetailController {

    @Autowired
    private NoteServiceInterface noteService;

    @GetMapping
    public ResponseEntity<GetDetailNoteDTO> detailedNote(@PathVariable("id") int id) throws NoteNotFoundException {
        return ResponseEntity.ok(noteService.retrieveNote(String.valueOf(id)));
    }

    @PutMapping
    public ResponseEntity<UpdatedNoteDTO> updateNote(@PathVariable("id") int id, @RequestBody PostNoteDTO data) throws NoteNotFoundException {
        return ResponseEntity.ok(noteService.updateNote(String.valueOf(id), data));
    }

    @DeleteMapping
    public ResponseEntity<Object> deleteNote(@PathVariable("id") int id) throws NoteNotFoundException {
        noteService.deleteNote(String.valueOf(id));
        return ResponseEntity.noContent().build();
    }
}
