package com.riwi.events.service.abstract_service;

import com.riwi.events.entity.Evento;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IEventService {
    public Evento save(Evento objEvento);
    public List<Evento> getAll();
    public Evento getById(String id);
    public Page<Evento> findAllPaginate(int page, int size);
    public void delete(String id);
    public Evento update(Evento objEvento);



}
