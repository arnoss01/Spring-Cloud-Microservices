package com.mcommande.commandewebapp.service;

import com.mcommande.commandewebapp.model.Produit;
import com.mcommande.commandewebapp.repository.ProduitProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitService {

    private final ProduitProxy produitProxy;

    @Autowired
    public ProduitService(ProduitProxy produitProxy) {
        this.produitProxy = produitProxy;
    }

    public List<Produit> getAllProduits() {
        return produitProxy.getAllProduits();
    }

    public Produit getProduitById(Long id) {
        return produitProxy.getProduitById(id);
    }

    public void createProduit(Produit produit) {
        produitProxy.createProduit(produit);
    }

    public void updateProduit(Long id, Produit produit) {
        produitProxy.updateProduit(id, produit);
    }

    public void deleteProduit(Long id) {
        produitProxy.deleteProduit(id);
    }
}