package com.project.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.project.dao.DeliveryDao;
import com.project.dao.GPUCardDao;
import com.project.dao.MachineDao;
import com.project.dao.MonitorDao;
import com.project.model.Delivery;
import com.project.model.DeliveryCount;
import com.project.model.GPUCard;
import com.project.model.Machine;
import com.project.model.Monitor;

@Controller
@RequestMapping("/delivery")
public class DeliveryController {

	@Autowired
	MachineDao machineDao;
	
	@Autowired
	MonitorDao monitorDao;
	
	@Autowired
	DeliveryDao deliveryDao;

	@Autowired
	GPUCardDao gpuCardDao;

	@GetMapping("/add")
	public ModelAndView showDeliveryPage() {
		HashMap<String, Object> map = new HashMap<>();
		map.put("machineList", machineDao.getAvailablebyMachineManufacturer());
		map.put("monitorList", monitorDao.getAvailablebyMonitorManufacturer());
		map.put("record", new Delivery());
		return new ModelAndView("addDelivery", "map", map);
	}
	
	@PostMapping("/add/{id}")
	public ModelAndView addDeliveryDetails(Delivery delivery, @PathVariable int id) {
		if (deliveryDao.findById(id).isPresent())
			delivery.setDid(id);
		deliveryDao.save(delivery);
		try {
			Machine machine=machineDao.findAllBySerialNo(delivery.getMachineSerialNo()).get(0);
			machine.setStatus("Dispatch");
			
			Monitor monitor=monitorDao.findAllBySerialNo(delivery.getMonitorSerialNo()).get(0);
			monitor.setStatus("Dispatch");
			
			GPUCard gcard=gpuCardDao.findAllByGPUSerialno(delivery.getGpuCardSerialNo()).get(0);
			gcard.setStatus("Dispatch");
			
			machineDao.save(machine);
			gpuCardDao.save(gcard);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return new ModelAndView("redirect:/delivery/view");
	}

	@RequestMapping("/view")
	public ModelAndView viewDetails() {
		List<Delivery> vlist = deliveryDao.findAll();
		return new ModelAndView("viewDeliveryRecords", "vlist", vlist);
	}
	
	@GetMapping("/update/{id}")
	public ModelAndView updateDeliveryDetails(@PathVariable int id) {
		Optional<Delivery> foundRecord = deliveryDao.findById(id);
		Delivery delivery = new Delivery();
		if (foundRecord.isPresent()) 
			delivery = foundRecord.get();
		HashMap<String, Object> map = new HashMap<>();
		map.put("mlist", machineDao.getAvailablebyMachineManufacturer());
		map.put("record", delivery);
		return new ModelAndView("updateDelivery","map",map);
	}
	
	@RequestMapping("/delete/{id}")
	public ModelAndView deleteDeliveryDetails(@PathVariable int id) {
		Optional<Delivery> foundRecord = deliveryDao.findById(id);
		if (foundRecord.isPresent()) {			
			Delivery delivery = foundRecord.get();
			deliveryDao.delete(delivery);
			try {
				Machine machine = machineDao.findAllBySerialNo(delivery.getMachineSerialNo()).get(0);
				machine.setStatus("Available");
				
				Monitor monitor = monitorDao.findAllBySerialNo(delivery.getMonitorSerialNo()).get(0);
				monitor.setStatus("Available");
				
				GPUCard gcard=gpuCardDao.findAllByGPUSerialno(delivery.getGpuCardSerialNo()).get(0);
				gcard.setStatus("Available");
				
				machineDao.save(machine);
				gpuCardDao.save(gcard);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return new ModelAndView("redirect:/delivery/view");
	}
	
	@ResponseBody
	@GetMapping("loadmachinemanufacture")
	public String loadMachineManufacture() {
		Gson gson = new Gson();
		return gson.toJson(machineDao.getAvailablebyMachineManufacturer());
	}
	
	@ResponseBody
	@GetMapping("loadmonitormanufacture")
	public String loadMonitorManufacture() {
		Gson gson = new Gson();
		return gson.toJson(monitorDao.getAvailablebyMonitorManufacturer());
	}
	
	@ResponseBody
	@RequestMapping(value = "loadmachinemodelbymanufacture/{mfg}", method = RequestMethod.GET)
	public String loadMachineModelByManufacture(@PathVariable("mfg") String mfg) {
		Gson gson = new Gson();
		return gson.toJson(machineDao.findAvailableByManufacturer(mfg));
	}
	
	@ResponseBody
	@RequestMapping(value = "loadmonitormodelbymanufacture/{mfg}", method = RequestMethod.GET)
	public String loadMonitorModelByManufacture(@PathVariable("mfg") String mfg) {
		Gson gson = new Gson();
		return gson.toJson(monitorDao.findAvailableByManufacturer(mfg));
	}

	@ResponseBody
	@RequestMapping(value = "loadmachineserialnobymodel/{model}", method = RequestMethod.GET)
	public String loadMachineSerailNoByModel(@PathVariable("model") String model) {
		Gson gson = new Gson();
		return gson.toJson(machineDao.findSerialNoByModel(model));
	}
	
	@ResponseBody
	@RequestMapping(value = "loadmonitorserialnobymodel/{model}", method = RequestMethod.GET)
	public String loadMonitorSerailNoByModel(@PathVariable("model") String model) {
		Gson gson = new Gson();
		return gson.toJson(monitorDao.findSerialNoByModel(model));
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
		return gson.toJson(gpuCardDao.findAvailableGpuCardSerialNumberByCard(gpuCard));
	}
	
	@ResponseBody
	@RequestMapping(value = "loadinbuiltgpucard/{srno}", method = RequestMethod.GET)
	public String loadBuiltInGpuCard(@PathVariable("srno") String srno) {
		Gson gson = new Gson();
		return gson.toJson(machineDao.findAvailableBySerialNo(srno).get(0).getGpuCard());
	}
	
	@ResponseBody
	@RequestMapping(value = "deliverycount", method = RequestMethod.GET)
	public String deliveryCount() {
		Gson gson = new Gson();
		 List<DeliveryCount> count_version = deliveryDao.getCountByParamShavakVersion1();
		return gson.toJson(count_version);
	}
}
