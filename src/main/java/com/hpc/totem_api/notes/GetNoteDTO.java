package com.hpc.totem_api.notes;

public record GetNoteDTO(String id, String title) {

    public GetNoteDTO(Note note) {
        this(note.getId(), note.getTitle());
    }
}
