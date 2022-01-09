package com.ibrahim.flottegestv2.helpdesk.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibrahim.flottegestv2.helpdesk.models.Ticket;
import com.ibrahim.flottegestv2.helpdesk.repositories.TicketRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {
	
	@Autowired
	private TicketRepository invoiceRepository;
	
	//Get All Tickets
	public List<Ticket> findAll(){
		return invoiceRepository.findAll();
	}	
	
	//Get Ticket By Id
	public Optional<Ticket> findById(int id) {
		return invoiceRepository.findById(id);
	}	
	
	//Delete Ticket
	public void delete(int id) {
		invoiceRepository.deleteById(id);
	}
	
	//Update Ticket
	public void save(Ticket invoice) {
		invoiceRepository.save(invoice);
	}

}
