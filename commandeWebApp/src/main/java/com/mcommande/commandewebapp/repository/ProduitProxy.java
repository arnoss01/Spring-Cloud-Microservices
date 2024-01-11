package com.mcommande.commandewebapp.repository;


import com.mcommande.commandewebapp.model.Produit;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "microservice-produits", url = "http://localhost:9004/microservice-produits/products")
public interface ProduitProxy {

    @GetMapping()
    List<Produit> getAllProduits();

    @GetMapping("/{id}")
    Produit getProduitById(@PathVariable Long id);

    @PostMapping()
    Produit createProduit(@RequestBody Produit produit);

    @PutMapping("/{id}")
    Produit updateProduit(@PathVariable Long id, @RequestBody Produit produit);

    @DeleteMapping("/{id}")
    void deleteProduit(@PathVariable Long id);
}
