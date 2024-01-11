package com.mcommande.commandewebapp.controller;

import com.mcommande.commandewebapp.model.Commande;
import com.mcommande.commandewebapp.model.Produit;
import com.mcommande.commandewebapp.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@CrossOrigin("/**")
public class ProduitController {

    @Autowired
    private ProduitService produitService;

    @GetMapping("/produits")
    public String getAllProduits(Model model) {
        List<Produit> produits = produitService.getAllProduits();
        model.addAttribute("produits", produits);
        return "homeProduit";
    }

    @GetMapping("/deleteProduit/{id}")
    public String deleteProduit(@PathVariable("id") Long id) {
        produitService.deleteProduit(id);
        return "redirect:/produits";
    }

    @PostMapping("/saveProduit")
    public ModelAndView SaveProduit(@ModelAttribute Produit produit) {
        produitService.createProduit(produit);
        return new ModelAndView("redirect:/produits");
    }

    @GetMapping("/updateProduit/{id}")
    public String updateProduitForm(@PathVariable("id") Long id, Model model) {
        Produit produit = produitService.getProduitById(id);
        model.addAttribute("produit", produit);
        return "formEditProduit";
    }

    @PostMapping("/updatePrd")
    public String updateProduit(@ModelAttribute Produit produit) {
        produitService.updateProduit(produit.getId(), produit);
        return "redirect:/produits";
    }

    @GetMapping("/createProduit")
    public String createProduitForm(Model model) {
        model.addAttribute("produit", new Produit());
        return "formAddProduit";
    }
}
