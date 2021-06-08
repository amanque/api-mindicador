package cl.bice.mindicador.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import cl.bice.mindicador.dto.IndicadorDto;

public class Factory {
	public static IndicadorDto getIndicadorDto() {
		IndicadorDto dto = null;
		try {
			dto = new ObjectMapper().readValue("{\"version\":\"1.6.0\",\"autor\":\"mindicador.cl\",\"codigo\":\"uf\",\"nombre\":\"Unidad de fomento (UF)\",\"unidad_medida\":\"Pesos\",\"serie\":[{\"fecha\":\"07-06-2021\",\"valor\":29639.96}]}", IndicadorDto.class);
		} catch (Exception e) {
			throw new RuntimeException();
		}
		return dto;
	}

}
