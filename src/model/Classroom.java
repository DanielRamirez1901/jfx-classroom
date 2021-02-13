package model;

import java.util.List;
import java.util.ArrayList;

public class Classroom {
	private List<UserAccount> users;
	
	public Classroom() {
		users = new ArrayList<>();
	}
	
	public void addContact(String name, String gender, String career,String birthday, String browser) {
		users.add(new UserAccount(name, gender, career, birthday ,  browser));
	}
	
	public List<UserAccount> getUsers(){
		return users; 
	}
}