package cl.bice.mindicador.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cl.bice.mindicador.model.Indicador;

@Repository
public interface IIndicadorRepository  extends JpaRepository<Indicador, UUID>{
	
	@Query(value = "select * from indicador WHERE codigo = ?1 and fecha = ?2",  nativeQuery = true)
	public Indicador findByIndicadorAndFecha(String codigoIndicador, String fecha);

}
