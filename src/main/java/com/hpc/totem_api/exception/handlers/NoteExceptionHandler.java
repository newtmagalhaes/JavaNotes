package com.hpc.totem_api.exception.handlers;

import com.hpc.totem_api.dto.errors.ErrorDTO;
import com.hpc.totem_api.exception.NoteNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class NoteExceptionHandler {

    @ExceptionHandler(NoteNotFoundException.class)
    ResponseEntity<ErrorDTO> onNoteNotFoundException(NoteNotFoundException exception) {
        System.out.println(exception.getMessage());
        ErrorDTO error = new ErrorDTO(exception.getMessage(), null);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
