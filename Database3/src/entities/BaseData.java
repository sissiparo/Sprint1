package entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class BaseData {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int baseDataID;

	private int mccmncID, cellID, duration, eventCauseID;
	private String TAC, failureClassID, neVersion, imsi;
	
	
//	private Date baseDate;
	
	public BaseData() {

	}

	public BaseData(int eventCauseID, int mccmncID, int cellID, int duration,
			String imsi, String failureClassID, String TAC, String neVersion,
			Date baseDate) {
		super();

		this.eventCauseID = eventCauseID;
		this.failureClassID = failureClassID;
		this.mccmncID = mccmncID;
		this.cellID = cellID;
		this.imsi = imsi;
		this.duration = duration;
		this.TAC = TAC;
		this.neVersion = neVersion;
//		this.baseDate = baseDate;
	}
	

	public int getBaseDataID() {
		return baseDataID;
	}

	public void setBaseDataID(int baseDataID) {
		this.baseDataID = baseDataID;
	}

	public int getMccmncID() {
		return mccmncID;
	}

	public void setMccmncID(int mccmncID) {
		this.mccmncID = mccmncID;
	}

	public int getCellID() {
		return cellID;
	}

	public void setCellID(int cellID) {
		this.cellID = cellID;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getTAC() {
		return TAC;
	}

	public void setTAC(String tAC) {
		TAC = tAC;
	}

	public String getFailureClassID() {
		return failureClassID;
	}

	public void setFailureClassID(String failureClassID) {
		this.failureClassID = failureClassID;
	}

	public String getNeVersion() {
		return neVersion;
	}

	public void setNeVersion(String neVersion) {
		this.neVersion = neVersion;
	}

	public String getImsi() {
		return imsi;
	}

	public void setImsi(String imsi) {
		this.imsi = imsi;
	}

	public int getEventCauseID() {
		return eventCauseID;
	}

	public void setEventCauseID(int eventCauseID) {
		this.eventCauseID = eventCauseID;
	}

//	public Date getBaseDate() {
//		return baseDate;
//	}
//
//	public void setBaseDate(Date baseDate) {
//		this.baseDate = baseDate;
//	}
}
