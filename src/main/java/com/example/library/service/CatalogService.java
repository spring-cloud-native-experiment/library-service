package com.example.library.service;

import com.example.library.client.CatalogServiceClient;
import com.example.library.domain.Catalog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogService {

    private CatalogServiceClient client;

    @Autowired
    public CatalogService(CatalogServiceClient client) {
        this.client = client;
    }

    public List<Catalog> fetchAllCatalogs() {
        return client.getAllCatalogs();
    }
}
