package com.sesi.login.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity //cria uma tabela no banco de dados
public class Usuario {
	@Id //cria a id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idUsuario;
	@Column(nullable=false,unique=true) //caracteristicas da coluna
	private String nomeUsuario;
	@Column(nullable=false)
	private String senha;
	
	@ManyToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinTable(name="usuario_papeis",
	    joinColumns=@JoinColumn(name="usuario_id"),
	    inverseJoinColumns=@JoinColumn(name="papel_id"))
	
	private Set<Papel>papeis=new HashSet<>(); //Set é uma array q n pode repetir 
	
	
	public Usuario() {
	}
	
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
}