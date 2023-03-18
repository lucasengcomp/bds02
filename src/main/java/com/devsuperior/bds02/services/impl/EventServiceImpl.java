package com.devsuperior.bds02.services.impl;

import com.devsuperior.bds02.dto.EventDTO;
import com.devsuperior.bds02.entities.Event;
import com.devsuperior.bds02.repositories.CityRepository;
import com.devsuperior.bds02.repositories.EventRepository;
import com.devsuperior.bds02.services.exceptions.ResourceNotFoundException;
import com.devsuperior.bds02.services.interfaces.EventServiceIT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

import static com.devsuperior.bds02.exceptions.Utils.ID_NOT_FOUND;

@Service
public class EventServiceImpl implements EventServiceIT {

    @Autowired
    private EventRepository repository;

    @Autowired
    private CityRepository cityRepository;

    @Override
    @Transactional
    public EventDTO update(Long id, EventDTO dto) {
        try {
            Event entity = repository.getOne(id);

            objectsEvents(dto, entity);

            entity = repository.save(entity);
            return new EventDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(ID_NOT_FOUND + id);
        }
    }

    private void objectsEvents(EventDTO dto, Event entity) {
        entity.setName(dto.getName());
        entity.setDate(dto.getDate());
        entity.setUrl(dto.getUrl());
        setCity(dto, entity);
    }

    private void setCity(EventDTO dto, Event entity) {
        entity.setCity(cityRepository.getOne(dto.getCityId()));
    }
}
