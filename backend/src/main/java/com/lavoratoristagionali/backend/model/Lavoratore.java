package com.lavoratoristagionali.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "lavoratori")
@Data
@NoArgsConstructor
public class Lavoratore {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id; // Keeping String ID but using UUID strategy for generation

    private String nome;
    private String cognome;
    private String email;
    private String telefono;
    private LocalDate dataNascita;
    private String luogoNascita;

    private String via;
    private String numeroCivico;
    private String paese;
    private String nazionalita;

    @ElementCollection
    private List<String> esperienze;

    @ElementCollection
    private List<String> lingue;

    private String patente;
    private boolean automunito;

    // Contact info for emergency
    private String nomeEmergenza;
    private String cognomeEmergenza;
    private String emailEmergenza;
    private String telefonoEmergenza;

    // Availability fields could be refined into a separate Embeddable or Entity,
    // keeping simple for first pass migration.
    private String comune1;
    private LocalDate inizioDisponibilitaComune1;
    private LocalDate fineDisponibilitaComune1;

    private String comune2;
    private LocalDate inizioDisponibilitaComune2;
    private LocalDate fineDisponibilitaComune2;
}
