package com.residencia.atividadeAPI.dto;

import java.util.HashSet;
import java.util.Set;

import com.residencia.atividadeAPI.entities.Role;

public class UserResumidoDTO {
	
	private Integer id;	
	private String username;	
	private String email;	
	private Set<Role> roles = new HashSet<>();
	
	public UserResumidoDTO() {
		super();
	}

	public UserResumidoDTO(Integer id, String username, String email, String password, Set<Role> roles) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;		
		this.roles = roles;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}	
}
