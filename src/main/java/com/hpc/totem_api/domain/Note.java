package com.hpc.totem_api.domain;

import com.hpc.totem_api.dto.notes.PostNoteDTO;
import jakarta.persistence.*;
import lombok.*;


@Table(name = "notes")
@Entity(name = "notes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "notes_id_seq")
    @SequenceGenerator(name = "notes_id_seq", allocationSize = 1)
    private int id;
    private String title;
    private String body;

    public Note(PostNoteDTO data) {
        this.title = data.title();
        this.body = data.body();
    }
}
