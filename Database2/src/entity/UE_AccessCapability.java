package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(UE_AccessCapabilityId.class)
public class UE_AccessCapability {

	@Id
	String userEquipID;

	@Id
	int accessCapabilityID;

	public UE_AccessCapability() {

	}

	public UE_AccessCapability(String userEquipID, int accessCapabilityID) {
		super();
		this.userEquipID = userEquipID;
		this.accessCapabilityID = accessCapabilityID;
	}

	public String getUserEquipID() {
		return userEquipID;
	}

	public void setUserEquipID(String userEquipID) {
		this.userEquipID = userEquipID;
	}

	public int getAccessCapabilityID() {
		return accessCapabilityID;
	}

	public void setAccessCapabilityID(int accessCapabilityID) {
		this.accessCapabilityID = accessCapabilityID;
	}

}
