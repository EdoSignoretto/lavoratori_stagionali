package com.lavoratoristagionali.backend.repository;

import com.lavoratoristagionali.backend.model.Lavoratore;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LavoratoreRepository extends JpaRepository<Lavoratore, String> {
    // Example custom query: find by surname
    List<Lavoratore> findByCognome(String cognome);

    // Example: find by experience (requires JPA JOIN syntax if complex, but simple
    // version works for ElementCollection often)
    // List<Lavoratore> findByEsperienzeContaining(String esperienza);
}
