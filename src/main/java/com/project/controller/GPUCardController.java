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

import com.project.dao.GPUCardDao;
import com.project.model.GPUCard;

@Controller
@RequestMapping("/gpu")
public class GPUCardController {  
	
	@Autowired
	GPUCardDao gpuCardDao;
	
	@GetMapping("/add")
	public ModelAndView showAddGpuPage() {
		return new ModelAndView("addgpucard","record",new GPUCard());
	}  
	
	@PostMapping("/add")
	public ModelAndView addGpuCard(GPUCard gpuCard)
	{
		gpuCardDao.save(gpuCard);
		return new ModelAndView("redirect:/gpu/view");	
	} 
	
	@PostMapping("/add/{id}")
	public ModelAndView addGpuCard(GPUCard gpuCard, @PathVariable int id) {
		if (gpuCardDao.findById(id).isPresent())
			gpuCard.setGpuid(id);
		System.out.println("GPU Card : "+gpuCard);
		gpuCardDao.save(gpuCard);
		return new ModelAndView("redirect:/gpu/view");
	}
	
	@RequestMapping("/view")
	public ModelAndView viewGpuCardDetails() {
		List<GPUCard> vlist = gpuCardDao.findAll();
		return new ModelAndView("viewGPUCardRecords", "vlist", vlist);
	}
	
	@RequestMapping(value="/update/{id}", method = RequestMethod.GET)
	public ModelAndView updateDeliveryDetails(@PathVariable int id) {
		Optional<GPUCard> foundRecord = gpuCardDao.findById(id);
		GPUCard record= null;
		if (foundRecord.isPresent()) 
			record = foundRecord.get();
		
		System.out.println("Record : "+record);
		return new ModelAndView("addgpucard","record",record);
	}
	
	@RequestMapping("/delete/{id}")
	public ModelAndView deleteGpuCardDetails(@PathVariable int id) {
		Optional<GPUCard> foundRecord = gpuCardDao.findById(id);
		if (foundRecord.isPresent()) {
			
			GPUCard record = foundRecord.get();
			gpuCardDao.delete(record);
		}

		return new ModelAndView("redirect:/gpu/view");
	}
}
