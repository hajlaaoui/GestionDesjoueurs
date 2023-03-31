package com.example.gestiondesjoueurs.repository;

import com.example.gestiondesjoueurs.entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public interface PlayerRepository  extends JpaRepository<Player, Long> {
    List<Player> findAllByOrderByDataRankDesc();



//    @Query(value = "SELECT AVG(p.data.weight / (p.data.height / 100.0 * p.data.height / 100.0)) FROM Player p")
//    Double findImcMoyenJoueurs();

        List<Integer> findAllByOrderByDataHeight();
}
