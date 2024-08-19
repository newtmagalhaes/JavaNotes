package com.hpc.totem_api.exception;

import org.springframework.http.HttpStatus;

public class NoteNotFoundException extends AppBaseException {
    private final HttpStatus code = HttpStatus.NOT_FOUND;

    public NoteNotFoundException(String message) {
        this.message = message;
    }

    public NoteNotFoundException() {
        this.message = "Item not found";
    }
}
