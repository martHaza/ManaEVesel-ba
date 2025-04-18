package lv.venta.repo;

import org.springframework.data.repository.CrudRepository;

import lv.venta.model.Doctor;

public interface IDoctorRepo extends CrudRepository<Doctor, Integer> {

}
