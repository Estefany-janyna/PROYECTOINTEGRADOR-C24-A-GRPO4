package com.tecsup.RegisterReserva.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="usuarios")
public class User {
	@Id
	@Column(name="user_id",length = 45)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int user;
	
	@Column(name="nombres",length = 255)
	private String nombres;
	
	@Column(name="apellidos",length = 255)
	private String apellidos;
	
	@Column(name="dni",length = 8)
	private String dni;
	
	@Column(name="carrera",length = 255)
	private String carrera;
	
	@Column(name="ciclo",length = 25)
	private String ciclo;
	
	@Column(name="telefono",length = 9)
	private String telefono;
	
	@Column(name="email",length = 255)
	private String email;
	
	@Column(name="password", length = 255)
	private String password;


	public User(int user, String nombres, String apellidos, String dni, String carrera, String ciclo, String telefono,
			String email, String password) {
		super();
		this.user = user;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.dni = dni;
		this.carrera = carrera;
		this.ciclo = ciclo;
		this.telefono = telefono;
		this.email = email;
		this.password = password;
	}

	public User() {
		
	}

	
	public int getUser() {
		return user;
	}

	public void setUser(int user) {
		this.user = user;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public String getCiclo() {
		return ciclo;
	}

	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [user=" + user + ", nombres=" + nombres + ", apellidos=" + apellidos + ", dni=" + dni
				+ ", carrera=" + carrera + ", ciclo=" + ciclo + ", telefono=" + telefono + ", email=" + email
				+ ", password=" + password + "]";
	}

}
