package com.mcommande.commandewebapp.controller;


import com.mcommande.commandewebapp.model.Commande;
import com.mcommande.commandewebapp.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@CrossOrigin("/**")
public class CommandeController {

    @Autowired
    private CommandeService commandeService;


    @GetMapping()
    public String getAllCommandes(Model model) {
        Iterable<Commande> commandes = commandeService.getAllCommandes();
        model.addAttribute("commandes", commandes);
        return "homeCommande";
    }

    @GetMapping("/deleteCommande/{id}")
    public String deleteCommande(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        commandeService.deleteCommande(id);
        return "redirect:/";
    }

    @PostMapping("/saveCommande")
    public ModelAndView saveCommande(@ModelAttribute Commande commande) {
        commandeService.createCommande(commande);
        return new ModelAndView("redirect:/");
    }

    @GetMapping("/updateCommande/{id}")
    public String updateCommandeForm(@PathVariable("id") Long id, Model model) {
        Commande commande = commandeService.getCommandeById(id);
        model.addAttribute("commande", commande);
        return "formEditCommande";
    }

    @PostMapping("/updateCommande/{id}")
    public String updateCommande(@PathVariable("id") Long id, @ModelAttribute Commande commande) {
        commandeService.updateCommande(id, commande);
        return "redirect:/";
    }

    @GetMapping("/createCommande")
    public String createCommandeForm(Model model) {
        model.addAttribute("commande", new Commande());
        return "formAddCommande";
    }






}
