package com.hpc.totem_api.controllers;

import com.hpc.totem_api.domain.Note;
import com.hpc.totem_api.dto.notes.GetNoteDTO;
import com.hpc.totem_api.dto.notes.PostNoteDTO;
import com.hpc.totem_api.repositories.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("note")
public class NoteController {

    @Autowired
    private NoteRepository repository;

    @GetMapping
    public List<GetNoteDTO> getAllNotes() {
        return repository.findAll().stream().map(GetNoteDTO::new).toList();
    }

    @PostMapping
    public void createNote(@RequestBody PostNoteDTO data) {
        Note noteData = new Note(data);
        repository.save(noteData);
    }
}
