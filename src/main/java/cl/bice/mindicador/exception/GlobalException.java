package cl.bice.mindicador.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GlobalException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	private String message;
	private HttpStatus code;
	public GlobalException(String message, HttpStatus code) {
		super(message);
		this.message = message;
		this.code = code;
	}

}
