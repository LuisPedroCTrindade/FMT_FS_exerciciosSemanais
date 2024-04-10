package com.fullstack.M1.S10.exception;

public class ServerErrorException extends RuntimeException{
    public ServerErrorException() {
        super();
    }

    public ServerErrorException(String message) {
        super(message);
    }
}
