package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries({
		@NamedQuery(name = "Manufacturer.findAll", query = "select o from Manufacturer o"),
		@NamedQuery(name = "Manufacturer.findByName", query = "select o from Manufacturer o where o.manufacturerName=:manufacturerName"), })
@Entity
public class Manufacturer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int manufacturerID;
	private String manufacturerName;

	public Manufacturer() {

	}

	public Manufacturer(String manufacturerName) {
		super();
		this.manufacturerName = manufacturerName;
	}

	public int getManufacturerID() {
		return manufacturerID;
	}

	public void setManufacturerID(int manufacturerID) {
		this.manufacturerID = manufacturerID;
	}

	public String getManufacturerName() {
		return manufacturerName;
	}

	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}

}
