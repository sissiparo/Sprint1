package persistence;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entity.AccessCapability;
import entity.BaseData;
import entity.CellTable;
import entity.Country;
import entity.EventCause;
import entity.Failure;
import entity.Manufacturer;
import entity.MCCMNC;
import entity.UEModel;
import entity.User;
import entity.UserEquipment;

public class PersistenceUtil implements Serializable {

	private static final long serialVersionUID = 1L;

	protected static EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("testdb");

	public static void persist(Object entity) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
		em.close();
	}

	public static void remove(Object entity) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Object mergedEntity = em.merge(entity);
		em.remove(mergedEntity);
		em.getTransaction().commit();
		em.close();
	}

	public static Object merge(Object entity) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		entity = em.merge(entity);
		em.getTransaction().commit();
		em.close();
		return entity;
	}

	public static EntityManager createEM() {
		return emf.createEntityManager();
	}

	public static AccessCapability findAccessCapability(String accessCapability) {

		EntityManager em = emf.createEntityManager();
		List<AccessCapability> accessCapabilities = (List<AccessCapability>) em
				.createNamedQuery("AccessCapability.findByAccessCapability")
				.setParameter("accessCapability", accessCapability)
				.getResultList();
		em.close();

		if (accessCapabilities.size() == 0)
			return null;
		else
			return accessCapabilities.get(0);
	}

	public static Country findCountry(int mcc) {

		EntityManager em = emf.createEntityManager();
		List<Country> countries = (List<Country>) em
				.createNamedQuery("Country.findByMCC").setParameter("mcc", mcc)
				.getResultList();
		em.close();

		if (countries.size() == 0)
			return null;
		else
			return countries.get(0);
	}

	
	public static CellTable findByCellID(int cellID) {

		EntityManager em = emf.createEntityManager();
		List<CellTable> cellTables = (List<CellTable>) em
				.createNamedQuery("CellTable.findByCellID").setParameter("cellID", cellID)
				.getResultList();
		em.close();

		if (cellTables.size() == 0)
			return null;
		else
			return cellTables.get(0);
	}
	
	public static Manufacturer findManufacturerByName(String manufacturerName) {

		EntityManager em = emf.createEntityManager();
		List<Manufacturer> manufacturers = (List<Manufacturer>) em
				.createNamedQuery("Manufacturer.findByName")
				.setParameter("manufacturerName", manufacturerName)
				.getResultList();
		em.close();

		if (manufacturers.size() == 0)
			return null;
		else
			return manufacturers.get(0);
	}

	public static UEModel findUEModelByName(String modelName) {

		EntityManager em = emf.createEntityManager();
		List<UEModel> ueModels = (List<UEModel>) em
				.createNamedQuery("UEModel.findByName")
				.setParameter("modelName", modelName).getResultList();
		em.close();

		if (ueModels.size() == 0)
			return null;
		else
			return ueModels.get(0);
	}

	public static MCCMNC findMCCMNCByName(int mcc, int mnc) {

		EntityManager em = emf.createEntityManager();
		List<MCCMNC> mccmncs = (List<MCCMNC>) em
				.createNamedQuery("MCCMNC.findMCCMNCByName")
				.setParameter("mcc", mcc).setParameter("mnc", mnc)
				.getResultList();
		em.close();

		if (mccmncs.size() == 0)
			return null;
		else
			return mccmncs.get(0);
	}

	public static EventCause findEventIDAndCauseCode(int eventID, int causeCode) {
		EntityManager em = emf.createEntityManager();
		List<EventCause> eventCause = (List<EventCause>) em
				.createNamedQuery("EventCause.findEventIDAndCauseCode")
				.setParameter("eventID", eventID)
				.setParameter("causeCode", causeCode).getResultList();
		em.close();

		if (eventCause.size() == 0)
			return null;
		else
			return eventCause.get(0);
	}

	public static Failure findFailureCode(int failureID) {
		EntityManager em = emf.createEntityManager();
		List<Failure> failureCodes = (List<Failure>) em
				.createNamedQuery("Failure.findFailureCode")
				.setParameter("failureID", failureID).getResultList();
		em.close();

		if (failureCodes.size() == 0)
			return null;
		else
			return failureCodes.get(0);
	}

	public static UserEquipment findTAC(String tac) {

		EntityManager em = emf.createEntityManager();
		List<UserEquipment> tacs = (List<UserEquipment>) em
				.createNamedQuery("UserEquipment.findTAC")
				.setParameter("tac", tac).getResultList();
		em.close();

		if (tacs.size() == 0)
			return null;
		else
			return tacs.get(0);
	}

	public static EventCause findEventID(int eventID) {
		EntityManager em = emf.createEntityManager();
		List<EventCause> event = (List<EventCause>) em
				.createNamedQuery("EventCause.findEventID")
				.setParameter("eventID", eventID).getResultList();
		em.close();

		if (event.size() == 0)
			return null;
		else
			return event.get(0);
	}

	
	public static User findUserName(String userName) {
		EntityManager em = emf.createEntityManager();
		List<User> user = (List<User>) em.createNamedQuery("User.findUserName").setParameter("userName", userName).getResultList();
		em.close();

		if (user.size() == 0)
			return null;
		else
			return user.get(0);
	}
	
	public static List<User> findAllUsers(){
		EntityManager em = emf.createEntityManager();
		List<User> users = (List<User>) em.createNamedQuery("User.findAll").getResultList();
		em.close();
		
		return users;		
	}
	
}


