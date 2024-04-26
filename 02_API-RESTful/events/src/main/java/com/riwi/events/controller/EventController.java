package com.riwi.events.controller;

import com.riwi.events.entity.Evento;
import com.riwi.events.service.abstract_service.IEventService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/events")
public class EventController {

    @Autowired
    private final IEventService objIEventService;

    /*@GetMapping
    public ResponseEntity<List<Evento>> getAll(){
        return ResponseEntity.ok(this.objIEventService.getAll());
    }
*/
    @GetMapping(path = "/{id}")
    public ResponseEntity<Evento> get(@PathVariable String id){
        return ResponseEntity.ok(this.objIEventService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Evento> insert(@RequestBody Evento objEvent){
        ResponseEntity<Evento> objResponse = null;
        if(!LocalDate.now().isAfter(objEvent.getFecha())){
            if (objEvent.getCapacidad() < 0){
                objEvent.setCapacidad(0);
                objResponse = ResponseEntity.ok(this.objIEventService.save(objEvent));
            }else {
                objResponse = ResponseEntity.ok(this.objIEventService.save(objEvent));
            }
        }else {
            System.out.println("Invalid Date");
        }
        return objResponse;
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Evento> update(@RequestBody Evento objEvent, @PathVariable String id){
        objEvent.setId(id);
        ResponseEntity<Evento> objResponse = null;
        if(!LocalDate.now().isAfter(objEvent.getFecha())){
            if (objEvent.getCapacidad() < 0){
                objEvent.setCapacidad(0);
                objResponse = ResponseEntity.ok(this.objIEventService.update(objEvent));
            }else {
                objResponse = ResponseEntity.ok(this.objIEventService.update(objEvent));
            }
        }else {
            System.out.println("Invalid Date");
        }
        return objResponse;
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        this.objIEventService.delete(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public List<Evento> showViewEvents(@RequestParam(defaultValue = "1")int page, @RequestParam (defaultValue= "3")int size){
        Page<Evento> listEvents= this.objIEventService.findAllPaginate(page-1,size);
        return listEvents.getContent();

    }
}
