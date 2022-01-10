package org.glsid.Metier;

import java.util.List;

import org.glsid.dao.ClientRespository;
import org.glsid.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
@Service //on peut egalement utliser @Component
public class ClientMetierImpl implements ClientMetier{
	@Autowired //injecter la dependence , creer une implementation via autowired
private ClientRespository clientRepository;
	@Override
	public Client saveClient(Client c) {
		// TODO Auto-generated method stub
		return clientRepository.save(c);
	}

	@Override
	public List<Client> listClient() {
		// TODO Auto-generated method stub
		return clientRepository.findAll();
	}

	

}
