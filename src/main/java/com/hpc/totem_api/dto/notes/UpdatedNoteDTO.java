package com.hpc.totem_api.dto.notes;

import com.hpc.totem_api.domain.Note;

public record UpdatedNoteDTO(int id, String title, String body) {
    public UpdatedNoteDTO(Note note) {
        this(note.getId(), note.getTitle(), note.getBody());
    }
}
