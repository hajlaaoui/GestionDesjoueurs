package com.example.gestiondesjoueurs.exception;

public class PlayerNotFoundException extends RuntimeException {
    public PlayerNotFoundException(Long id) {
        super("Could not find player with ID: " + id);
    }
}
