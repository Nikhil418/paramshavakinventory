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

import com.project.dao.MonitorDao;
import com.project.model.Monitor;

@Controller
@RequestMapping("/monitor")
public class MonitorController {
	
	@Autowired
	MonitorDao monitorDao;
	
	@GetMapping("/add")
	public ModelAndView showAddMonitorPage() {
		return new ModelAndView("addmonitor","record", new Monitor());
	}  
	
	@PostMapping("/add/{id}")
	public ModelAndView addMonitor(Monitor monitor, @PathVariable int id) {
		if (monitorDao.findById(id).isPresent())
			monitor.setMoid(id);
		monitorDao.save(monitor);
		return new ModelAndView("redirect:/monitor/view");
	}
	
	@GetMapping("/view")
	public ModelAndView viewMonitorDetails() {
		List<Monitor> vlist = monitorDao.findAll();
		return new ModelAndView("viewMonitorRecords", "vlist", vlist);
	}
	
	@RequestMapping(value="/update/{id}", method = RequestMethod.GET)
	public ModelAndView updateMonitorDetails(@PathVariable int id) {
		Optional<Monitor> foundRecord = monitorDao.findById(id);
		Monitor monitor = null;
		if (foundRecord.isPresent()) 
			monitor = foundRecord.get();
		
		return new ModelAndView("addmonitor","record",monitor);
	}
	
	@RequestMapping("/delete/{id}")
	public ModelAndView deleteMonitorDetails(@PathVariable int id) {
		Optional<Monitor> foundRecord = monitorDao.findById(id);
		if (foundRecord.isPresent()) {
			
			Monitor record = foundRecord.get();
			monitorDao.delete(record);
		}

		return new ModelAndView("redirect:/monitor/view");
	}
}
