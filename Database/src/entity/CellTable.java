package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries({
	@NamedQuery(name = "CellTable.findByCellID", query = "select o from CellTable o where o.cellID=:cellID"),
 })

@Entity
public class CellTable {

	
	@Id
	private int cellID;

	private String hier3_ID, hier32_ID, hier321_ID;

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
		return cellID;
	}

	public void setCellID(int cellID) {
		this.cellID = cellID;
	}

	public String getHier3_ID() {
		return hier3_ID;
	}

	public void setHier3_ID(String hier3_ID) {
		this.hier3_ID = hier3_ID;
	}

	public String getHier32_ID() {
		return hier32_ID;
	}

	public void setHier32_ID(String hier32_ID) {
		this.hier32_ID = hier32_ID;
	}

	public String getHier321_ID() {
		return hier321_ID;
	}

	public void setHier321_ID(String hier321_ID) {
		this.hier321_ID = hier321_ID;
	}

}
