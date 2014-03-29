//package entity;
//import java.io.Serializable;
//import javax.persistence.*;
//
///**
// * The primary key class for the ue_accesscapability database table.
// * 
// */
//@Embeddable
//public class UeAccesscapabilityPK implements Serializable {
//	//default serial version id, required for serializable classes.
//	private static final long serialVersionUID = 1L;
//
//	private int accessCapabilityID;
//
//	private String userEquipID;
//
//    public UeAccesscapabilityPK() {
//    }
//    
//    public UeAccesscapabilityPK(String userEquipID, int accessCapabilityID) {
//		super();
//		this.userEquipID = userEquipID;
//		this.accessCapabilityID = accessCapabilityID;
//	}
//    
//	public int getAccessCapabilityID() {
//		return this.accessCapabilityID;
//	}
//	public void setAccessCapabilityID(int accessCapabilityID) {
//		this.accessCapabilityID = accessCapabilityID;
//	}
//	public String getUserEquipID() {
//		return this.userEquipID;
//	}
//	public void setUserEquipID(String userEquipID) {
//		this.userEquipID = userEquipID;
//	}
//
//	public boolean equals(Object other) {
//		if (this == other) {
//			return true;
//		}
//		if (!(other instanceof UeAccesscapabilityPK)) {
//			return false;
//		}
//		UeAccesscapabilityPK castOther = (UeAccesscapabilityPK)other;
//		return 
//			(this.accessCapabilityID == castOther.accessCapabilityID)
//			&& this.userEquipID.equals(castOther.userEquipID);
//
//    }
//    
//	public int hashCode() {
//		final int prime = 31;
//		int hash = 17;
//		hash = hash * prime + this.accessCapabilityID;
//		hash = hash * prime + this.userEquipID.hashCode();
//		
//		return hash;
//    }
//}