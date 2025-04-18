package lv.venta.service;

import java.util.ArrayList;

import lv.venta.model.Doctor;

public interface IDoctorCRUDService {
	
	// selectAllDoctors
	public abstract ArrayList<Doctor> selectAllDoctors() throws Exception;
	
	// selectDoctorByID
	public abstract Doctor selectDocByID(int did) throws Exception; 
	
	// deleteDoctorByID
	public abstract void deleteDocByID(int did) throws Exception;
	
	// insertNewDoctor
	public abstract void insertNewDoc(Doctor doctor) throws Exception;
	
	// updateDoctorByID
	public abstract void updateDocByID(int did, Doctor doctor) throws Exception;

}
