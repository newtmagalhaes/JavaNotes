package com.hpc.totem_api.services;

import com.hpc.totem_api.domain.Note;
import com.hpc.totem_api.dto.notes.*;
import com.hpc.totem_api.exception.NoteNotFoundException;
import com.hpc.totem_api.repositories.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteService implements NoteServiceInterface {
    @Autowired
    NoteRepository noteRepository;

    @Override
    public List<GetNoteDTO> findAllNotes() {
        return noteRepository.findAll().stream().map(GetNoteDTO::new).toList();
    }

    @Override
    public CreatedNoteDTO createNote(PostNoteDTO data) {
        Note new_note = new Note(data);
        noteRepository.save(new_note);
        return new CreatedNoteDTO(new_note);
    }

    @Override
    public GetDetailNoteDTO retrieveNote(String id) {
        Optional<Note> note = noteRepository.findById(String.valueOf(id));
        if (note.isEmpty()) throw new NoteNotFoundException("Note with id '%s' not found".formatted(id));

        return new GetDetailNoteDTO(note.get());
    }

    @Override
    public UpdatedNoteDTO updateNote(String id, PostNoteDTO data) {
        Optional<Note> possibleNote = noteRepository.findById(String.valueOf(id));
        if (possibleNote.isEmpty()) throw new NoteNotFoundException();

        Note note = possibleNote.get();
        note.setTitle(data.title());
        note.setBody(data.body());
        noteRepository.save(note);
        return new UpdatedNoteDTO(note);
    }

    @Override
    public void deleteNote(String id) {
        Optional<Note> possibleNote = noteRepository.findById(String.valueOf(id));
        if (possibleNote.isEmpty()) throw new NoteNotFoundException();

        noteRepository.delete(possibleNote.get());
    }
}
