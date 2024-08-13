package com.hpc.totem_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hpc.totem_api.domain.Note;

public interface NoteRepository extends JpaRepository<Note, String> {
}
