package com.lavoratoristagionali.backend.repository;

import com.lavoratoristagionali.backend.model.Lavoro;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LavoroRepository extends JpaRepository<Lavoro, Long> {
    List<Lavoro> findByLavoratoreId(String lavoratoreId);
}
