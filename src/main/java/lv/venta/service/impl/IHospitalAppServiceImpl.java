package lv.venta.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import lv.venta.enums.City;
import lv.venta.enums.Disease;
import lv.venta.enums.DoctorType;
import lv.venta.model.Doctor;
import lv.venta.model.MedicalAppointment;
import lv.venta.model.Patient;
import lv.venta.model.PatientDiseaseH;
import lv.venta.repo.IDoctorRepo;
import lv.venta.repo.IMedAppRepo;
import lv.venta.repo.IPatientDiseaseHRepo;
import lv.venta.repo.IPatientRepo;
import lv.venta.service.IHospitalAppService;

public class IHospitalAppServiceImpl implements IHospitalAppService {

	@Autowired 
	private IMedAppRepo medAppRepo;
	
	@Autowired
	private IPatientDiseaseHRepo patDisHRepo;
	
	@Autowired
	private IPatientRepo patientRepo;
	
	@Autowired
	private IDoctorRepo doctorRepo;
	
	
	@Override
	public ArrayList<MedicalAppointment> selectAllMedAppByPatPersonCode(String personCode) throws Exception {
		if(personCode == null) {
			throw new Exception("Personas kods nevar būt nulle!");
		} 
		
		ArrayList<MedicalAppointment> result = medAppRepo.findByPersonCode(personCode);
		if(result.isEmpty()) {
			throw new Exception("Pacients ar tādu personas kodu nav!");
		}
		
		return result;
	}

	@Override
	public ArrayList<PatientDiseaseH> selectAllPatDisHistoryByPatPersonCode(String personCode) throws Exception {
		if(personCode == null) {
			throw new Exception("Personas kods nevar būt nulle!");
		}
		
		ArrayList<PatientDiseaseH> result = patDisHRepo.findByPatientPersonCode(personCode);
		if(result.isEmpty()) {
			throw new Exception("Pacientam ar tādu personas kodu nav slimības vēsture!");
		}
		
		return result;
	}

	@Override
	public ArrayList<PatientDiseaseH> selectAllPatDisHistorySeverityLargerThan(int severity) throws Exception {
		if(severity < 0) {
			throw new Exception("Smaguma pakāpei ir jābūt nullei vai lielākai par nulli!");
		}
		
		ArrayList<PatientDiseaseH> result = patDisHRepo.findBySeverityGreaterThan(severity);
		
		if(result.isEmpty()) {
			throw new Exception("Nav smaguma pakāpes lielākas par " + severity);
		}
		
		return result;
	}

	@Override
	public ArrayList<Patient> selectAllPatFromCity(City city) throws Exception {
		ArrayList<Patient> result = patientRepo.findByCity(city);
		if(result.isEmpty()) {
			throw new Exception("No tādas pilsētas nav neviens pacients!");
		}
		
		return result;
	}

	@Override
	public ArrayList<MedicalAppointment> selectAllMedAppForDoctorToday(String personCode) throws Exception {
		// LocalDate today = LocalDate.now();
		
		if(personCode == null) {
			throw new Exception("Personas kods nedrīkst būt nulle!");
		}
		
		Doctor doctor = doctorRepo.findByPersonCode(personCode);
		if(doctor == null) {
			throw new Exception("Dakteris nevar būt nulle!");
		}
		
		return medAppRepo.findByDoctorToday(doctor);
		
	}

	@Override
	public void changeDoctorForApp(int mdid, int did) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int calculateHowManyPatForDocType(DoctorType doctorType) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void insertNewPatDisHistoryForPat(Disease disease, LocalDate diseaseStart, boolean isPresent,
			Patient patient, int severity, String notes) throws Exception {
		// TODO Auto-generated method stub
		
	}

	
	
	
	
}
