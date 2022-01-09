package com.ibrahim.flottegestv2.accounts.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibrahim.flottegestv2.accounts.models.Invoice;
import com.ibrahim.flottegestv2.accounts.repositories.InvoiceRepository;

import java.util.List;

@Service
public class InvoiceService {
	
	@Autowired
	private InvoiceRepository invoiceRepository;
	
	//Get All Invoices
	public List<Invoice> findAll(){
		return invoiceRepository.findAll();
	}	
	
	//Get Invoice By Id
	public Invoice findById(int id) {
		return invoiceRepository.findById(id).orElse(null);
	}	
	
	//Delete Invoice
	public void delete(int id) {
		invoiceRepository.deleteById(id);
	}
	
	//Update Invoice
	public void save(Invoice invoice) {
		invoiceRepository.save(invoice);
	}

}
