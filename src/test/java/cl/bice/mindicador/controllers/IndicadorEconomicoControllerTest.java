package cl.bice.mindicador.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import cl.bice.mindicador.dto.IndicadorDto;
import cl.bice.mindicador.dto.ResponseDto;
import cl.bice.mindicador.services.IIndicadorService;
import cl.bice.mindicador.utils.Factory;
import cl.bice.mindicador.utils.Util;

class IndicadorEconomicoControllerTest {
	
	@InjectMocks
	IndicadorEconomicoController controller;

	@Mock
	private IIndicadorService indicadorService;
	
	@InjectMocks
	ResponseDto<IndicadorDto> objResponse;
	
	@SuppressWarnings("deprecation")
	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void test() {
		
		IndicadorDto indicadorDtoMock = Factory.getIndicadorDto();
		assertNotNull(indicadorDtoMock);
		
		when(indicadorService.getIndicadoresByIndYFecha("uf", "07-06-2021")).thenReturn(indicadorDtoMock);
		
		objResponse = Util.setReponse(indicadorDtoMock);
		
		assertNotNull(objResponse);
		
		ResponseEntity<ResponseDto<IndicadorDto>> response = controller.getPorIndicadorYFecha("uf", "07-06-2021");
		
		assertNotNull(response);
		
		assertEquals(response.getStatusCode(), HttpStatus.OK);

	}

}
