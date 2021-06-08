package cl.bice.mindicador.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class ResponseDto<T> implements Serializable {
	private static final long serialVersionUID = 1L;
	private transient T object;
	private BaseDto status;
}
