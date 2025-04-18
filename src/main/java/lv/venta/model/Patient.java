package lv.venta.model;

import java.util.ArrayList;
import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "PatientTable")
@Entity

public class Patient {

	@Id
	@Column(name = "PId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter(value = AccessLevel.NONE)
	private int pid;
	
	@OneToMany(mappedBy = "patient")
    @ToString.Exclude
    private Collection<MedicalAppointment> medicalAppointment = new ArrayList<MedicalAppointment>();
	
	@OneToMany(mappedBy = "patient")
    @ToString.Exclude
    private Collection<PatientDiseaseH> patientDiseaseH = new ArrayList<PatientDiseaseH>();
	
	@Column(name = "Name")
	@NotNull
	@Pattern(regexp = "[A-ZĒŪĪĻĶĢŠĀČŅa-zēūīļķģšāžčņ ]+")
	private String name;
	
	@Column(name = "PatientCode")
	@NotNull
	@Pattern(regexp = "^[A-Z]_[A-Z]?[0-9]{6}-[0-9]{5}$")
	private String patientCode;
	
	@Column(name = "PersonCode")
	@NotNull
	@Min(12)
	@Max(12)
	@Pattern(regexp = "[0-9]{6}-[0-9]{5}")
	private String personCode;
	
	@Column(name = "PhoneNumber")
	@NotNull
	@Pattern(regexp = "^\\+371 [2-9][0-9]{7}$")
    private String phoneNr;
	
	@Column(name = "Surname")
	@NotNull
	@Pattern(regexp = "[A-ZĒŪĪĻĶĢŠĀČŅa-zēūīļķģšāžčņ ]+")
	private String surname;
	
	@ManyToOne
	@JoinColumn(name = "AId")
	@NotNull
	private Address address;
	
	
	
	public Patient(String name, String patientCode, String personCode, String phoneNr, String surname, Address address) {
       setName(name);
       setPatientCode(patientCode);
       setPersonCode(personCode);
       setPhoneNr(phoneNr);
       setSurname(surname);
       setAddress(address);
       
	}
	
}
