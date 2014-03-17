package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries({
		@NamedQuery(name = "UEModel.findByName", query = "select o from UEModel o where o.modelName=:modelName"), })
@Entity
public class UEModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int modelId;
	private String modelName;

	public UEModel() {

	}

	public UEModel(String modelName) {
		super();
		this.modelName = modelName;

	}

	public int getModelID() {
		return modelId;
	}

	public void setModelID(int modelID) {
		this.modelId = modelID;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
}
