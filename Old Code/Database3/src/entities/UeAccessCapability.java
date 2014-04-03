package entities;
//package entity;
//import java.io.Serializable;
//import javax.persistence.*;
//
//
///**
// * The persistent class for the ue_accesscapability database table.
// * 
// */
//@Entity
//@Table(name="ue_accesscapability")
//public class UeAccessCapability implements Serializable {
//	private static final long serialVersionUID = 1L;
//
//	@EmbeddedId
//	private UeAccesscapabilityPK id;
//
//	//bi-directional many-to-one association to Accesscapability
//    @ManyToOne
//	@JoinColumn(name="accessCapabilityID")
//	private AccessCapability accesscapability;
//
//    public UeAccessCapability() {
//    }
//
//	public UeAccesscapabilityPK getId() {
//		return this.id;
//	}
//
//	public void setId(UeAccesscapabilityPK id) {
//		this.id = id;
//	}
//	
//	public AccessCapability getAccesscapability() {
//		return this.accesscapability;
//	}
//
//	public void setAccesscapability(AccessCapability accesscapability) {
//		this.accesscapability = accesscapability;
//	}
//	
//}