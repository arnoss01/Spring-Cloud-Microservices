package com.mcommande.commandewebapp.service;

import com.mcommande.commandewebapp.model.Commande;
import com.mcommande.commandewebapp.repository.CommandeProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CommandeService {


    @Autowired
    private CommandeProxy commandeProxy;



    public List<Commande> getAllCommandes() {
        return commandeProxy.getAllCommandes();
    }

    public Commande getCommandeById(Long id) {
        return commandeProxy.getCommandeById(id);
    }

    public void createCommande(Commande commande) {
        commandeProxy.createCommande(commande);
    }

    public void updateCommande(Long id, Commande commande) {
        commandeProxy.updateCommande(id, commande);
    }

    public void deleteCommande(Long id) {
        commandeProxy.deleteCommande(id);
    }



}
