package entities;

import java.io.Serializable;

public class UE_AccessCapabilityId implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userEquipID;
	private int accessCapabilityID;

	public UE_AccessCapabilityId() {
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

	public int hashCode() {
		return (int) userEquipID.hashCode();
	}

	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof UE_AccessCapabilityId))
			return false;
		UE_AccessCapabilityId pk = (UE_AccessCapabilityId) obj;
		return pk.accessCapabilityID == accessCapabilityID
				&& pk.userEquipID.equals(userEquipID);
	}
}