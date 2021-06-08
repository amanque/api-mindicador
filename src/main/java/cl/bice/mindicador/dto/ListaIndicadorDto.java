package cl.bice.mindicador.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class ListaIndicadorDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String version;
	
	private String autor;
	
	private Date fecha;
	
	private TipoIndicadorDto uf;
	
	private TipoIndicadorDto ivp;
	
	private TipoIndicadorDto dolar;
	
	private TipoIndicadorDto dolar_intercambio;
	
	private TipoIndicadorDto euro;
	
	private TipoIndicadorDto ipc;
	
	private TipoIndicadorDto utm;
	
	private TipoIndicadorDto imacec;
	
	private TipoIndicadorDto tpm;
	
	private TipoIndicadorDto libra_cobre;
	
	private TipoIndicadorDto tasa_desempleo;
	
	private TipoIndicadorDto bitcoin;
	

}
