package com.hpc.totem_api.controllers;

import com.hpc.totem_api.notes.GetNoteDTO;
import com.hpc.totem_api.notes.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RestController
@RequestMapping("greet")
public class GreetingController {

    @Autowired
    private NoteRepository repository;

    @GetMapping
    public List<GetNoteDTO> getAllNotes() {
        return repository.findAll().stream().map(GetNoteDTO::new).toList();
    }
}
