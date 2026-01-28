package com.lavoratoristagionali.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@Table(name = "lavori")
@Data
@NoArgsConstructor
public class Lavoro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "lavoratore_id")
    private Lavoratore lavoratore;

    private String nomeLavoro;
    private String nomeAzienda;
    private String luogoLavoro;

    private Double retribuzioneLorda;
    private Double retribuzioneGiornaliera;

    private String mansione1;
    private String mansione2;

    private LocalDate dataInizio;
    private LocalDate dataFine;
}
