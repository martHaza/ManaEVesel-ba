package lv.venta.repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import lv.venta.enums.City;
import lv.venta.model.Patient;

public interface IPatientRepo extends CrudRepository<Patient, Integer>{
	
	ArrayList<Patient> findByPersonCode(String personCode);
	
	ArrayList<Patient> findByCity(City city);
}
