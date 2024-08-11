package br.com.fotoexpress.exceptions;

import org.springframework.http.HttpStatus;

public class PedidoException extends RuntimeException {

    private HttpStatus status;

    public PedidoException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }

}
