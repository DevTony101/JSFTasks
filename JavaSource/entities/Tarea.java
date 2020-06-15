package entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="tasks")
@Getter
@Setter
@NoArgsConstructor
public class Tarea implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="title", length=25, nullable=false)
	private String titulo;
	
	@Column(name="description", length=100)
	private String descripcion;
	
	@Column(name="completed", nullable=false)
	private Boolean completada;
	
	@Column(name="deadlineDate", nullable=false)
	@Temporal(TemporalType.DATE)
	private Date fechaFinal;
	
	@ManyToOne
	@JoinColumn(name="usuario")
	private Usuario usuario;

}
