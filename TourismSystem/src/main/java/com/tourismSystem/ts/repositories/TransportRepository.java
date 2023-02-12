package com.tourismSystem.ts.repositories;

import com.tourismSystem.ts.entities.Transport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransportRepository extends JpaRepository<Transport, Long> {
}
