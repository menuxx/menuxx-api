package com.mall.push;

public class ClientInitException extends RuntimeException {

    public ClientInitException() {
    }

    public ClientInitException(String message) {
        super(message);
    }

    public ClientInitException(String message, Throwable cause) {
        super(message, cause);
    }

    public ClientInitException(Throwable cause) {
        super(cause);
    }
}
