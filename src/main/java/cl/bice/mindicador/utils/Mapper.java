package cl.bice.mindicador.utils;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.googlecode.jmapper.JMapper;
import com.googlecode.jmapper.api.JMapperAPI;

@Component
public class Mapper {

	private Mapper() {

	}

	@Bean
	private static JMapperAPI jMapperApi() {
		return new JMapperAPI();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <T, D> D map(final T source, Class<D> destination) {
		if (null != source) {
			JMapper<D, D> mapper = new JMapper(destination, source.getClass(), jMapperApi());
			return mapper.getDestination((D) source);
		}
		return null;
	}

	public static <D, T> List<D> mapAll(final Collection<T> entityList, Class<D> outCLass) {
		return entityList.stream().map(entity -> map(entity, outCLass)).collect(Collectors.toList());
	}
}