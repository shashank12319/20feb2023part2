package com.wittybrains.busbookingsystem.controller;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wittybrains.busbookingsystem.dto.BusDTO;
import com.wittybrains.busbookingsystem.model.Bus;

import com.wittybrains.busbookingsystem.repository.BusRepository;




@RestController
@RequestMapping("/bus")
public class BusController {
    private final BusRepository busRepository;
    
    
    public BusController(BusRepository busRepository) {
        this.busRepository = busRepository;
    }
    
    @SuppressWarnings("unchecked")
	@PostMapping("/createBuses")
    public ResponseEntity createBuses(@RequestBody List<BusDTO> busList) {
    	busList.stream().forEach(busDTO->{
    		Bus bus=new Bus();
    		bus.setDestination(busDTO.getDestination());
    		bus.setNumber(busDTO.getNumber());
    		bus.setSource(busDTO.getSource());
    		bus.setType(busDTO.getType());
    		bus.setTiming(busDTO.getTiming());
    		busRepository.save(bus);
    	});
    	return  new ResponseEntity("sucessful created buses", HttpStatus.CREATED);
    }
}