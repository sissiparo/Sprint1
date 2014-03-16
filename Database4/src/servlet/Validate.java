package servlet;

import java.util.List;

import persistence.PersistenceUtil;
import entity.User;


public class Validate {
	
	public static String checkUser(String username, String password){
		String st = null;
		List<User> rs = PersistenceUtil.findAllUsers();
		for(User u : rs){
			if(u.getUserName().equals(username) && u.getPassword().equals(password)){
				st = u.getUserType();
			}
		}
		return st;
	}

}
