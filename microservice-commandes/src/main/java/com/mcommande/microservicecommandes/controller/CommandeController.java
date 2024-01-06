package com.mcommande.microservicecommandes.controller;


import com.mcommande.microservicecommandes.configurations.ApplicationPropertiesConfigurations;
import com.mcommande.microservicecommandes.dao.CommandeDao;
import com.mcommande.microservicecommandes.exception.CommandeAlreadyExist;
import com.mcommande.microservicecommandes.exception.CommandeNotFoundException;
import com.mcommande.microservicecommandes.model.Commande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/commande")
public class CommandeController implements HealthIndicator {

    @Autowired
    CommandeDao dao;
    @Autowired
    ApplicationPropertiesConfigurations propertiesConfigurations;   
    
    @GetMapping
    public List<Commande> findAll()
    {
        List<Commande> commandes = dao.findAll();
        if(commandes.isEmpty())
            return commandes.subList(0,0);
        Collections.sort(commandes);
        System.out.println(propertiesConfigurations.getCommandeslast());
        return commandes.subList(0,Math.min(commandes.size() ,propertiesConfigurations.getCommandeslast()));
    }



    @GetMapping("/{id}")
    public Optional<Commande> findById(@PathVariable long id)
    {
        Optional<Commande> commande = dao.findById(id);
        if(commande.isEmpty())
            throw new CommandeNotFoundException("Commande with ID "+ id+" does not exist");

        return commande;
    }

    @PostMapping
    public Commande save( @RequestBody Commande commande)
    {
        if (commande.getId() != null) {
            Optional<Commande> cmd = dao.findById(commande.getId());

            if (cmd.isPresent())
                throw new CommandeAlreadyExist("Commande with ID " + commande.getId() + " already exist");
        }

        return dao.save(commande);
    }


    @DeleteMapping("{id}")
    public String delete(@PathVariable long id)
    {
        Optional<Commande> commande = dao.findById(id);
        if(commande.isEmpty())
            throw new CommandeNotFoundException("");
        dao.deleteById(id);
        return "Deleted !";
    }


    @PutMapping("{id}")
    public Commande update(@PathVariable long id , @RequestBody Commande commande)
    {
        Optional<Commande> updatedCommande = dao.findById(id);

        if(updatedCommande.isEmpty())
            throw new CommandeNotFoundException("Commande with ID "+commande.getId()+" already exist");

        commande.setId(id);

        return dao.save(commande);
    }


    @Override
    public Health health() {
        List<Commande> commandes = dao.findAll();
        if (commandes.isEmpty()) {
            return Health.down().build();
        }
        return Health.up().build();
    }
}
