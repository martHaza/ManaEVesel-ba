package lv.venta.repo;

import org.springframework.data.repository.CrudRepository;

import lv.venta.model.Medicine;

public interface IMedicineRepo extends CrudRepository<Medicine, Integer> {

}
