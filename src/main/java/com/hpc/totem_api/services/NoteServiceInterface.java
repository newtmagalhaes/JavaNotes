package com.hpc.totem_api.services;

import com.hpc.totem_api.dto.notes.*;

import java.util.List;

public interface NoteServiceInterface {

    List<GetNoteDTO> findAllNotes();

    CreatedNoteDTO createNote(PostNoteDTO data);

    GetDetailNoteDTO retrieveNote(String id);

    UpdatedNoteDTO updateNote(String id, PostNoteDTO data);

    void deleteNote(String id);
}
