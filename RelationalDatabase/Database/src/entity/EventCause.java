package entity;
import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the eventcause database table.
 * 
 */
@NamedQueries( {
	@NamedQuery(name = "EventCause.findEventID", query = "select o from EventCause o where o.eventID=:eventID"),
	@NamedQuery(name = "EventCause.findEventIDAndCauseCode", query = "select o from EventCause o where o.eventID=:eventID and o.causeCode=:causeCode")
})
@Entity
public class EventCause implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int eventcauseCode;

	private int causeCode;

	private String causeDescription;

	private int eventID;

	//bi-directional many-to-one association to Basedata
	@OneToMany(mappedBy="eventcause")
	private Set<BaseData> basedata;

    public EventCause() {
    }

    public EventCause(int causeCode, int eventID, String causeDescription) {
		super();

		this.causeCode = causeCode;
		this.eventID = eventID;
		this.causeDescription = causeDescription;
	}
    
	public int getEventcauseCode() {
		return this.eventcauseCode;
	}

	public void setEventcauseCode(int eventcauseCode) {
		this.eventcauseCode = eventcauseCode;
	}

	public int getCauseCode() {
		return this.causeCode;
	}

	public void setCauseCode(int causeCode) {
		this.causeCode = causeCode;
	}

	public String getCauseDescription() {
		return this.causeDescription;
	}

	public void setCauseDescription(String causeDescription) {
		this.causeDescription = causeDescription;
	}

	public int getEventID() {
		return this.eventID;
	}

	public void setEventID(int eventID) {
		this.eventID = eventID;
	}

	public Set<BaseData> getBasedata() {
		return this.basedata;
	}

	public void setBasedata(Set<BaseData> basedata) {
		this.basedata = basedata;
	}
	
}