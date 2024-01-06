package com.mcommande.commandewebapp.service;

import com.mcommande.commandewebapp.model.Commande;
import com.mcommande.commandewebapp.repository.CommandeProxy;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class CommandeService {


    @Autowired
    private CommandeProxy commandeProxy;



    public Commande getCommande(final Long id){ return commandeProxy.getCommande(id);}

    public Iterable<Commande> getCommandes(){ return commandeProxy.getCommandes();}

    public void daleteCommande(final Long id)
    {
        commandeProxy.deleteCommande(id);
    }


    public Commande saveCommande(Commande commande)
    {
        Commande savedCommande;
       savedCommande =  (commande.getId() == null)? commandeProxy.createCommande(commande) : commandeProxy.updateCommande(commande);

        return savedCommande;

    }

    public Commande updateCommande(Commande commande) {return commandeProxy.updateCommande(commande);}





}
