package com.example.catalog;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("catalog-service")
public interface CatalogServiceClient {

    @RequestMapping(method = RequestMethod.GET, value = "/catalog")
    List<Catalog> getAllCatalogs();
}
