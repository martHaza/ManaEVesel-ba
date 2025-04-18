package lv.venta.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;
import lv.venta.model.Doctor;
import lv.venta.service.IDoctorCRUDService;

@Controller
@RequestMapping("/doctor/crud")
public class DoctorCRUDController {

	@Autowired
	private IDoctorCRUDService doctorService;
	
	// get /doctor/crud/show/all
	@GetMapping("/all") //localhost:8080/doctor/crud/all
	public String getAllDoctors(Model model) {
		try {
			
			model.addAttribute("package", doctorService.selectAllDoctors());
			return "doctor-all-page";
		} catch (Exception e) {
			model.addAttribute("package", e.getMessage());
			return "error-page";
		}
	}
	
	// get /doctor/crud/show/all/{id}
	@GetMapping("/all/{did}") // localhost":8080/doctor/crud/all/1
	public String getAllDoctorsByID(@PathVariable("did") int did, Model model) {
		try {
			
			model.addAttribute("package", doctorService.selectDocByID(did));
			return "doctor-one-page";
		} catch (Exception e) {
			model.addAttribute("package", e.getMessage());
			return "error-page";
		}
	}
	
	// get /doctor/crud/remove/{id}
	@GetMapping("/remove/{did}") // localhost:8080/doctor/crud/remove/2
	public String getDoctorRemove(@PathVariable("did") int did, Model model) {
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
		model.addAttribute("doctor", new Doctor());
		return "doctor-add-page";
	}
	
	@PostMapping("/add") // localhost...
	public String postDoctorAdd(@Valid Doctor doctor, BindingResult result) {
		if(result.hasErrors()) {
			return "doctor-add-page";
		} else {
			try {
				doctorService.insertNewDoc(doctor);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return "redirect:/doctor/crud/all";
		}
	}
	
	// get and post /doctor/crud/update/{id}
	@GetMapping("/update/{did}") // localhost:8080/doctor/crud/update
	public String getDoctorUpdate(@PathVariable("did") int did, Model model) {
		try {
			
			Doctor doctorForUpdating = doctorService.selectDocByID(did);
			model.addAttribute("doctor", doctorForUpdating);
			model.addAttribute("did", did);
			return "doctor-update-page";
		} catch (Exception e) {
			model.addAttribute("package", e.getMessage());
			return "error-page";
		}
	}
	
	@PostMapping("/update/{did}")
	public String postDoctorUpdate(@PathVariable("did") int did, @Valid Doctor doctor, BindingResult result, Model model) {
		try {
			doctorService.updateDocByID(did, doctor);
			return "redirect:/doctor/crud/all/"+did;
		} catch (Exception e) {
			model.addAttribute("package",e.getMessage());
			return "error-page";
		}
	}
}
