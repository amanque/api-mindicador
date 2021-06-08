package cl.bice.mindicador.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import cl.bice.mindicador.dto.IndicadorDto;
import cl.bice.mindicador.dto.ListaIndicadorDto;
import cl.bice.mindicador.dto.SerieDto;
import cl.bice.mindicador.model.Indicador;
import cl.bice.mindicador.repository.IIndicadorRepository;
import cl.bice.mindicador.services.IIndicadorService;
import cl.bice.mindicador.services.ISerieService;
import cl.bice.mindicador.utils.Mapper;

@Service("IndicadorService")
public class IndicadorServiceImpl implements IIndicadorService {
	
	@Value("${api.url_base}")
	private String url;
	
	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private IIndicadorRepository indicadorRepository;
	
	@Autowired
	private ISerieService serieService;
	
	@Override
	public IndicadorDto getIndicadoresByIndYFecha(String codigoIndicador, String fecha) {
		
		Indicador indicador = indicadorRepository.findByIndicadorAndFecha(codigoIndicador, fecha);
		
		if (indicador == null) {
			IndicadorDto indicadorDto =  getIndicadorPorIndicadorAndFecha("/"+codigoIndicador+"/"+fecha);
			
			indicador = Mapper.map(indicadorDto, Indicador.class);
			indicador.setFecha(fecha);
			
			if(indicadorDto != null && !indicadorDto.getSerie().isEmpty()) {
				indicadorRepository.save(indicador);
				SerieDto serieDto = new SerieDto();
				serieDto.setIndicador_rel(indicador.getIdIndicador());
				serieDto.setFecha(fecha);
				serieDto.setValor(indicadorDto.getSerie().get(0).getValor());
				serieService.save(serieDto);
			} else 
				return null;
				
			return indicadorDto;
		}
		
		return Mapper.map(indicador, IndicadorDto.class);
	}

	@Override
	public ListaIndicadorDto getIndicadoresApi() {
		ListaIndicadorDto indicadorDto = restTemplate.getForObject(
				this.url,
				ListaIndicadorDto.class);
		return indicadorDto;
	}
	
	
	private IndicadorDto getIndicadorPorIndicadorAndFecha(String paramUrl) {
		IndicadorDto indicadorDto = restTemplate.getForObject(
				this.url + paramUrl,
				IndicadorDto.class);
		return indicadorDto;
	}

}
