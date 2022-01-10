package org.glsid.Metier;

import java.util.List;

import org.glsid.entities.Employe;

public interface EmployeMetier {
public Employe saveEmploye(Employe e);
public List<Employe> listEmployes();
}
