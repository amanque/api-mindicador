package cl.bice.mindicador.dto;

import java.io.Serializable;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.googlecode.jmapper.annotations.JMap;

import lombok.Data;

@Data
public class SerieDto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@JMap
	private int idSerie;
	
	@JMap
	private String fecha;
	
	@JMap
	private Double valor;
	
	@JsonIgnore
	@JMap
	private UUID indicador_rel;
	
}
