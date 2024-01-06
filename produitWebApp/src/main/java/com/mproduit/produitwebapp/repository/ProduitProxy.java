package com.mproduit.produitwebapp.repository;


import com.mproduit.produitwebapp.model.Produit;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Data
@Component
public class ProduitProxy {


    private String props = "http://localhost:9201";




    public Iterable<Produit> getProduits() {
        String baseApiUrl = props;
        String getEmployeesUrl = baseApiUrl + "/api/v1/produit";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<Produit>> response =
                restTemplate.exchange(
                        getEmployeesUrl,
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<Iterable<Produit>>() {} );
        return response.getBody();
    }

    public Produit getProduit(Long id) {
        String baseApiUrl = props;
        String getEmployeeUrl = baseApiUrl + "/api/v1/produit/" + id;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Produit> response =
                restTemplate.exchange(
                        getEmployeeUrl,
                        HttpMethod.GET,
                        null,
                        Produit.class  );
        return response.getBody();
    }


    public void deleteProduit(Long id) {
        String baseApiUrl = props;
        String deleteEmployeeUrl = baseApiUrl + "/api/v1/Produit/" + id;

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(deleteEmployeeUrl);
    }

    public Produit createProduit(Produit produit) {
        String baseApiUrl = props;
        String createEmployeeUrl = baseApiUrl + "/api/v1/produit";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Produit> response =
                restTemplate.postForEntity(createEmployeeUrl, produit, Produit.class);

        return response.getBody();
    }


    public Produit updateProduit(Produit produit) {
        String baseApiUrl = props;
        String updateProduitUrl = baseApiUrl + "/api/v1/Produit/" + produit.getId();

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.put(updateProduitUrl, produit);

        return produit;
    }








}

