package lv.venta.repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import lv.venta.enums.City;
import lv.venta.model.Address;

public interface IAddressRepo extends CrudRepository<Address, Integer> {

	Address findByCity(City city);
	
}
