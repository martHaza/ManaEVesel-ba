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
import lv.venta.enums.City;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Table (name = "AddressTable")
@Entity

public class Address {
	
	@Setter(value = AccessLevel.NONE)
	@Id
	@Column(name = "AId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int aid;
	
	@OneToMany(mappedBy = "address")
    @ToString.Exclude
    private Collection<Patient> patient = new ArrayList<Patient>();
	
	@Enumerated(EnumType.STRING)
	@Column(name = "City")
	@NotNull
	private City city;
	
	@Column(name = "HouseNr")
	@Min(1)
	@Max(9999)
	private int houseNr;
	
	@Column(name="StreetOrHouseTitle")
	@NotNull
	@Min(4)
	@Max(50)
	@Pattern(regexp = "[A-ZĒŪĪĻĶĢŠĀČŅa-zēūīļķģšāžčņ ]+")
	private String streetOrHouseTitle;
	
	public Address(City city, int houseNr, String streetOrHouseTitle) {
		setCity(city);
		setHouseNr(houseNr);
		setStreetOrHouseTitle(streetOrHouseTitle);
		
	}
	
	
	
}
