package org.primefaces.showcase.domain;
 
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
 
public class User implements Serializable {

	private static List<String> roles;
	private String nome;
	private String apelido;
	private String email;
	private String senha;
	private HashMap<String, String> infoDoc;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getApelido() {
		return apelido;
	}
	public void setApelido(String apelido) {
		this.apelido = apelido;
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
	public List<String> getRoles() {
		return roles;
	}
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	public HashMap<String, String> getInfoDoc() {
		return infoDoc;
	}
	public void setInfoDoc(HashMap<String, String> infoDoc) {
		this.infoDoc = infoDoc;
	}
	
	public void addInfoDoc(String documento, String info) {
		infoDoc.put(documento, info);
	}
	
	
}