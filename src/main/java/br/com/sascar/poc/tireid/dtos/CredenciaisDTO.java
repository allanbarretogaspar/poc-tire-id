package br.com.sascar.poc.tireid.dtos;

import java.io.Serializable;

public class CredenciaisDTO implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5049702927226962857L;
	
	private String login;
	private String senha;
	
	public CredenciaisDTO() {
		
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
	

}
