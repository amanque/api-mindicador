package cl.bice.mindicador.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class BaseDto implements Serializable {
	private static final long serialVersionUID = 1L;
	private String codigo;
	private String mensaje;
}
