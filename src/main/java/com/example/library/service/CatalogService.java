package com.example.library.service;

import com.example.library.domain.Catalog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CatalogService {

    private RestTemplate restTemplate;

    @Autowired
    public CatalogService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Catalog> fetchAllCatalogs() {
        ResponseEntity<List<Catalog>> rateResponse =
                restTemplate.exchange("http://localhost:8080/catalog",
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<Catalog>>() {
                        });
        return rateResponse.getBody();
    }
}
