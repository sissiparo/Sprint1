package persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entity.User;
import entity.Task;

public class PersistenceUtil implements Serializable {

	private static final long serialVersionUID = 1L;

	protected static EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("todolist");

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

	public static User findUserByUsernamePassword(String username,
			String password) {

		EntityManager em = emf.createEntityManager();
		@SuppressWarnings("unchecked")
		List<User> users = (List<User>) em
				.createNamedQuery("User.findByUsernamePassword")
				.setParameter("username", username)
				.setParameter("password", password).getResultList();
		em.close();

		if (users.size() == 0)
			return null;
		else
			return users.get(0);
	}

	public static User findUserByUsername(String username) {

		EntityManager em = emf.createEntityManager();
		@SuppressWarnings("unchecked")
		List<User> users = (List<User>) em
				.createNamedQuery("User.findByUsername")
				.setParameter("username", username).getResultList();
		em.close();

		if (users.size() == 0)
			return null;
		else
			return users.get(0);
	}

	public static List<Task> findAllTasks(int userID) {
		EntityManager em = emf.createEntityManager();
		@SuppressWarnings("unchecked")
		List<Task> tasks = (List<Task>) em.createNamedQuery("Task.findAllbyID")
				.setParameter("userID", userID).getResultList();
		em.close();

		return tasks;

	}

	public static Task findTaskByName(String taskname) {

		EntityManager em = emf.createEntityManager();
		@SuppressWarnings("unchecked")
		List<Task> tasks = (List<Task>) em
				.createNamedQuery("Task.findByTaskname")
				.setParameter("taskname", taskname).getResultList();
		em.close();

		if (tasks.size() == 0)
			return null;
		else
			return tasks.get(0);
	}

}
