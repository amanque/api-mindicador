package cl.bice.mindicador.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class TipoIndicadorDto implements Serializable {
	private static final long serialVersionUID = 1L;
	private String codigo;
	private String nombre;
	private String unidad_medida;
	private Date fecha;
	private Double valor;

}
