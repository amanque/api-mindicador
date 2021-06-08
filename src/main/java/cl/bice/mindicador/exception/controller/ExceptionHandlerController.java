package cl.bice.mindicador.exception.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import cl.bice.mindicador.dto.ResponseDto;
import cl.bice.mindicador.exception.GlobalException;
import cl.bice.mindicador.utils.Util;

@ControllerAdvice
@ResponseBody
public class ExceptionHandlerController {
	@ExceptionHandler({GlobalException.class} )
	public ResponseEntity<ResponseDto<String>> globalExeption(GlobalException ex, WebRequest request) {
		ResponseDto<String> msgError;
		msgError = Util.setError(null, ex.getMessage() + " " + ex.getCode().toString());
		return new ResponseEntity<>(msgError, ex.getCode());
	}
}
