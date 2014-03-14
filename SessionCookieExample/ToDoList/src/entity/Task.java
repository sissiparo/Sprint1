package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries({
		@NamedQuery(name = "Task.findByTaskname", query = "select o from Task o where o.taskname=:taskname"),
		@NamedQuery(name = "Task.findAllbyID", query = "select o from Task o where o.userID=:userID") })
@Entity
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private int userID;
	private String taskname;

	public Task() {

	}

	public Task(int userID, String taskname) {
		super();
		this.userID = userID;
		this.taskname = taskname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getTaskname() {
		return taskname;
	}

	public void setTaskname(String taskname) {
		this.taskname = taskname;
	}

}
