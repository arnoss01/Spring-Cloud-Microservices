package com.mproduit.produitwebapp.service;

import com.mproduit.produitwebapp.model.Produit;
import com.mproduit.produitwebapp.repository.ProduitProxy;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class ProduitService {


    @Autowired
    private ProduitProxy produitProxy;



    public Produit getProduit(final Long id){ return produitProxy.getProduit(id);}

    public Iterable<Produit> getProduits(){ return produitProxy.getProduits();}

    public void daleteProduit(final Long id)
    {
        produitProxy.deleteProduit(id);
    }


    public Produit saveProduit(Produit produit)
    {
        Produit savedProduit;
       savedProduit =  (produit.getId() == null)? produitProxy.createProduit(produit) : produitProxy.updateProduit(produit);

        return savedProduit;

    }

    public Produit updateProduit(Produit produit) {return produitProxy.updateProduit(produit);}





}
