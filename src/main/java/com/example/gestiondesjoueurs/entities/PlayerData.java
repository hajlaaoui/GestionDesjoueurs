package com.example.gestiondesjoueurs.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
public class PlayerData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int rank;

    @Column(nullable = false)
    private int points;

    @Column(nullable = false)
    private int weight;

    @Column(nullable = false)
    private int height;

    @Column(nullable = false)
    private int age;

    @ElementCollection
    private List<Integer> last_matches;
}
