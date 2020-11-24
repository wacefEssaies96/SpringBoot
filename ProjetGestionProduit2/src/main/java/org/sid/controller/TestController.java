package org.sid.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.sid.entities.*;
import org.sid.metier.IProduitMetier;

import java.util.List;
import java.util.Optional;

import org.sid.dao.*;
@Controller
public class TestController {
	@Autowired
	private IProduitMetier service;
	
		@RequestMapping("/")
	    public String index(Model model) {
			List<Produit>produits = (List<Produit>) service.consulterListProduit();
			model.addAttribute("produits",produits);
	        return "NewFile.html";
	    }
		
		@RequestMapping("/new")
		public String newProduct(Model model) {
			Produit p = new Produit();
			model.addAttribute("produit",p);
			return "addProduit";
		}
		
		@PostMapping("/add")
		public String addProduct(Produit p) {
			service.saveProduit(p);
			return "redirect:/";
		}
		
		@GetMapping("/edit/{id}")
		public ModelAndView editProduct(@PathVariable("id") long id) {
			ModelAndView mv = new ModelAndView("editProduit");
			mv.addObject("produit",service.findProduitById(id));
			return mv;
		}
		@RequestMapping("/update")
		public String updateProduit(Produit p) {
			service.updateProduit(p.getId(), p);
			return "redirect:/";
		}
		@RequestMapping("/delete/{id}")
		public String deleteProduit(@PathVariable("id") long id) {
			service.deleteProduit(id);
			return "redirect:/";
		}
		
	
}
