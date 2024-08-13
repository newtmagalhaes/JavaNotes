package com.hpc.totem_api.dto.notes;

import com.hpc.totem_api.domain.Note;

public record GetNoteDTO(String id, String title) {

    public GetNoteDTO(Note note) {
        this(note.getId(), note.getTitle());
    }
}
