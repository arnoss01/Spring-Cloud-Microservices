package com.mcommande.commandewebapp.repository;


import com.mcommande.commandewebapp.model.Commande;
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
public class CommandeProxy {


    private String props = "http://localhost:9201";




    public Iterable<Commande> getCommandes() {
        String baseApiUrl = props;
        String getEmployeesUrl = baseApiUrl + "/api/v1/commande";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<Commande>> response =
                restTemplate.exchange(
                        getEmployeesUrl,
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<Iterable<Commande>>() {} );
        return response.getBody();
    }

    public Commande getCommande(Long id) {
        String baseApiUrl = props;
        String getEmployeeUrl = baseApiUrl + "/api/v1/commande/" + id;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Commande> response =
                restTemplate.exchange(
                        getEmployeeUrl,
                        HttpMethod.GET,
                        null,
                        Commande.class  );
        return response.getBody();
    }


    public void deleteCommande(Long id) {
        String baseApiUrl = props;
        String deleteEmployeeUrl = baseApiUrl + "/api/v1/commande/" + id;

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(deleteEmployeeUrl);
    }

    public Commande createCommande(Commande commande) {
        String baseApiUrl = props;
        String createEmployeeUrl = baseApiUrl + "/api/v1/commande";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Commande> response =
                restTemplate.postForEntity(createEmployeeUrl, commande, Commande.class);

        return response.getBody();
    }


    public Commande updateCommande(Commande commande) {
        String baseApiUrl = props;
        String updateCommandeUrl = baseApiUrl + "/api/v1/commande/" + commande.getId();

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.put(updateCommandeUrl, commande);

        return commande;
    }








}

