package cl.bice.mindicador.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import cl.bice.mindicador.dto.IndicadorDto;
import cl.bice.mindicador.dto.ListaIndicadorDto;
import cl.bice.mindicador.dto.ResponseDto;
import cl.bice.mindicador.exception.GlobalException;
import cl.bice.mindicador.services.IIndicadorService;
import cl.bice.mindicador.utils.Constants;
import cl.bice.mindicador.utils.Util;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class IndicadorEconomicoController {
	
	@Autowired
	IIndicadorService indicadorService;
	
	@ApiOperation(value = "Endpoint que devolverá indicadores economicos.", notes = "En caso de éxito, retorne la lista de indicadores; En caso de error, retorne un error específico..", nickname = "indicadores")
	@GetMapping(value = "/indicadores", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses({ @ApiResponse(code = 204, message = "Hubo problemas al obtener indicadores.", response = HttpStatus.class),
			@ApiResponse(code = 200, message = "Indicadores obtenidos correctamente.", response = ResponseDto.class),
			@ApiResponse(code = 200, message = "Indicadores obtenidos correctamente.", response = ResponseDto.class) })
	public ResponseEntity<ResponseDto<ListaIndicadorDto>> indicadores() {
		
		HttpStatus status = HttpStatus.OK;
		
		ResponseDto<ListaIndicadorDto> response = null;
		
		ListaIndicadorDto indicadorDto =  indicadorService.getIndicadoresApi();
		
		if (indicadorDto == null) {
			status = HttpStatus.NO_CONTENT;
			response = Util.setError(null, Constants.ERROR_LISTA_INDICADORES);
			throw new GlobalException(Constants.ERROR_LISTA_INDICADORES, status);
		}
			
		response = Util.setReponse(indicadorDto);

		return new ResponseEntity<ResponseDto<ListaIndicadorDto>>(response, status);
	}
	
	@ApiOperation(value = "Endpoint que devolverá un indicador por indicador y fecha.", notes = "En caso de éxito, retorna un indicador; En caso de error, retorne un error específico..", nickname = "getPorIndicadorYFecha")
	@GetMapping(value = "/indicador/{codigoIndicador}/{fecha}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses({ @ApiResponse(code = 204, message = "Hubo problemas al obtener indicador.", response = HttpStatus.class),
			@ApiResponse(code = 200, message = "Indicador obtenido correctamente.", response = ResponseDto.class),
			@ApiResponse(code = 200, message = "Indicador obtenido correctamente.", response = ResponseDto.class) })
	public ResponseEntity<ResponseDto<IndicadorDto>> getPorIndicadorYFecha(@PathVariable(required = true) String codigoIndicador, @PathVariable(required = true) String fecha) {
		
		HttpStatus status = HttpStatus.OK;
		
		ResponseDto<IndicadorDto> response = null;
		
		IndicadorDto indicadorDto = indicadorService.getIndicadoresByIndYFecha(codigoIndicador, fecha);
		
		if (indicadorDto == null) {
			status = HttpStatus.NO_CONTENT;
			response = Util.setError(null, Constants.ERROR_GET_INDICADOR);
			throw new GlobalException(Constants.ERROR_GET_INDICADOR, status);
		}
			
		response = Util.setReponse(indicadorDto);

		return new ResponseEntity<ResponseDto<IndicadorDto>>(response, status);
	}

}
