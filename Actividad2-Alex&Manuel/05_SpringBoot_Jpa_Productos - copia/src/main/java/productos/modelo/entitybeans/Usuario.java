package productos.modelo.entitybeans;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
/*
 * Lombook
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
/*
 * entidades anotadas jpa
 */
@Entity
@Table(name="usuarios")

public class Usuario implements Serializable{
	
	/**
	 * identificador  serialización
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private String username;
	private String password;
	private String nombre;
	private String apellidos;
	@Column(name="created_at")
	@Temporal(TemporalType.DATE)
	private Date createdAt;
	private int enabled;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public int getEnabled() {
		return enabled;
	}
	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
