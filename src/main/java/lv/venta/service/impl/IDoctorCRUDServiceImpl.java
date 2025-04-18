package lv.venta.service.impl;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.model.Doctor;
import lv.venta.model.MedicalAppointment;
import lv.venta.repo.IDoctorRepo;
import lv.venta.repo.IMedAppRepo;
import lv.venta.service.IDoctorCRUDService;

@Service
public class IDoctorCRUDServiceImpl implements IDoctorCRUDService {

	@Autowired
	private IDoctorRepo doctorRepo;
	
	@Autowired
	private IMedAppRepo appointmentRepo;
	
	
	@Override
	public ArrayList<Doctor> selectAllDoctors() throws Exception {
		if(doctorRepo.count() == 0) {
			throw new Exception("DoctorRepo ir tukšs!");
		}
		
		return (ArrayList<Doctor>) doctorRepo.findAll();
	}

	@Override
	public Doctor selectDocByID(int did) throws Exception {
		if(did < 0) {
			throw new Exception("Daktera ID nevar būt negatīvs!");
		}
		
		if(!doctorRepo.existsById(did)) {
			throw new Exception("Dakters ar tādu ID nepastāv!");
		}
		
		return doctorRepo.findById(did).get();
	}

	@Override
	public void deleteDocByID(int did) throws Exception {
		Collection<MedicalAppointment> docAppointments = selectDocByID(did).getMedicalAppointment();
		if(!docAppointments.isEmpty()) {
			for(MedicalAppointment temp : docAppointments) {
				temp.setDoctor(null);
				appointmentRepo.save(temp);
			}
		}
		
		doctorRepo.delete(selectDocByID(did));	
	}

	@Override
	public void insertNewDoc(Doctor doctor) throws Exception {
		if(doctorRepo.existsById(doctor.getDid())) {
			throw new Exception("Dakteris ar tādu ID jau eksistē!");
		}
		
		doctorRepo.save(doctor);
	}

	@Override
	public void updateDocByID(int did, Doctor doctor) throws Exception {
		Doctor update = selectDocByID(did);
		update.setDoctorType(doctor.getDoctorType());
		update.setExperienceInYears(doctor.getExperienceInYears());
		update.setCertificateNr(doctor.getCertificateNr());
		update.setName(doctor.getName());
		update.setPersonCode(doctor.getPersonCode());
		update.setSurname(doctor.getSurname());
		
		doctorRepo.save(update);
	}

	
	
}
