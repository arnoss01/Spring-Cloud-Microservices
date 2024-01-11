package com.mcommande.commandewebapp.repository;


import com.mcommande.commandewebapp.model.Commande;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import java.util.List;



@FeignClient(name = "microservice-commandes", url = "localhost:9004/microservice-commande/api/v1/commande")
public interface CommandeProxy {

    @GetMapping()
    List<Commande> getAllCommandes();

    @GetMapping("/{id}")
    Commande getCommandeById(@PathVariable("id") Long id);

    @PostMapping()
    Commande createCommande(@RequestBody Commande commande);

    @PutMapping("/{id}")
    Commande updateCommande(@PathVariable("id") Long id, @RequestBody Commande commande);

    @DeleteMapping("/{id}")
    void deleteCommande(@PathVariable("id") Long id);
}
