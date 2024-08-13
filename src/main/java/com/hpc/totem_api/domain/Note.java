package com.hpc.totem_api.domain;

import com.hpc.totem_api.dto.notes.PostNoteDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Table(name = "notes")
@Entity(name = "notes")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "uuid")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String title;
    private String body;

    public Note(PostNoteDTO data) {
        this.title = data.title();
        this.body = data.body();
    }
}
