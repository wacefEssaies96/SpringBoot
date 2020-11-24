package org.sid.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.sid.dao.IProduitRepository;
import org.sid.entities.Produit;
import org.sid.metier.IProduitMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProduitRestService {
	  @Autowired
	  private IProduitMetier produitMetier;
	
	

	@RequestMapping(value="/produits",method = RequestMethod.POST)
	public Produit saveProduit(@RequestBody Produit p)
	    {
	       return produitMetier.saveProduit(p);
		 }
	
	@RequestMapping(value="/produits",method = RequestMethod.GET)
	public Collection <Produit> getProduits()
	{
	return produitMetier.consulterListProduit();
	}
	
	
	@RequestMapping(value="/produits/{id}",method = RequestMethod.GET)
    public Optional<Produit> findProduitById(@PathVariable Long id) {
		return produitMetier.findProduitById(id);
	}
	
	
	@RequestMapping(value="/produits/{id}",method = RequestMethod.DELETE)
	@ResponseBody
    public void delete(@PathVariable Long id)
     {
		produitMetier.deleteProduit(id);
     }
	
	
	
@RequestMapping(value="/produitsBydesignation",method = RequestMethod.GET) 
public Page<Produit> FindProduitByDesignation(@RequestParam String designation, 
				                                      @RequestParam int page, 
				                                      @RequestParam int size) {
			return produitMetier.FindProduitByDesignation(designation,page,size);
	
}
	
@RequestMapping(value="/produits/{id}",method = RequestMethod.PUT)
public ResponseEntity<Produit> updateProduit(@PathVariable Long id,
		 @RequestBody Produit produit) 
{

return
      ResponseEntity.ok(produitMetier.updateProduit(id, produit));
}
	

	

}
