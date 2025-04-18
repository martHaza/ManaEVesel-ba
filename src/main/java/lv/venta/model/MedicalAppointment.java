package lv.venta.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "MedicalAppointmentTable")
@Entity

public class MedicalAppointment {

	@Setter(value = AccessLevel.NONE)
	@Id
	@Column(name = "MDid")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int mdid;
	
	@ManyToOne
	@JoinColumn(name = "DId")
	private Doctor doctor;
	
	@JoinColumn(name = "PId")
	@ManyToOne
	@NotNull
	private Patient patient;
	
	@Column(name = "DateTime")
	@NotNull
	private LocalDateTime dateTime;
	
	@Column(name = "Cabinet")
	private String cabinet;
	
	public MedicalAppointment(Doctor doctor, Patient patient, LocalDateTime dateTime, String cabinet) {
		setDoctor(doctor);
		setPatient(patient);
		setDateTime(dateTime);
		setCabinet(cabinet);
	}
	
}
