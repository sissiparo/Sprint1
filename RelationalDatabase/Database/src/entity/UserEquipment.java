package entity;
import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the userequipment database table.
 * 
 */
@NamedQueries({ @NamedQuery(name = "UserEquipment.findTAC", query = "select o from UserEquipment o where o.tac=:tac"), })

@Entity
public class UserEquipment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String tac;

	private String ueInputMode;

	private String ueOperatingSys;

	private String ueType;

	//bi-directional many-to-one association to Basedata
	@OneToMany(mappedBy="userequipment")
	private Set<BaseData> basedata;

	//bi-directional many-to-one association to Manufacturer
    @ManyToOne
	@JoinColumn(name="ueManufacturerId")
	private Manufacturer manufacturer;

	//bi-directional many-to-one association to Uemodel
    @ManyToOne
	@JoinColumn(name="ueModelId")
	private UEModel uemodel;

    public UserEquipment() {
    }

    public UserEquipment(String tac, Manufacturer manufacturer, UEModel uemodel,
			String ueType, String ueOperatingSys, String ueInputMode) {

		super();
		this.tac = tac;
		this.manufacturer = manufacturer;
		this.uemodel = uemodel;
		this.ueType = ueType;
		this.ueOperatingSys = ueOperatingSys;
		this.ueInputMode = ueInputMode;
	}
    
	public String getTac() {
		return this.tac;
	}

	public void setTac(String tac) {
		this.tac = tac;
	}

	public String getUeInputMode() {
		return this.ueInputMode;
	}

	public void setUeInputMode(String ueInputMode) {
		this.ueInputMode = ueInputMode;
	}

	public String getUeOperatingSys() {
		return this.ueOperatingSys;
	}

	public void setUeOperatingSys(String ueOperatingSys) {
		this.ueOperatingSys = ueOperatingSys;
	}

	public String getUeType() {
		return this.ueType;
	}

	public void setUeType(String ueType) {
		this.ueType = ueType;
	}

	public Set<BaseData> getBasedata() {
		return this.basedata;
	}

	public void setBasedata(Set<BaseData> basedata) {
		this.basedata = basedata;
	}
	
	public Manufacturer getManufacturer() {
		return this.manufacturer;
	}

	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	public UEModel getUemodel() {
		return this.uemodel;
	}

	public void setUemodel(UEModel uemodel) {
		this.uemodel = uemodel;
	}
	
}