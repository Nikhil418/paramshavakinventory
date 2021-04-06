package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.dao.MachineDao;
import com.project.model.Delivery;
import com.project.model.Machine;

@Controller
public class MachineController {  
	
	@Autowired
	MachineDao machineDao;
  
	@RequestMapping("/addMachine")
	public String addMachine() {
		return "addmachine";
	}  
	
	@RequestMapping("/insertmachine")
	public ModelAndView insertMachine(@RequestParam("manufacture") String manufacture,@RequestParam("machine_model") String machinemodel,@RequestParam("serial_number") String serialnumber,@RequestParam("issued_on_date") String issued_on_date,@RequestParam("issued_on_name") String issued_on_name,@RequestParam("GPU_card") String GPUCard,@RequestParam("GPU_card_serialNumber") String GPU_card_serialNumber,@RequestParam("mobile") String mobile,@RequestParam("comment") String comment,@RequestParam("status") String status ) {
		Machine machine=new Machine(manufacture,machinemodel,serialnumber,issued_on_date,issued_on_name,GPUCard,GPU_card_serialNumber,mobile,comment,status);
		
		machineDao.save(machine);
		return new ModelAndView("addnew");
		
	}  
	@RequestMapping("/viewMachine")
	public ModelAndView viewMachineDetails() {
		List<Machine> vlist = machineDao.findAll();
		return new ModelAndView("viewMachineRecords", "vlist", vlist);
	}
}
