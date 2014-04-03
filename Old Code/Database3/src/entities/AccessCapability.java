package entities;
import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;



/**
 * The persistent class for the accesscapability database table.
 * 
 */
@NamedQueries({ @NamedQuery(name = "AccessCapability.findByAccessCapability", query = "select o from AccessCapability o where o.accessCapability=:accessCapability"), })

@Entity
@Table (name="AccessCapability")
public class AccessCapability implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int accessID;
	@Column
	private String accessCapability;

	//bi-directional many-to-one association to UeAccesscapability
//	@OneToMany(mappedBy="accesscapability")
//	private Set<UeAccessCapability> ueAccesscapabilities;

    public AccessCapability() {
    }

    public AccessCapability(String accessCapability) {
		super();
		this.accessCapability = accessCapability;
	}
	public int getAccessID() {
		return this.accessID;
	}

	public void setAccessID(int accessID) {
		this.accessID = accessID;
	}

	public String getAccessCapability() {
		return this.accessCapability;
	}

	public void setAccessCapability(String accessCapability) {
		this.accessCapability = accessCapability;
	}

//	public Set<UeAccessCapability> getUeAccesscapabilities() {
//		return this.ueAccesscapabilities;
//	}
//
//	public void setUeAccesscapabilities(Set<UeAccessCapability> ueAccesscapabilities) {
//		this.ueAccesscapabilities = ueAccesscapabilities;
//	}
	
}