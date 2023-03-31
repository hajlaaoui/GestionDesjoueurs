package com.example.gestiondesjoueurs.controller;

import com.example.gestiondesjoueurs.entities.Country;
import com.example.gestiondesjoueurs.entities.Player;
import com.example.gestiondesjoueurs.exception.PlayerNotFoundException;
import com.example.gestiondesjoueurs.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/players")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }
    @PostMapping("")
    public ResponseEntity<Player> addPlayer(@RequestBody Player player) {
        Player addedPlayer = playerService.addPlayer(player);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedPlayer);
    }
    @GetMapping
    public ResponseEntity<List<Player>> getPlayers() {
        try {
            List<Player> players = playerService.getPlayers();
            return new ResponseEntity<>(players, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Player> getPlayerById(@PathVariable("id") Long id) {
        try {
            Player player = playerService.getPlayerById(id);
            return new ResponseEntity<>(player, HttpStatus.OK);
        } catch (PlayerNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @GetMapping("/stats/average-imc")
    public ResponseEntity<Double> getAverageImc() {
        try {
            Double averageImc = playerService.getAverageIMC();
            return new ResponseEntity<>(averageImc, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/stats/median-height")
    public ResponseEntity<Double> getMedianHeight() {
        try {
            Double medianHeight = playerService.getMedianHeight();
            return new ResponseEntity<>(medianHeight, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ExceptionHandler({PlayerNotFoundException.class})
    public ResponseEntity<Object> handlePlayerNotFoundException(PlayerNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<Object> handleException(Exception ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
