package entities;
import java.io.Serializable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.Set;


/**
 * The persistent class for the manufacturer database table.
 * 
 */
@NamedQueries({
	@NamedQuery(name = "Manufacturer.findAll", query = "select o from Manufacturer o"),
	@NamedQuery(name = "Manufacturer.findByName", query = "select o from Manufacturer o where o.manufacturerName=:manufacturerName"), })

@Entity
@XmlRootElement
public class Manufacturer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int manufacturerID;

	private String manufacturerName;

	//bi-directional many-to-one association to Userequipment
	@OneToMany(mappedBy="manufacturer", fetch = FetchType.EAGER)
	private Set<UserEquipment> userequipments;

    public Manufacturer() {
    }
    
    public Manufacturer(String manufacturerName) {
		super();
		this.manufacturerName = manufacturerName;
	}

	public int getManufacturerID() {
		return this.manufacturerID;
	}

	public void setManufacturerID(int manufacturerID) {
		this.manufacturerID = manufacturerID;
	}

	public String getManufacturerName() {
		return this.manufacturerName;
	}

	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}

//	public Set<UserEquipment> getUserequipments() {
//		return this.userequipments;
//	}
//
//	public void setUserequipments(Set<UserEquipment> userequipments) {
//		this.userequipments = userequipments;
//	}
	
}