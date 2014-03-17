package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries( {
	@NamedQuery(name = "EventCause.findEventID", query = "select o from EventCause o where o.eventID=:eventID"),
	@NamedQuery(name = "EventCause.findEventIDAndCauseCode", query = "select o from EventCause o where o.eventID=:eventID and o.causeCode=:causeCode")
})
@Entity
public class EventCause {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int eventcauseCode;
	private int causeCode, eventID;
	private String causeDescription;

	public EventCause() {

	}

	public EventCause(int causeCode, int eventID, String causeDescription) {
		super();
		this.causeCode = causeCode;
		this.eventID = eventID;
		this.causeDescription = causeDescription;
	}

	public int getEventcauseCode() {
		return eventcauseCode;
	}

	public void setEventcauseCode(int eventcauseCode) {
		this.eventcauseCode = eventcauseCode;
	}

	public int getcauseCode() {
		return causeCode;
	}

	public void setcauseCode(int causeCode) {
		this.causeCode = causeCode;
	}

	public int getEventID() {
		return eventID;
	}

	public void setEventID(int eventID) {
		this.eventID = eventID;
	}

	public String getCauseDescription() {
		return causeDescription;
	}

	public void setCauseDescription(String causeDescription) {
		this.causeDescription = causeDescription;
	}

}
