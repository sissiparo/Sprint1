package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries({ @NamedQuery(name = "Failure.findFailureCode", query = "select o from Failure o where o.failureID=:failureID"), })
@Entity
public class Failure {

	@Id
	private int failureID;
	private String failureDescription;

	public Failure() {

	}

	public Failure(int failureID, String failureDescription) {
		super();
		this.failureID = failureID;
		this.failureDescription = failureDescription;
	}

	public int getFailureID() {
		return failureID;
	}

	public void setFailureID(int failureID) {
		this.failureID = failureID;
	}

	public String getFailureDescription() {
		return failureDescription;
	}

	public void setFailureDescription(String failureDescription) {
		this.failureDescription = failureDescription;
	}

}
