package com.mcommande.microservicecommandes.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class Commande implements Comparable<Commande>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Integer quantité;
    private LocalDate date;
    private Double montant;
    private Long idProduit;

    @Override
    public int compareTo(Commande o) {
        return date.compareTo(o.date);
    }
}
