package com.mproduit.produitwebapp.controller;



import com.mproduit.produitwebapp.model.Produit;
import com.mproduit.produitwebapp.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@CrossOrigin("/**")
public class ProduitController {

    @Autowired
    private ProduitService produitService;


    @GetMapping("/")
    public String produit(Model model)
    {   Iterable<Produit> produits = produitService.getProduits();
        model.addAttribute("produits", produits);
        return "home";  }


    @RequestMapping(value = "/deleteProduits/{id}",
            method = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE})
    public String deleteProduits(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        produitService.daleteProduit(id);
        return "redirect:/";
    }

    @PostMapping("/saveProduit")
    public ModelAndView saveProduit(@ModelAttribute Produit produit, Model model) {
        model.addAttribute("produit", produit);
        produitService.saveProduit(produit);
        return new ModelAndView("redirect:/");
    }

    @GetMapping(value = "/updateProduit/{id}")
    public String updateProduit(@PathVariable("id") Long id, Model model) {
        Produit produit = produitService.getProduit(id);
        model.addAttribute("produit", produitService.updateProduit(produit));
        return "formEditProduit";
    }

    @GetMapping("/createProduit")
    public String createProduit(Produit produit, Model model){
        model.addAttribute("produit", produit);
        return "formAddProduit";
    }




}
