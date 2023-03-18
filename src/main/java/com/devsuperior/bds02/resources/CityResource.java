package com.devsuperior.bds02.resources;


import com.devsuperior.bds02.dto.CityDTO;
import com.devsuperior.bds02.services.interfaces.CityServiceIT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/cities")
public class CityResource {

    @Autowired
    private CityServiceIT service;

    @GetMapping
    public ResponseEntity<List<CityDTO>> findAllSortByNameCity() {
        List<CityDTO> list = service.findAllSortByNameCity();
        return ResponseEntity.ok().body(list);
    }
}
