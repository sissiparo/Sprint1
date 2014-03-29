package entity;
import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the basedata database table.
 * 
 */
@Entity
public class BaseData implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int baseDataID;

    //@Temporal( TemporalType.DATE)
	private java.sql.Timestamp baseDate;

	private int duration;

	private String imsi;

	private String neVersion;

	//bi-directional many-to-one association to Celltable
    @ManyToOne
	@JoinColumn(name="cellID")
	private CellTable celltable;

	//bi-directional many-to-one association to Failure
    @ManyToOne
	@JoinColumn(name="failureClassID")
	private Failure failure;

	//bi-directional many-to-one association to Eventcause
    @ManyToOne
	@JoinColumn(name="eventCauseID")
	private EventCause eventcause;

	//bi-directional many-to-one association to Mccmnc
    @ManyToOne
	@JoinColumn(name="mccmncID")
	private MCCMNC mccmnc;

	//bi-directional many-to-one association to Userequipment
    @ManyToOne
	@JoinColumn(name="TAC")
	private UserEquipment userequipment;

    public BaseData() {
    }

   
    
    public BaseData(EventCause eventcause, MCCMNC mccmnc, CellTable celltable, int duration,
    		String imsi, Failure failure, UserEquipment userequipment, String neVersion,
    		java.sql.Timestamp baseDate) {
		super();

		this.userequipment = userequipment;
		this.mccmnc = mccmnc;
		this.eventcause = eventcause;
		this.failure = failure;
		this.celltable = celltable;
		this.imsi = imsi;
		this.duration = duration;
		this.neVersion = neVersion;
		this.baseDate = baseDate;
    }
	public int getBaseDataID() {
		return this.baseDataID;
	}

	public void setBaseDataID(int baseDataID) {
		this.baseDataID = baseDataID;
	}

	

	public java.sql.Timestamp getBaseDate() {
		return baseDate;
	}



	public void setBaseDate(java.sql.Timestamp baseDate) {
		this.baseDate = baseDate;
	}



	public int getDuration() {
		return this.duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getImsi() {
		return this.imsi;
	}

	public void setImsi(String imsi) {
		this.imsi = imsi;
	}

	public String getNeVersion() {
		return this.neVersion;
	}

	public void setNeVersion(String neVersion) {
		this.neVersion = neVersion;
	}

	public CellTable getCelltable() {
		return this.celltable;
	}

	public void setCelltable(CellTable celltable) {
		this.celltable = celltable;
	}
	
	public Failure getFailure() {
		return this.failure;
	}

	public void setFailure(Failure failure) {
		this.failure = failure;
	}
	
	public EventCause getEventcause() {
		return this.eventcause;
	}

	public void setEventcause(EventCause eventcause) {
		this.eventcause = eventcause;
	}
	
	public MCCMNC getMccmnc() {
		return this.mccmnc;
	}

	public void setMccmnc(MCCMNC mccmnc) {
		this.mccmnc = mccmnc;
	}
	
	public UserEquipment getUserequipment() {
		return this.userequipment;
	}

	public void setUserequipment(UserEquipment userequipment) {
		this.userequipment = userequipment;
	}
	
}