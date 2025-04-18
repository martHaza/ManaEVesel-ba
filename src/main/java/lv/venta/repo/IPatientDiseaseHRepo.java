package lv.venta.repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import lv.venta.model.PatientDiseaseH;

public interface IPatientDiseaseHRepo extends CrudRepository<PatientDiseaseH, Integer>{
	
	ArrayList<PatientDiseaseH> findBySeverityGreaterThan(int severity);
	
	ArrayList<PatientDiseaseH> findByPatientPersonCode(String personCode);
	
}
