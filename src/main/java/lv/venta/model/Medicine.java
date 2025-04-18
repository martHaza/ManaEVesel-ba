package lv.venta.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Future;
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
@Table(name = "MedicineTable")
@Entity

public class Medicine {

	@Column(name = "ExpiryDate")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Future(message = "Derīguma termiņam jābūt nākotnē")
	@NotNull
	private LocalDate expiryDate;
	
	@Setter(value = AccessLevel.NONE)
	@Id
	@Column(name = "MId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ManyToMany(mappedBy = "pdhid")
	private int mid;
	
	@Column(name = "Dosage")
	private String dosage;
	
	@Column(name = "Manufacturer")
	private String manufacturer;
	
	@Column(name = "Usage")
    private String usage;
	
	@Column(name = "UsageInstructions")
    private String usageInstructions;
	
	public Medicine(LocalDate expiryDate, String dosage, String manufacturer, String usage, String usageInstructions) {
		setExpiryDate(expiryDate);
		setDosage(dosage);
		setManufacturer(manufacturer);
		setUsage(usage);
		setUsageInstructions(usageInstructions);
	}
	
}
