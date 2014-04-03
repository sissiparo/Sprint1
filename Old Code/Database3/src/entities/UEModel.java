package entities;
import java.io.Serializable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.Set;


/**
 * The persistent class for the uemodel database table.
 * 
 */
@NamedQueries({
	@NamedQuery(name = "UEModel.findByName", query = "select o from UEModel o where o.modelName=:modelName"), })

@Entity
@XmlRootElement
public class UEModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int modelId;

	private String modelName;

	//bi-directional many-to-one association to Userequipment
	@OneToMany(mappedBy="uemodel", fetch = FetchType.EAGER)
	private Set<UserEquipment> userequipments;

    public UEModel() {
    }

    public UEModel(String modelName) {
		super();
		this.modelName = modelName;

	}
	public int getModelId() {
		return this.modelId;
	}

	public void setModelId(int modelId) {
		this.modelId = modelId;
	}

	public String getModelName() {
		return this.modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

//	public Set<UserEquipment> getUserequipments() {
//		return this.userequipments;
//	}
//
//	public void setUserequipments(Set<UserEquipment> userequipments) {
//		this.userequipments = userequipments;
//	}
	
}