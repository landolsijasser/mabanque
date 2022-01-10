package org.glsid.Metier;

import org.glsid.entities.Compte;

public interface CompteMetier {
public Compte saveCompte(Compte cp);
public Compte getCompte(String code);
}
