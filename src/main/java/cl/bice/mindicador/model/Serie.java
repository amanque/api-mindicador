package cl.bice.mindicador.model;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "serie")
@ToString(of = { "idSerie", "fecha", "valor" })
@Data
public class Serie implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id_serie")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idSerie;

	@Column(nullable = false, name = "fecha")
	private String fecha;
	
	@Column(nullable = false, name = "valor")
	private Double valor;
	
	@Column(nullable = false, name = "indicador_rel")
	private UUID indicador_rel;
		
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
    @JoinColumn(name = "indicador_rel", insertable = false, updatable = false, nullable = false)
	private Indicador indicadorSerie;

}
