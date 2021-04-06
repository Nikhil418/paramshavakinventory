package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.dao.GPUCardDao;
import com.project.model.GPUCard;
import com.project.model.Machine;

@Controller
public class GPUCardController {  
	
	@Autowired
	GPUCardDao gpuCardDao;
	
	@RequestMapping("/addGPUCard")
	public String addGpu() {
		return "addgpucard";
	}  
	
	@RequestMapping("/insertgpucard")
	public ModelAndView insertGpucard(@RequestParam("gpucard") String Gpucard,@RequestParam("gpucard_serial_number") String Gpucard_serial_number,@RequestParam("issued_on_date") String issued_on_date,@RequestParam("issued_on_name") String issued_on_name,@RequestParam("mobile") String mobile,@RequestParam("comment") String comment)
	{
		GPUCard gpuCard=new GPUCard(Gpucard, Gpucard_serial_number, issued_on_date, issued_on_name, mobile, comment,"Available");
		gpuCardDao.save(gpuCard);
		
		return new ModelAndView("addnew");
		
	}  
	@RequestMapping("/viewGPU")
	public ModelAndView viewMachineDetails() {
		List<GPUCard> vlist = gpuCardDao.findAll();
		return new ModelAndView("viewGPUCardRecords", "vlist", vlist);
	}
}
