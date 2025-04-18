package lv.venta.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lv.venta.enums.Disease;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "PatientDiseasHTable")
@Entity

public class PatientDiseaseH {

	@Id
	@Column(name = "PDHId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter(value = AccessLevel.NONE)
	@ManyToMany(mappedBy = "mid")
	private int pdhid;
	
	@Column(name = "Disease")
	@ManyToOne
	@NotNull
    private Disease disease;
	
	@Column(name = "DiseaseStartingDate")
	private LocalDate diseaseStart;
	
	@Column(name = "IsPresent")
	private boolean isPresent;
	
	@ManyToOne
	@JoinColumn(name = "PId")
	@NotNull
	private Patient patient;
	
	@Column(name = "Severity")
	@Min(1)
	@Max(10)
	private int severity;
	
	@Column(name = "Notes")
	private String notes;
	
	public PatientDiseaseH(Disease disease, LocalDate diseaseStart, boolean isPresent, Patient patient, int severity, String notes) {
		setDisease(disease);
		setDiseaseStart(diseaseStart);
		setPresent(isPresent);
		setPatient(patient);
		setSeverity(severity);
		setNotes(notes);
	}
}
