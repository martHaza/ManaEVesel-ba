package lv.venta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lv.venta.service.IHospitalAppService;

@Controller
@RequestMapping("/hospital")
public class HospitalAppController {

	@Autowired
	private IHospitalAppService hospitalService;
	
	// i. get medicalAppointmentByPersonCode
	@GetMapping("/appointments/patient/{personCode}")
	public String getAppointmentsByID(@PathVariable(name = "personCode") int pid, Model model) {
		
	}
	
	// ii get patientDiseaseHistoryByPersonCode
	@GetMapping("/disease/patient/{personCode}")
	public String getPatientDiseaseHistory(@PathVariable(name = "personCode") int pid, Model model) {
		
	}
	
	// iii get allPatDisHistoryLargerThan
	@GetMapping("/disease/severity/{severity}")
}
