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


    @GetMapping("/")
    public String commande(Model model)
    {   Iterable<Commande> commandes = commandeService.getCommandes();
        model.addAttribute("commandes", commandes);
        return "home";  }


    @RequestMapping(value = "/deleteCommande/{id}",
            method = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE})
    public String deleteCommande(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        commandeService.daleteCommande(id);
        return "redirect:/";
    }

    @PostMapping("/saveCommande")
    public ModelAndView saveCommande(@ModelAttribute Commande commande, Model model) {
        model.addAttribute("commande", commande);
        commandeService.saveCommande(commande);
        return new ModelAndView("redirect:/");
    }

    @GetMapping(value = "/updateCommande/{id}")
    public String updateCommande(@PathVariable("id") Long id, Model model) {
        Commande commande = commandeService.getCommande(id);
        model.addAttribute("commande", commandeService.updateCommande(commande));
        return "formEditCommande";
    }

    @GetMapping("/createCommande")
    public String createCommande(Commande commande, Model model){
        model.addAttribute("commande", commande);
        return "formAddCommande";
    }




}
