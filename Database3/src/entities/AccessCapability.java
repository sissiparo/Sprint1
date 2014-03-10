package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

@NamedQueries({ @NamedQuery(name = "AccessCapability.findByAccessCapability", query = "select o from AccessCapability o where o.accessCapability=:accessCapability"), })
@Entity
@XmlRootElement
public class AccessCapability {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int accessID;

	private String accessCapability;

	public AccessCapability() {

	}

	public AccessCapability(String accessCapability) {
		super();
		this.accessCapability = accessCapability;
	}

	public int getAccessID() {
		return accessID;
	}

	public void setAccessID(int accessID) {
		this.accessID = accessID;
	}

	public String getAccessCapability() {
		return accessCapability;
	}

	public void setAccessCapability(String accessCapability) {
		this.accessCapability = accessCapability;
	}

}
