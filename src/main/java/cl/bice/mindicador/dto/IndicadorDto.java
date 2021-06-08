package cl.bice.mindicador.dto;

import java.io.Serializable;
import java.util.List;

import com.googlecode.jmapper.annotations.JMap;

import lombok.Data;

@Data
public class IndicadorDto implements Serializable {

	private static final long serialVersionUID = 1L;
	

	@JMap
	private String version;

	@JMap
	private String autor;

	@JMap
	private String codigo;

	@JMap
	private String nombre;

	@JMap
	private String unidad_medida;

	@JMap
	private List<SerieDto> serie;

}
