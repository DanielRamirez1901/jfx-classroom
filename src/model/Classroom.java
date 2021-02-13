package model;

import java.util.List;
import java.util.ArrayList;

public class Classroom {
	private List<UserAccount> users;
	
	public Classroom() {
		users = new ArrayList<>();
	}
	
	public void addContact(String name, String gender, String career,String birthday, String password, String browser) {
		users.add(new UserAccount(name, gender, career, birthday , password, browser));
	}

	
	public List<UserAccount> getUsers(){
		return users; 
	}
	  
    public UserAccount checkUser(String username, String password) {
    	UserAccount user = null;
    	for(int i=0; i<users.size(); i++ ) {
    		if(users.get(i).getName().equals(username)&&users.get(i).getPassword().equals(password))
    			user = users.get(i);
    	}
    	return user;
    }
    
}