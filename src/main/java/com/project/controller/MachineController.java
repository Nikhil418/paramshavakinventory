package com.project.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.dao.MachineDao;
import com.project.model.Machine;

@Controller
@RequestMapping("/machine")
public class MachineController {  
	
	@Autowired
	MachineDao machineDao;
  
	@GetMapping("/add")
	public ModelAndView showAddMachinePage() {
		return new ModelAndView("addmachine","record", new Machine());
	}  
	
	@PostMapping("/add/{id}")
	public ModelAndView addMachine(Machine machine, @PathVariable int id) {
		if (machineDao.findById(id).isPresent())
			machine.setMid(id);
		System.out.println("Machine : "+machine);
		machineDao.save(machine);
		return new ModelAndView("redirect:/machine/view");
	}
	
	@GetMapping("/view")
	public ModelAndView viewMachineDetails() {
		List<Machine> vlist = machineDao.findAll();
		return new ModelAndView("viewMachineRecords", "vlist", vlist);
	}
	
	@RequestMapping(value="/update/{id}", method = RequestMethod.GET)
	public ModelAndView updateMachineDetails(@PathVariable int id) {
		Optional<Machine> foundRecord = machineDao.findById(id);
		Machine machine = null;
		if (foundRecord.isPresent()) 
			machine = foundRecord.get();
		
		System.out.println("Record : "+machine);
		return new ModelAndView("addmachine","record",machine);
	}
	
	@RequestMapping("/delete/{id}")
	public ModelAndView deleteMachineDetails(@PathVariable int id) {
		Optional<Machine> foundRecord = machineDao.findById(id);
		if (foundRecord.isPresent()) {
			
			Machine record = foundRecord.get();
			machineDao.delete(record);
		}

		return new ModelAndView("redirect:/machine/view");
	}
}
