package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries({
		@NamedQuery(name = "MCCMNC.findAll", query = "select o from MCCMNC o"),
		@NamedQuery(name = "MCCMNC.findMCCMNCById", query = "select o from MCCMNC o where o.mccmncID=:mccmncID"),
		@NamedQuery(name = "MCCMNC.findMCCMNCByName", query = "select o from MCCMNC o where o.mcc=:mcc and o.mnc=:mnc") })
@Entity
public class MCCMNC {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int mccmncID;
	private int mcc;
	private int mnc;
	private String operator;

	public MCCMNC() {

	}

	public MCCMNC(int mcc, int mnc, String operator) {
		super();
		this.mcc = mcc;
		this.mnc = mnc;
		this.operator = operator;
	}

	public int getMccmncID() {
		return mccmncID;
	}

	public void setMccmncID(int mccmncID) {
		this.mccmncID = mccmncID;
	}

	public int getMcc() {
		return mcc;
	}

	public void setMcc(int mcc) {
		this.mcc = mcc;
	}

	public int getMnc() {
		return mnc;
	}

	public void setMnc(int mnc) {
		this.mnc = mnc;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

}
