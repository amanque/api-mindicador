package cl.bice.mindicador.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.bice.mindicador.dto.SerieDto;
import cl.bice.mindicador.model.Serie;
import cl.bice.mindicador.repository.ISerieRepository;
import cl.bice.mindicador.services.ISerieService;
import cl.bice.mindicador.utils.Mapper;

@Service
public class SerieServiceImpl implements ISerieService{

	@Autowired
	ISerieRepository serieRepository;
	
	@Override
	public void save(SerieDto serieDto) {
		Serie serie = Mapper.map(serieDto, Serie.class);
		serieRepository.save(serie);
	}
}
