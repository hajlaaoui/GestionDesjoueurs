package com.example.gestiondesjoueurs.entities;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Getter
@Setter
@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstname;
    private String lastname;
    private String shortname;
    private String sex;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_code")
    private Country country;

    private String picture;
    @ManyToOne(fetch = FetchType.LAZY)
    private PlayerData data;

    // Getters and setters
}
