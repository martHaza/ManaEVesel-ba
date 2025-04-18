package lv.venta.model;

import java.util.ArrayList;
import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lv.venta.enums.DoctorType;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "DoctorTable")
@Entity

public class Doctor {

	@Id
	@Column(name = "DId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter(value = AccessLevel.NONE)
	private int did;
	
	@OneToMany(mappedBy = "doctor")
    @ToString.Exclude
    private Collection<MedicalAppointment> medicalAppointment = new ArrayList<MedicalAppointment>();
	
	@Enumerated(EnumType.STRING)
	@Column(name = "DoctorType")
	@NotNull
	private DoctorType doctorType;
	
	@Column(name = "ExperienceInYears")
	@Min(0)
	@Max(50)
	private int experienceInYears;
	
	@Column(name = "CertificateNr")
	@NotNull
	@Pattern(regexp = "^IU[0-9]{2,5}$")
	private String certificateNr;
	
	@Column(name = "Name")
	@NotNull
	@Pattern(regexp = "[A-ZĒŪĪĻĶĢŠĀČŅa-zēūīļķģšāžčņ ]+")
	private String name;
	
	@Column(name = "PersonCode")
	@NotNull
	@Size(min = 12, max = 12)
	@Pattern(regexp = "[0-9]{6}-[0-9]{5}")
	private String personCode;
	
	@Column(name = "Surname")
	@NotNull
	@Pattern(regexp = "[A-ZĒŪĪĻĶĢŠĀČŅa-zēūīļķģšāžčņ ]+")
	private String surname;
	
	public Doctor(DoctorType doctorType, int experienceInYears, String certificateNr, String name, String personCode, String surname) {
		setDoctorType(doctorType);
		setExperienceInYears(experienceInYears);
		setCertificateNr(certificateNr);
		setName(name);
		setPersonCode(personCode);
		setSurname(surname);
	}
}
