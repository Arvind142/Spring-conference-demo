package com.personal.conferencedemo.controller;


import com.personal.conferencedemo.model.Session;
import com.personal.conferencedemo.repository.SessionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/api/v1/session")
public class SessionController {

    @Autowired
    private SessionRepository sessionRepository;

    @GetMapping
    public List<Session> list(){
        return sessionRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Optional<Session> get(@PathVariable  Long id){
        return sessionRepository.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Session post(@RequestBody final Session session){
        return sessionRepository.saveAndFlush(session);
    }

    @RequestMapping(value="{id}",method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Session put(@PathVariable Long id, @RequestBody final Session session){
        Session existingSession = sessionRepository.getReferenceById(id);
        BeanUtils.copyProperties(session,existingSession);
        return sessionRepository.saveAndFlush(existingSession);
    }



    @RequestMapping(value="{id}",method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void delete(@PathVariable Long id){
       sessionRepository.deleteById(id);
    }
}
