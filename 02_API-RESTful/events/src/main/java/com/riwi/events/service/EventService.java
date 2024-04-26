package com.riwi.events.service;

import com.riwi.events.entity.Evento;
import com.riwi.events.repository.EventRepository;
import com.riwi.events.service.abstract_service.IEventService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EventService implements IEventService {

    @Autowired
    private final EventRepository objEventRepository;

    @Override
    public Evento save(Evento objEvento) {
        return this.objEventRepository.save(objEvento);
    }

    @Override
    public List<Evento> getAll() {
        return this.objEventRepository.findAll();
    }

    @Override
    public Evento getById(String id) {
        return this.objEventRepository.findById(id).orElseThrow();
    }

    @Override
    public Page<Evento> findAllPaginate(int page, int size) {
        if (page<0){
            page =1;
        }
        Pageable objPage = PageRequest.of(page,size);
        return this.objEventRepository.findAll(objPage);
    }

    @Override
    public void delete(String id) {
        var product = this.objEventRepository.findById(id).orElseThrow();

        this.objEventRepository.delete(product);
    }

    @Override
    public Evento update(Evento objEvento) {
        return this.objEventRepository.save(objEvento);
    }
}
