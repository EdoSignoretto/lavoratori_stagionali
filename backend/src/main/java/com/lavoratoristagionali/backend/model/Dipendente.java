package com.lavoratoristagionali.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@Table(name = "dipendenti")
@Data
@NoArgsConstructor
public class Dipendente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cognome;
    private String email;
    private String telefono;
    private LocalDate dataNascita;
    private String luogoNascita;

    @Column(unique = true)
    private String username;

    // In a real app, this should be hashed!
    private String password;
}
