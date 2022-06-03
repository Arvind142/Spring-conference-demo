package com.personal.conferencedemo.repository;

import com.personal.conferencedemo.model.Session;
import com.personal.conferencedemo.model.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeakerRepository extends JpaRepository<Speaker,Long> {

}
