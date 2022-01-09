package com.ibrahim.flottegestv2.fleet.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.ibrahim.flottegestv2.fleet.models.VehicleHire;
import com.ibrahim.flottegestv2.fleet.services.VehicleHireService;
import com.ibrahim.flottegestv2.fleet.services.VehicleService;
import com.ibrahim.flottegestv2.parameters.services.ClientService;
import com.ibrahim.flottegestv2.parameters.services.LocationService;

@Controller
public class VehicleHireController {
	
	@Autowired private VehicleHireService vehicleHireService;
	@Autowired private ClientService clientService;
	@Autowired private LocationService locationService;
	@Autowired private VehicleService vehicleService;

	public Model addModelAttributes(Model model){
		model.addAttribute("clients", clientService.findAll());
		model.addAttribute("locations", locationService.findAll());
		model.addAttribute("vehicles", vehicleService.findAll());
		return model;
	}

	//Get All VehicleHires
	@GetMapping("/fleet/hires")
	public String findAll(Model model){		
		model.addAttribute("hires", vehicleHireService.findAll());
		return "/fleet/hires";
	}

	@GetMapping("/fleet/hireAdd")
	public String addHire(Model model){
		addModelAttributes(model);
		return "/fleet/hireAdd";
	}

	@GetMapping("/fleet/hire/{op}/{id}")
	public String editHire(Model model, @PathVariable Integer id, @PathVariable String op){
		VehicleHire hire = vehicleHireService.findById(id);
		model.addAttribute("hire", hire);
		addModelAttributes(model);
		return "/fleet/hire"+op;
	}

	//Add VehicleHire
	@PostMapping("/fleet/hires")
	public String addNew(VehicleHire vehicleHire) {
		vehicleHireService.save(vehicleHire);
		return "redirect:/fleet/hires";
	}
	
	@RequestMapping(value="fleet/hire/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(@PathVariable Integer id) {
		vehicleHireService.delete(id);
		return "redirect:/fleet/hires";
	}

}