package org.oa.get_mac;

import org.apache.log4j.Logger;
import org.oa.get_mac.model.Device;
import org.oa.get_mac.model.DeviceType;
import org.oa.get_mac.repository.DeviceRepository;
import org.oa.get_mac.repository.DeviceTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/devices")
public class DeviceController {
	private static Logger log = Logger.getLogger(DeviceController.class);
	
	
	private DeviceRepository deviceRepository;
	@Autowired
	private DeviceTypeRepository deviceTypeRepository;
	
	@Autowired
	public DeviceController(DeviceRepository deviceRepository) {
		this.deviceRepository = deviceRepository;
		}
	

	@RequestMapping(method = RequestMethod.GET)
	public String getAll(Model model ) {
		
		model.addAttribute("devices", deviceRepository.findAll());
		return "devices";
	}
	
	@RequestMapping(value = "/edit",method = RequestMethod.POST)

	public String edit(Device device, Model model) {
		System.out.println(device);
		
		deviceRepository.update(device);
		
		return "redirect:/device/devices";
	}


	@RequestMapping(value="/edit/{id}", method = RequestMethod.GET)

	public String edit(@PathVariable int id,Model model) {
		
		Device device = deviceRepository.findById(id);
		model.addAttribute("device", device);
		Map<Boolean, String> mapDeviceEnable = new HashMap<Boolean, String>();
		mapDeviceEnable.put(false,"Disable");
		mapDeviceEnable.put(true,"Enable");
		model.addAttribute("mapDeviceEnable", mapDeviceEnable);
		
		List<DeviceType> devicetype = deviceTypeRepository.findAll();
		Map<Integer, String> mapDeviceType = new LinkedHashMap<Integer, String>();
		for(DeviceType type: devicetype){
			mapDeviceType.put(type.getId(), type.getDeviceType());
		}
		//log.info("Delete Device");
		
		model.addAttribute("mapDeviceType",mapDeviceType);
		return "deviceedit";

	}

	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String precreate(Model model){
		Device device = new Device();
		model.addAttribute("device", device);
		
		Map<Boolean, String> mapDeviceEnable = new HashMap<Boolean, String>();
		mapDeviceEnable.put(false,"Disable");
		mapDeviceEnable.put(true,"Enable");
		model.addAttribute("mapDeviceEnable", mapDeviceEnable);
		
		List<DeviceType> devicetype = deviceTypeRepository.findAll();
		Map<Integer, String> mapDeviceType = new LinkedHashMap<Integer, String>();
		for(DeviceType type: devicetype){
			mapDeviceType.put(type.getId(), type.getDeviceType());
		}
		//log.info("Delete Device");
		
		model.addAttribute("mapDeviceType",mapDeviceType);
		
		
		return "devicecreate";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String postcreate(Model model, Device device){
		
		deviceRepository.create(device);
		return "redirect:/device/devices";
	}

	
	@RequestMapping(value="/delete/{id}", method = RequestMethod.GET)

	public String delete(@PathVariable int id) {
		
		Device device = new Device();
		device.setId(id);
		deviceRepository.delete(device);
		//log.info("Delete Device");
		return "redirect:/device/devices";

	}

}
