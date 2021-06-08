package cl.bice.mindicador.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.bice.mindicador.model.Serie;

@Repository
public interface ISerieRepository extends JpaRepository<Serie, UUID> {

}
