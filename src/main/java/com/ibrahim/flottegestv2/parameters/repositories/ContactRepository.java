package com.ibrahim.flottegestv2.parameters.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibrahim.flottegestv2.parameters.models.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {

}
