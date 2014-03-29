package entity;
import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the failure database table.
 * 
 */
@NamedQueries({ @NamedQuery(name = "Failure.findFailureCode", query = "select o from Failure o where o.failureID=:failureID"), })

@Entity
public class Failure implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int failureID;

	private String failureDescription;

	//bi-directional many-to-one association to Basedata
	@OneToMany(mappedBy="failure")
	private Set<BaseData> basedata;

    public Failure() {
    }

    public Failure(int failureID, String failureDescription) {
		super();
		this.failureID = failureID;
		this.failureDescription = failureDescription;
	}
    
	public int getFailureID() {
		return this.failureID;
	}

	public void setFailureID(int failureID) {
		this.failureID = failureID;
	}

	public String getFailureDescription() {
		return this.failureDescription;
	}

	public void setFailureDescription(String failureDescription) {
		this.failureDescription = failureDescription;
	}

	public Set<BaseData> getBasedata() {
		return this.basedata;
	}

	public void setBasedata(Set<BaseData> basedata) {
		this.basedata = basedata;
	}
	
}