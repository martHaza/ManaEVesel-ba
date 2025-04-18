package lv.venta;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lv.venta.enums.City;
import lv.venta.enums.Disease;
import lv.venta.enums.DoctorType;
import lv.venta.model.Address;
import lv.venta.model.Doctor;
import lv.venta.model.MedicalAppointment;
import lv.venta.model.Medicine;
import lv.venta.model.Patient;
import lv.venta.model.PatientDiseaseH;
import lv.venta.repo.IAddressRepo;
import lv.venta.repo.IDoctorRepo;
import lv.venta.repo.IMedAppRepo;
import lv.venta.repo.IMedicineRepo;
import lv.venta.repo.IPatientDiseaseHRepo;
import lv.venta.repo.IPatientRepo;

@SpringBootApplication
public class ManaEVeselibaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManaEVeselibaApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner testDB(IAddressRepo addressRepo, IDoctorRepo doctorRepo, IMedAppRepo medAppRepo,
			IMedicineRepo medicineRepo, IPatientDiseaseHRepo patDisHRepo, IPatientRepo patientRepo) {
		
		return new CommandLineRunner() {

			@Override
			public void run(String... args) throws Exception {
				// Address
				Address a1 = new Address(City.Kuldīga, 3, "Aizputes iela");
				Address a2 = new Address(City.Ventspils, 23, "Ganibu iela");
				Address a3 = new Address(City.Rīga, 6, "Tallinas iela");
				addressRepo.save(a1);
				addressRepo.save(a2);
				addressRepo.save(a3);
				
				// Doctor
				Doctor doc1 = new Doctor(DoctorType.Psihiatrs, 13, "IU111", "Laura", "111111-11111", "Bite");
				Doctor doc2 = new Doctor(DoctorType.Ginekologs, 27, "IU222", "Rihards", "222222-22222", "Lapsa");
				Doctor doc3 = new Doctor(DoctorType.ĢimenesĀrsts, 30, "IU33312", "Darius", "333333-33333", "Boris");
				doctorRepo.save(doc1);
				doctorRepo.save(doc2);
				doctorRepo.save(doc3);
				
				// Patient
				Patient p1 = new Patient();
				p1.setName("Marta");
				p1.setPatientCode("A_X123456-67890");
				p1.setPersonCode("030403-12345");
				p1.setPhoneNr("+371 23679013");
				p1.setSurname("Zapacka");
				p1.setAddress(a3);
				patientRepo.save(p1);
				
				Patient p2 = new Patient();
				p2.setName("Paula");
				p2.setPatientCode("B_L231450-12345");
				p2.setPersonCode("091289-87634");
				p2.setPhoneNr("+371 20678921");
				p2.setSurname("Liepa");
				p2.setAddress(a2);
				patientRepo.save(p2);
				
				Patient p3 = new Patient();
				p3.setName("Gatis");
				p3.setPatientCode("D_O398345");
				p3.setPersonCode("130599-27654");
				p3.setPhoneNr("+371 26660891");
				p3.setSurname("Kandis");
				p3.setAddress(a1);
				patientRepo.save(p3);
				
				// Medical appointment
				MedicalAppointment app1 = new MedicalAppointment();
				app1.setDoctor(doc2);
				app1.setPatient(p1);
				app1.setDateTime(LocalDateTime.now().plusDays(4).withHour(9).withMinute(30));
				app1.setCabinet("A107");
				medAppRepo.save(app1);
				
				MedicalAppointment app2 = new MedicalAppointment();
				app2.setDoctor(doc1);
				app2.setPatient(p3);
				app2.setDateTime(LocalDateTime.now().withHour(12).withMinute(20));
				app2.setCabinet("D304");
				medAppRepo.save(app2);
				
				MedicalAppointment app3 = new MedicalAppointment();
				app3.setDoctor(doc3);
				app3.setPatient(p2);
				app3.setDateTime(LocalDateTime.now().plusWeeks(3).withHour(14).withMinute(45));
				app3.setCabinet("F211");
				medAppRepo.save(app3);
				
				// Medicine
				Medicine med1 = new Medicine();
				med1.setExpiryDate(LocalDate.now().withYear(2029).withMonth(9));
				med1.setDosage("37,5mg");
				med1.setManufacturer("Venlaxor");
				med1.setUsage("Trauskmei");
				med1.setUsageInstructions("1 tablete diena");
				medicineRepo.save(med1);
				
				Medicine med2 = new Medicine();
				med2.setExpiryDate(LocalDate.now().withYear(2025).withMonth(10));
				med2.setDosage("100mg");
				med2.setManufacturer("Cinie");
				med2.setUsage("Migrenai");
				med2.setUsageInstructions("1 tablete diena");
				medicineRepo.save(med2);
				
				Medicine med3 = new Medicine();
				med3.setExpiryDate(LocalDate.now().withYear(2029).withMonth(6));
				med3.setDosage("3mg");
				med3.setManufacturer("YAZ");
				med3.setUsage("Kontracepcija");
				med3.setUsageInstructions("1 tablete diena");
				medicineRepo.save(med3);
				
				// Patient disease history
				PatientDiseaseH h1 = new PatientDiseaseH();
				h1.setDisease(Disease.Gripa);
				h1.setDiseaseStart(LocalDate.of(2024, 11, 7));
				h1.setPresent(false);
				h1.setPatient(p3);
				h1.setSeverity(7);
				h1.setNotes("Stipra gripa ar augstu temperaturu");
				patDisHRepo.save(h1);
				
				PatientDiseaseH h2 = new PatientDiseaseH();
				h2.setDisease(Disease.Migrēna);
				h2.setDiseaseStart(LocalDate.of(2019, 3, 16));
				h2.setPresent(true);
				h1.setPatient(p1);
				h1.setSeverity(10);
				h1.setNotes("Stipras galvassapes, kermena tirpsana un redzes problemas");
				patDisHRepo.save(h2);
				
				PatientDiseaseH h3 = new PatientDiseaseH();
				h3.setDisease(Disease.Saaukstēšanās);
				h3.setDiseaseStart(LocalDate.of(2025, 4, 10));
				h3.setPresent(true);
				h3.setPatient(p2);
				h3.setSeverity(6);
				h3.setNotes("Augsta temperatura, iesnas un klepus");
				patDisHRepo.save(h3);
				
			}
			
			
		};
	}

}
