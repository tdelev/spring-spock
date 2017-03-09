package me.delev.javaskop17.springspock.repository;

import me.delev.javaskop17.springspock.model.Starship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Starship repository
 */
@Repository
public interface StarshipRepository extends JpaRepository<Starship, String> {
}
