package com.devsuperior.bds02.services.interfaces;

import com.devsuperior.bds02.dto.EventDTO;

public interface EventServiceIT {
    EventDTO update(Long id, EventDTO dto);
}
