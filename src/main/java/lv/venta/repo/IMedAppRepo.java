package lv.venta.repo;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import lv.venta.model.Doctor;
import lv.venta.model.MedicalAppointment;

public interface IMedAppRepo extends CrudRepository<MedicalAppointment, Integer> {
	
	ArrayList<MedicalAppointment> findByPersonCode(String personCode);
	
	// ArrayList<MedicalAppointment> findAllMedAppToday(Doctor doctor, LocalDateTime dateTime);
	
	// ArrayList<MedicalAppointment> findAllByDoctor(Doctor doctor);
	
	@Query(nativeQuery = true, value="SELECT * FROM medical_appointment where doctor = (?1 ) AND date(date_time) = curdate();")
	ArrayList<MedicalAppointment> findByDoctorToday(Doctor doctor);
	
}
