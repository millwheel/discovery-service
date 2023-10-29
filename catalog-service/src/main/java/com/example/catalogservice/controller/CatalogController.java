package com.example.catalogservice.controller;

import com.example.catalogservice.entity.CatalogEntity;
import com.example.catalogservice.service.CatalogService;
import com.example.catalogservice.vo.ResponseCatalog;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/catalog-service")
public class CatalogController {

    private final CatalogService catalogService;

    @Autowired
    public CatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @GetMapping("/health-check")
    public String healthCheck(){
        return "The Catalog service server is activated successfully.";
    }

    @GetMapping("/catalogs")
    @ResponseStatus(HttpStatus.OK)
    public List<ResponseCatalog> getCatalogs(){
        Iterable<CatalogEntity> allCatalogs = catalogService.getAllCatalogs();

        List<ResponseCatalog> catalogsList = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();
        allCatalogs.forEach(v -> catalogsList.add(modelMapper.map(v, ResponseCatalog.class)));

        return catalogsList;
    }
}
