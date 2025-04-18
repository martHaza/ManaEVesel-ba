package lv.venta.repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import lv.venta.model.Doctor;

public interface IDoctorRepo extends CrudRepository<Doctor, Integer> {

	Doctor findByPersonCode(String personCode);
	
	
}
