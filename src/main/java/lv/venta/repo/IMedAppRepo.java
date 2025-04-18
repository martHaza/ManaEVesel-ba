package lv.venta.repo;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import lv.venta.model.MedicalAppointment;

public interface IMedAppRepo extends CrudRepository<MedicalAppointment, Integer> {
	
	ArrayList<MedicalAppointment> findByPersonCode(String personCode);
	
	ArrayList<MedicalAppointment> findAllMedAppToday(int did, LocalDateTime dateTime);
	
}
