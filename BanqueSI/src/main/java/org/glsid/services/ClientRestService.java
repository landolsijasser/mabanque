package org.glsid.services;

import java.util.List;

import org.glsid.Metier.ClientMetier;
import org.glsid.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
//microservice
@RestController
public class ClientRestService {
@Autowired
	private ClientMetier clientMetier;
//generer les methode via les delegueted methods : generer les methodes qui se trouvent dans les interfaces composées
@RequestMapping(value ="/clients", method = RequestMethod.POST)
public Client saveClient(@RequestBody Client  c) {
	return clientMetier.saveClient(c);
}
@RequestMapping(value ="/clients", method = RequestMethod.GET) 
public List<Client> listClient() {
	return clientMetier.listClient();
}
}
