package br.com.tecnoinfo.taskapi.exception;


public class RegistryNotFoundException extends RuntimeException {
    public RegistryNotFoundException() {
    }

    public RegistryNotFoundException(String message) {
        super(message);
    }
}
