package com.lavoratoristagionali.backend.repository;

import com.lavoratoristagionali.backend.model.Dipendente;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface DipendenteRepository extends JpaRepository<Dipendente, Long> {
    Optional<Dipendente> findByUsername(String username);
}
