package lv.venta.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import lv.venta.enums.City;
import lv.venta.enums.Disease;
import lv.venta.enums.DoctorType;
import lv.venta.model.MedicalAppointment;
import lv.venta.model.Patient;
import lv.venta.model.PatientDiseaseH;

public interface IHospitalAppService {

	// selectAllMedAppointmentsByPatPersonCode
	public abstract ArrayList<MedicalAppointment> selectAllMedAppByPatPersonCode(String personCode) throws Exception;
	
	// selectAllPatDisHistoryByPatPersonCode
	public abstract ArrayList<PatientDiseaseH> selectAllPatDisHistoryByPatPersonCode(String personCode) throws Exception;
	
	// selectAllPatDisHistorySeverityLargerThan
	public abstract ArrayList<PatientDiseaseH> selectAllPatDisHistorySeverityLargerThan(int severity) throws Exception;
	
	// selectAllPatFromCity
	public abstract ArrayList<Patient> selectAllPatFromCity(City city) throws Exception;
	
	// sleetAllMedAppForDoctorsToday
	public abstract ArrayList<MedicalAppointment> selectAllMedAppForDoctorToday(String personCode) throws Exception;
	
	// changeDocForAppointment
	public abstract void changeDoctorForApp(int mdid, int did) throws Exception;
	
	// calcHowManyPatForDocType
	public abstract int calculateHowManyPatForDocType(DoctorType doctorType) throws Exception;
	
	// insertNewPatDisHistoryForPat
	public abstract void insertNewPatDisHistoryForPat(Disease disease, LocalDate diseaseStart, boolean isPresent, Patient patient, int severity, String notes) throws Exception;

	
	
}
