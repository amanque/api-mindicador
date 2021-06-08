package cl.bice.mindicador.utils;

import java.util.List;

import cl.bice.mindicador.dto.BaseDto;
import cl.bice.mindicador.dto.ResponseDto;



public class Util {

	@SuppressWarnings("unchecked")
	public static <T> ResponseDto<T> setReponse(T object) {

		ResponseDto<T> objMsg = new ResponseDto<>();
		BaseDto objEx = new BaseDto();

		if (object == null || object.equals(0) || (object instanceof List && ((List<T>) object).isEmpty())) {
			objEx.setCodigo(Constants.CODIGO_REGLA_SIN_DATOS);
			objEx.setMensaje(Constants.MENSAJE_REGLA_NO_EXITOSA);
		} else {
			objEx.setCodigo(Constants.CODIGO_REGLA_EXITOSA);
			objEx.setMensaje(Constants.MENSAJE_REGLA_EXITOSA);
		}

		objMsg.setObject(object);
		objMsg.setStatus(objEx);
		return objMsg;
	}

	public static <T> ResponseDto<T> setError(T objeto, String strError) {
		ResponseDto<T> msg = new ResponseDto<>();
		BaseDto objEx = new BaseDto();

		objEx.setCodigo(Constants.CODIGO_REGLA_ERROR_API);
		objEx.setMensaje(Constants.MENSAJE_ERROR_API.concat(strError));
		msg.setObject(objeto);
		msg.setStatus(objEx);
		return msg;
	}

}
