package org.sid.metier;

import java.util.Collection;
import java.util.Optional;

import org.sid.entities.Produit;
import org.springframework.data.domain.Page;



public interface IProduitMetier 
{
	public Produit saveProduit(Produit p);
	public Collection<Produit> consulterListProduit();
	public Optional<Produit> findProduitById(Long id);
	public Produit updateProduit(Long id,Produit p);
	public void deleteProduit(Long id);
	
	public Page <Produit> FindProduitByDesignation
	(String designation, int page, int size);
}
