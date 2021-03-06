package org.glsid.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Client implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long codeClient;
private String nomClient;
@OneToMany(mappedBy ="client", fetch=FetchType.LAZY)
private Collection<Compte> comptes;

public Long getCodeClient() {
	return codeClient;
}
public void setCodeClient(Long codeClient) {
	this.codeClient = codeClient;
}
public String getNomClient() {
	return nomClient;
}
public void setNomClient(String nomClient) {
	this.nomClient = nomClient;
}
@JsonIgnore
public Collection<Compte> getComptes() {
	return comptes;
}
public void setComptes(Collection<Compte> comptes) {
	this.comptes = comptes;
}
public Client() {
	super();
}
public Client(String nomClient) {
	super();
	this.nomClient = nomClient;
}
	
}
