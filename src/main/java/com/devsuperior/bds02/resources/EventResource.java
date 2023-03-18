package com.devsuperior.bds02.resources;


import com.devsuperior.bds02.dto.EventDTO;
import com.devsuperior.bds02.services.interfaces.EventServiceIT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/event")
public class EventResource {

    @Autowired
    private EventServiceIT service;

    @PutMapping(value = "/{id}")
    public ResponseEntity<EventDTO> update(@PathVariable Long id,@RequestBody EventDTO dto){
        dto = service.update(id, dto);
        return ResponseEntity.ok().body(dto);
    }
}
