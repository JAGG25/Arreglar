package com.umg.programacion2.model;

import java.util.Set;


import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int id;
    @Column(name = "email")
    @Email(message = "Debe ingresar un correo valido")
    @NotEmpty(message = "ingrese su correo")
    private String email;
    @Column(name = "password")
    @Length(min = 5, message = "La contraseña debe contener al menos 5 caracteres")
    @NotEmpty(message = "No ha ingresado una contraseña")
    private String password;
    @Column(name = "name")
    @NotEmpty(message = "Ingrese su nombre")
    private String name;
    @Column(name = "last_name")
    @NotEmpty(message = "Ingrese su apellido")
    private String lastName;
    @Column(name = "active")
    private int active;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;
    
    
	public User() {
		super();
	}
	
	public User(int id,
			@Email(message = "Debe ingresar un correo valido") @NotEmpty(message = "ingrese su correo") String email,
			@Length(min = 5, message = "La contraseña debe contener al menos 5 caracteres") @NotEmpty(message = "No ha ingresado una contraseña") String password,
			@NotEmpty(message = "Ingrese su nombre") String name,
			@NotEmpty(message = "Ingrese su apellido") String lastName, int active, Set<Role> roles) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.name = name;
		this.lastName = lastName;
		this.active = active;
		this.roles = roles;
	}








	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
    
    

}
