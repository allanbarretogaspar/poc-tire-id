package br.com.sascar.poc.tireid.dtos;

import java.util.HashSet;
import java.util.Set;

import br.com.sascar.poc.tireid.domain.enums.Perfil;

public class UsuarioDTO {

	private Long id;
	private String login;
	private String nome;
	private String email;
	private String senha;
	private boolean ativo;
	private Set<Perfil> perfis = new HashSet<>();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	public Set<Perfil> getPerfis() {
		return perfis;
	}
	public void setPerfis(Set<Perfil> perfis) {
		this.perfis = perfis;
	}
	
	

	
}
