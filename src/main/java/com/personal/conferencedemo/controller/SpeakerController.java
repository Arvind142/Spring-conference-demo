package com.personal.conferencedemo.controller;

import com.personal.conferencedemo.model.Speaker;
import com.personal.conferencedemo.repository.SpeakerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/api/v1/speaker")
public class SpeakerController {

    @Autowired
    private SpeakerRepository speakerRepository;

    @GetMapping
    public List<Speaker> list(){
        return speakerRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Optional<Speaker> get(@PathVariable  Long id){
        return speakerRepository.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Speaker post(@RequestBody final Speaker speaker){
        return speakerRepository.saveAndFlush(speaker);
    }

    @RequestMapping(value="{id}",method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Speaker put(@PathVariable Long id, @RequestBody final Speaker speaker){
        Speaker existingSpeaker = speakerRepository.getReferenceById(id);
        BeanUtils.copyProperties(speaker,existingSpeaker);
        return speakerRepository.saveAndFlush(existingSpeaker);
    }

    @RequestMapping(value="{id}",method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void delete(@PathVariable Long id){
       speakerRepository.deleteById(id);
    }
}
