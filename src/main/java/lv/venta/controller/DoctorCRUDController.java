package lv.venta.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lv.venta.model.Doctor;
import lv.venta.service.IDoctorCRUDService;

@Controller
@RequestMapping("/doctor/crud")
public class DoctorCRUDController {

	@Autowired
	private IDoctorCRUDService doctorService;
	
	// get /doctor/crud/show/all
	@GetMapping("/show/all") //localhost:8080/doctor/crud/all
	public String getAllDoctors(int did, Model model) {
		try {
			
			model.addAttribute("package", doctorService.selectAllDoctors());
			return "doctor-all-page";
		} catch (Exception e) {
			model.addAttribute("package", e.getMessage());
			return "error-page";
		}
	}
	
	// get /doctor/crud/show/all/{id}
	@GetMapping("/all/{id}") // localhost":8080/doctor/crud/all/1
	public String getAllDoctorsByID(@PathVariable(name = "did") int did, Model model) {
		try {
			
			model.addAttribute("package", doctorService.selectDocByID(did));
			return "doctor-one-page";
		} catch (Exception e) {
			model.addAttribute("package", e.getMessage());
			return "error-page";
		}
	}
	
	// get /doctor/crud/remove/{id}
	@GetMapping("/remove/{id}") // localhost:8080/doctor/crud/all
	public String getDoctorRemove(@PathVariable(name = "did") int did, Model model) {
		try {
			
			doctorService.deleteDocByID(did);
			ArrayList<Doctor> allDoctors = doctorService.selectAllDoctors();
			model.addAttribute("package", allDoctors);
			return "doctor-all-page";
		} catch (Exception e) {
			model.addAttribute("package", e.getMessage());
			return "error-page";
		}
	}
	
	// get and post /doctor/crud/add
	@GetMapping("/add") // localhost:8080/doctor/crud/add
	public String getDoctorAdd(Model model) {
		model.addAttribute("package", new Doctor());
		return "doctor-add-page";
	}
	
	// get and post /doctor/crud/update/{id}
	@GetMapping("/update") // localhost:8080/doctor/crud/update
	public String getDoctorUpdate(@PathVariable(name = "did") int did, Model model) {
		try {
			
			Doctor doctorForUpdating = doctorService.selectDocByID(did);
			model.addAttribute("package", doctorForUpdating);
			model.addAttribute("did", did);
			return "doctor-update-page";
		} catch (Exception e) {
			model.addAttribute("package", e.getMessage());
			return "error-page";
		}
	}
}
