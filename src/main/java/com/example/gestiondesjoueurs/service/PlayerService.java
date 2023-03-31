package com.example.gestiondesjoueurs.service;

import com.example.gestiondesjoueurs.entities.Player;
import com.example.gestiondesjoueurs.entities.PlayerData;
import com.example.gestiondesjoueurs.repository.CountryRepository;
import com.example.gestiondesjoueurs.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PlayerService {
    @Autowired
    private PlayerRepository playerRepository;

    public List<Player> getPlayers() {
        return playerRepository.findAllByOrderByDataRankDesc();
    }
    public Player addPlayer(Player player) {
        return playerRepository.save(player);
    }
    @Autowired
    private CountryRepository countryRepository;

    public List<Player> getAllPlayersSortedByPerformance() {
        return playerRepository.findAll(Sort.by(Sort.Direction.DESC, "data.rank"));
    }

    public Player getPlayerById(Long id) {
        return playerRepository.findById(id).orElse(null);
    }

    public String getCountryWithHighestWinRatio() {
        return null ;
    }

    public double getAverageIMC() {
        List<Player> players = playerRepository.findAll();
        double sum = 0;
        for (Player player : players) {
            PlayerData data = player.getData();
            double heightInMeters = data.getHeight() / 100.0;
            double bmi = data.getWeight() / (heightInMeters * heightInMeters);
            sum += bmi;
        }
        return sum / players.size();
    }

    public Double getMedianHeight() {
        return 1.0d ;
    }
}
