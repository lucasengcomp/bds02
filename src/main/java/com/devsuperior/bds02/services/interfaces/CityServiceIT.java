package com.devsuperior.bds02.services.interfaces;

import com.devsuperior.bds02.dto.CityDTO;

import java.util.List;

public interface CityServiceIT {

    List<CityDTO> findAllSortByNameCity();

    CityDTO insert(CityDTO dto);

    void delete(Long id);
}
