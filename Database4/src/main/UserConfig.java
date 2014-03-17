package main;

import persistence.PersistenceUtil;
import entity.User;

public class UserConfig extends SuperConfig {

	public UserConfig() {
		super();
		initialise();
	}

	public void initialise() {
		
		User user2 = new User("netman", "netman", "EMP002", "Bon", "Scott", "Network Management Engineer");
		PersistenceUtil.persist(user2);
		User user3 = new User("supeng", "supeng", "EMP003", "Angus", "Young", "Support Engineer");
		PersistenceUtil.persist(user3);
		User user4 = new User("custrep", "custrep", "EMP004", "Malcolm", "Young", "Customer Service Rep");
		PersistenceUtil.persist(user4);
	}

	public void createUser(String userName, String password, String employeeNumber, String firstName, String lastName, String userType) {
		User user = new User(userName, password, employeeNumber, firstName, lastName, userType);
		PersistenceUtil.persist(user);
	}

}
