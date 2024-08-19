package com.hpc.totem_api.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;


@Getter
public abstract class AppBaseException extends RuntimeException {
    protected HttpStatus code;
    protected String message;
}
