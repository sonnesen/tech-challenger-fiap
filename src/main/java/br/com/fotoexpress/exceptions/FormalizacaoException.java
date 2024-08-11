package br.com.fotoexpress.exceptions;

import org.springframework.http.HttpStatus;

public class FormalizacaoException extends RuntimeException {

    private HttpStatus status;

    public FormalizacaoException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }



}
