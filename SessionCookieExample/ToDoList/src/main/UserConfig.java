package main;

import java.util.List;

import persistence.PersistenceUtil;
import entity.Task;
import entity.User;

public class UserConfig {

	public UserConfig() {

	}

	public static void createUser(String name, String password) {
		User user = new User(name, password);
		PersistenceUtil.persist(user);
	}

	public static void deleteUser(String username) {
		User user = PersistenceUtil.findUserByUsername(username);
			List<Task> tasks = PersistenceUtil.findAllTasks(user.getId());
			for(Task t : tasks){
				
			TaskConfig.deleteTask(t.getTaskname());
		}
		
		PersistenceUtil.remove(user);
	}

}
