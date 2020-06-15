package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="users")
@Getter
@Setter
@NoArgsConstructor
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="username", length=25, nullable=false)
	private String nombreUsuario;
	
	@Column(name="firstName", length=50, nullable=false)
	private String nombre;
	
	@Column(name="lastName", length=50, nullable=false)
	private String apellido;
	
	@Column(name="civilStatus")
	private String status;
	
	@Column(name="verified", nullable=false)
	private Boolean verificado;
	
	@Column(name="created_at", nullable=false)
	@Temporal(TemporalType.DATE)
	private Date fechaCreacion;
	
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	private List<Tarea> tareas;
}
