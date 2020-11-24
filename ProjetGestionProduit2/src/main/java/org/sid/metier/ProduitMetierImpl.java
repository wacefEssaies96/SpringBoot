package org.sid.metier;

import java.util.Collection;
import java.util.Optional;

import org.sid.dao.IProduitRepository;
import org.sid.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ProduitMetierImpl implements IProduitMetier {

	@Autowired
	IProduitRepository produitRepository;
	
	
	@Override
	public Produit saveProduit(Produit p) {
		// TODO Auto-generated method stub
		return  produitRepository.save(p);
	}

	@Override
	public Collection<Produit> consulterListProduit() {
		
		return produitRepository.findAll();
	}

	@Override
	public Optional<Produit> findProduitById(Long id) {
		
		return produitRepository.findById(id);
	}


	@Override
	public Produit updateProduit(Long id, Produit p) {
		Produit prod = produitRepository.findById(id).
				orElseThrow(() -> new RuntimeException("Produit introuvable avec id : : " +id));
		prod.setDesignation(p.getDesignation());
		prod.setPrix(p.getPrix());
		final Produit updatedProduit =  produitRepository.save(prod); 
		return updatedProduit;
		
	}

	@Override
	public void deleteProduit(Long id) {
		produitRepository.deleteById(id);
		
	}

	@Override
	public Page<Produit> FindProduitByDesignation(String designation, int page, int size) {
		
		return produitRepository.findProduitByDesignation(designation,PageRequest.of(page, size));
	}

}
