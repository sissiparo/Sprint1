package entity;
import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the celltable database table.
 * 
 */
@NamedQueries({
	@NamedQuery(name = "CellTable.findByCellID", query = "select o from CellTable o where o.cellID=:cellID"),
 })
@Entity
public class CellTable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int cellID;

	private String hier3_ID;

	private String hier32_ID;

	private String hier321_ID;

	//bi-directional many-to-one association to Basedata
	@OneToMany(mappedBy="celltable")
	private Set<BaseData> basedata;

    public CellTable() {
    }
    
    public CellTable(int cellID, String hier3_ID, String hier32_ID,
			String hier321_ID) {
		super();
		this.cellID = cellID;
		this.hier3_ID = hier3_ID;
		this.hier32_ID = hier32_ID;
		this.hier321_ID = hier321_ID;
	}

	public int getCellID() {
		return this.cellID;
	}

	public void setCellID(int cellID) {
		this.cellID = cellID;
	}

	public String getHier3_ID() {
		return this.hier3_ID;
	}

	public void setHier3_ID(String hier3_ID) {
		this.hier3_ID = hier3_ID;
	}

	public String getHier32_ID() {
		return this.hier32_ID;
	}

	public void setHier32_ID(String hier32_ID) {
		this.hier32_ID = hier32_ID;
	}

	public String getHier321_ID() {
		return this.hier321_ID;
	}

	public void setHier321_ID(String hier321_ID) {
		this.hier321_ID = hier321_ID;
	}

	public Set<BaseData> getBasedata() {
		return this.basedata;
	}

	public void setBasedata(Set<BaseData> basedata) {
		this.basedata = basedata;
	}
	
}