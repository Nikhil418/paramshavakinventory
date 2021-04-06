package com.project.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.google.gson.Gson;
import com.project.dao.DeliveryDao;
import com.project.dao.GPUCardDao;
import com.project.dao.MachineDao;
import com.project.model.Delivery;
import com.project.model.DeliveryCount;
import com.project.model.GPUCard;
import com.project.model.Machine;

@Controller
public class DeliveryController {

	@Autowired
	MachineDao machineDao;
	@Autowired
	DeliveryDao deliveryDao;

	@Autowired
	GPUCardDao gpuCardDao;

	@RequestMapping("/addDelivery")
	public ModelAndView addDelivery() {
		List<String> mlist = machineDao.getbyMachineManufacture();
		System.out.println(mlist);
		return new ModelAndView("addDelivery", "mlist", mlist);
	}

	@ResponseBody
	@RequestMapping(value = "loadmodelbymanufacture/{mfg}", method = RequestMethod.GET)
	public String loadModelByManufacture(@PathVariable("mfg") String mfg) {
		Gson gson = new Gson();
		return gson.toJson(machineDao.findByManufacture(mfg));
	}

	@ResponseBody
	@RequestMapping(value = "loadserialnobymodel/{model}", method = RequestMethod.GET)
	public String loadSerailNoByModel(@PathVariable("model") String model) {
		Gson gson = new Gson();
		System.out.println("Model : " + model);
		return gson.toJson(machineDao.findSerialNoByModel(model));
	}

	@ResponseBody
	@RequestMapping(value = "loadgpucard", method = RequestMethod.GET)
	public String loadGpuCard() {
		Gson gson = new Gson();
		System.out.println("****" +gpuCardDao.getAvailableGpuCard().get(0));
		return gson.toJson(gpuCardDao.getAvailableGpuCard());
	}

	@ResponseBody
	@RequestMapping(value = "loadgpuserialnobycard/{gpucard}", method = RequestMethod.GET)
	public String loadGpuSerialNoByCard(@PathVariable("gpucard") String gpuCard) {
		Gson gson = new Gson();
		System.out.println("GPC Card : " + gpuCard);
		return gson.toJson(gpuCardDao.findGpuCardSerialNumberByCard(gpuCard));
	}
	
	@ResponseBody
	@RequestMapping(value = "loadinbuiltgpucard/{srno}", method = RequestMethod.GET)
	public String loadBuiltInGpuCard(@PathVariable("srno") String srno) {
		Gson gson = new Gson();
		return gson.toJson(machineDao.findBySerialNo(srno).get(0).getGpu_card());
	}

	@RequestMapping("/adddeliverydetails")
	public ModelAndView addDeliveryDetails(@RequestParam("paramshavakvarient") String paramshavakvarient, @RequestParam("manufacture") String manufacture,
			@RequestParam("machinemodel") String machinemodel, @RequestParam("serialno") String serialno,
			@RequestParam("dispatch_date") String dispatch_date, @RequestParam("gpucard") String gpucard,
			@RequestParam("gpucardsrno") String gpucardsrno, @RequestParam("installed_by") String installedby,
			@RequestParam("param_shavak_version") String param_shavak_version,
			@RequestParam("studio_license_no") String studio_license_no,
			@RequestParam("institute_name") String institute_name,
			@RequestParam("institute_address") String institute_address,
			@RequestParam("contact_person_name") String contact_person_name, @RequestParam("mobno") String mobno,
			@RequestParam("emailid") String emailid, @RequestParam("comment") String comment) {
		Delivery delivery = new Delivery(paramshavakvarient,manufacture, machinemodel, serialno, dispatch_date, installedby,
				param_shavak_version, studio_license_no, gpucard, gpucardsrno, institute_name, institute_address,
				contact_person_name, mobno, emailid, comment);

		deliveryDao.save(delivery);
		
		Machine machine=machineDao.findBySerialNo(serialno).get(0);
		machine.setStatus("Dispatch");
		
		GPUCard gcard=gpuCardDao.findByGPUSerialno(gpucardsrno).get(0);
		gcard.setStatus("Dispatch");
		
		machineDao.save(machine);
		gpuCardDao.save(gcard);
		return new ModelAndView("addnew");
	}

	@RequestMapping("/viewDelivery")
	public ModelAndView viewDetails() {
		List<Delivery> vlist = deliveryDao.findAll();
		return new ModelAndView("viewDeliveryRecords", "vlist", vlist);
	}

	@RequestMapping(value="/updatedetails/{id}", method = RequestMethod.GET)
	public ModelAndView updateDeliveryDetails(@PathVariable int id) {
		Optional<Delivery> foundRecord = deliveryDao.findById(id);
		Delivery record= null;
		if (foundRecord.isPresent()) 
			record = foundRecord.get();
		
		System.out.println("Record : "+record);
		return new ModelAndView("updateDelivery","record",record);
	}
	
	@RequestMapping("/updatedeliverydetails/{id}")
	public ModelAndView updateDeliveryDetails(@RequestParam("dispatch_date") String dispatch_date,
			@RequestParam("installed_by") String installedby,
			@RequestParam("studio_license_no") String studio_license_no,
			@RequestParam("institute_name") String institute_name,
			@RequestParam("institute_address") String institute_address,
			@RequestParam("contact_person_name") String contact_person_name, @RequestParam("mobno") String mobno,
			@RequestParam("emailid") String emailid,
			@RequestParam("param_shavak_version") String paramShavakVersion,
			@PathVariable int id) {
		Optional<Delivery> foundRecord = deliveryDao.findById(id);
		if (foundRecord.isPresent()) {
			
			Delivery record = foundRecord.get();
			System.out.println("Record *** : "+record);
			record.setDisptachdate(dispatch_date);
			record.setSysteminstalledby(installedby);
			record.setStudiolicense(studio_license_no);
			record.setInstitutename(institute_name);
			record.setInstitutaddress(institute_address);
			record.setContactpersonname(contact_person_name);
			record.setEmailid(emailid);
			record.setMobileno(mobno);
			record.setParamshavakversion(paramShavakVersion);
			
			deliveryDao.save(record);
		}

		
		return new ModelAndView("redirect:/viewdetails");
	}
	
	@RequestMapping("/deletedetails/{id}")
	public ModelAndView deleteDeliveryDetails(@PathVariable int id) {
		Optional<Delivery> foundRecord = deliveryDao.findById(id);
		if (foundRecord.isPresent()) {
			
			Delivery record = foundRecord.get();
			deliveryDao.delete(record);
		}

		return new ModelAndView("redirect:/viewdetails");
	}
	
	@ResponseBody
	@RequestMapping(value = "deliverycount", method = RequestMethod.GET)
	public String deliveryCount() {
		Gson gson = new Gson();
		 List<DeliveryCount> count_version = deliveryDao.getCountByParamShavakVersion1();
		return gson.toJson(count_version);
	}
}
