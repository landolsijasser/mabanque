package org.glsid.Metier;

import java.util.Date;

import org.glsid.dao.CompteRepository;
import org.glsid.dao.EmployeRepository;
import org.glsid.dao.OperationRepository;
import org.glsid.entities.Compte;
import org.glsid.entities.Employe;
import org.glsid.entities.Operation;
import org.glsid.entities.Retrait;
import org.glsid.entities.Versement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OperationMetierImpl implements OperationMetier {
	@Autowired
	private OperationRepository operationRepository; // gerer les operations
	@Autowired
	private CompteRepository compteRepository; // pour gerer les comptes

	@Autowired
	private EmployeRepository employeRepository;

	@Override
	@Transactional // on va faire une transaction
	public boolean verser(String code, double montant, Long codeEmp) {
		Compte cp = compteRepository.findById(code).get();
		Employe e = employeRepository.findById(codeEmp).get();
		Operation o = new Versement();
		o.setDateOperation(new Date());
		o.setMontant(montant);
		o.setCompte(cp);
		o.setEmploye(e);
		operationRepository.save(o);
		cp.setSolde(cp.getSolde() + montant);
		return true;
	}

	@Override
	@Transactional
	public boolean retirer(String code, double montant, Long codeEmp) {
		Compte cp = compteRepository.findById(code).get();
		if (cp.getSolde() < montant)
			throw new RuntimeException("solde insufisant");
		Employe e = employeRepository.findById(codeEmp).get();
		Operation o = new Retrait();
		o.setDateOperation(new Date());
		o.setMontant(montant);
		o.setCompte(cp);
		o.setEmploye(e);
		operationRepository.save(o);
		cp.setSolde(cp.getSolde() - montant);
		return true;
	}

	@Override
	@Transactional
	public boolean virement(String cpte1, String cpte2, double montant, Long codeEmp) {
		retirer(cpte1, montant, codeEmp);
		verser(cpte2, montant, codeEmp);
		return true;
	}

	@Override
	public pageOperation getOperations(String codeCompte, int page, int size) {
		Page<Operation> ops = operationRepository.getOperations(codeCompte, PageRequest.of(page, size));
		pageOperation pOp = new pageOperation();
		pOp.setOperations(ops.getContent());
		pOp.setNombreOperations(ops.getNumberOfElements());
		pOp.setPage(ops.getNumber());
		pOp.setTotalOperations((int) ops.getTotalElements());
		pOp.setTotalPages(ops.getTotalPages());
		return pOp;

	}

}
