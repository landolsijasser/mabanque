package org.glsid.Metier;

import java.util.Date;
import java.util.Optional;

import org.glsid.dao.CompteRepository;
import org.glsid.entities.Compte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CompteMetierImpl implements CompteMetier {
//appeler la couche dao via l'interface repository
	@Autowired
	private CompteRepository compteRepository;
	
	@Override
	public Compte saveCompte(Compte cp) {
		// TODO Auto-generated method stub
		//ajouter la date system
		cp.setDateCreation(new Date());
		return compteRepository.save(cp);
	}

	@Override
	public Compte getCompte(String code) {
		// TODO Auto-generated method stub
		 return compteRepository.findById(code).get();
		

	}

}
