package com.devsuperior.bds02.services.impl;

import com.devsuperior.bds02.dto.CityDTO;
import com.devsuperior.bds02.entities.City;
import com.devsuperior.bds02.repositories.CityRepository;
import com.devsuperior.bds02.services.exceptions.DatabaseException;
import com.devsuperior.bds02.services.exceptions.ResourceNotFoundException;
import com.devsuperior.bds02.services.interfaces.CityServiceIT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static com.devsuperior.bds02.resources.exceptions.Utils.ID_NOT_FOUND;
import static com.devsuperior.bds02.resources.exceptions.Utils.INTEGRITY_VIOLATION;


@Service
public class CityServiceImpl implements CityServiceIT {

    @Autowired
    private CityRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<CityDTO> findAllSortByNameCity() {
        List<City> list = repository.findAll(Sort.by("name"));
        return list.stream().map(CityDTO::new).collect(Collectors.toList());
    }
}
