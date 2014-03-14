package main;

import persistence.PersistenceUtil;
import entity.Task;

public class TaskConfig {

	public TaskConfig() {

	}

	public static void createTask(int id, String taskname) {
		Task task = new Task(id, taskname);
		PersistenceUtil.persist(task);
	}

	public static void deleteTask(String taskname) {
		Task task = PersistenceUtil.findTaskByName(taskname);
		PersistenceUtil.remove(task);
	}

}
