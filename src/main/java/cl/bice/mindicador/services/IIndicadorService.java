package cl.bice.mindicador.services;

import cl.bice.mindicador.dto.IndicadorDto;
import cl.bice.mindicador.dto.ListaIndicadorDto;

public interface IIndicadorService {
	public ListaIndicadorDto getIndicadoresApi();
	public IndicadorDto getIndicadoresByIndYFecha(String codigoIndicador, String fecha);

}
