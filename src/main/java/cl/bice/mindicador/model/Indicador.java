package cl.bice.mindicador.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "indicador")
@ToString(of = { "idIndicador", "version", "autor", "codigo", "nombre", "unidad_medida" })
@Data
public class Indicador implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Type(type = "pg-uuid")
	@GenericGenerator(name = "uuid-gen", strategy = "uuid2")
	@GeneratedValue(generator = "uuid-gen")
	@Column(name = "id_indicador")
	private UUID idIndicador;
	
	@Column(nullable = false, name = "version")
	private String version;
	
	@Column(nullable = false, name = "autor")
	private String autor;
	
	@Column(nullable = false, name = "codigo")
	private String codigo;
	
	@Column(nullable = false, name = "nombre")
	private String nombre;

	@Column(nullable = false, name = "unidad_medida")
	private String unidad_medida;
	
	@Column(nullable = false, name = "fecha")
	private String fecha;
	
	@OneToMany(mappedBy = "indicadorSerie")
	@JsonIgnore
	private List<Serie> serie = new ArrayList<Serie>();
	
}
