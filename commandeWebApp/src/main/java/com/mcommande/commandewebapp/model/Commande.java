package com.mcommande.commandewebapp.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class Commande {

    private Long      id;
    private String    description;
    private Integer   quantité;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    private Double    montant;
    private Long idProduct;


}
