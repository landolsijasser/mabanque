package org.glsid.services;

import java.util.List;

import org.glsid.Metier.EmployeMetier;
import org.glsid.entities.Employe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeRestService {
// on fait apple a la couche metier 
	@Autowired
	private EmployeMetier employeMetier;
@RequestMapping(value="/employes", method = RequestMethod.POST)
	public Employe saveEmploye(@RequestBody Employe e) {
		return employeMetier.saveEmploye(e);
	}
@RequestMapping(value="/employes", method = RequestMethod.GET)
	public List<Employe> listEmployes() {
		return employeMetier.listEmployes();
	}
	

}
