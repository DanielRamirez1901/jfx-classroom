package model;

public class UserAccount {
	private String name;
	private String password;
	private String gender;
	private String career;
	private String birthday;
	private String browser;
	

	
	public UserAccount(String name, String gender, String career,String birthday, String password, String browser) {
		super();
		this.name = name;
		this.gender = gender;
		this.career = career;
		this.birthday = birthday;
		this.browser = browser;
		this.password = password;
	}



	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}



	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}



	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}



	public String getCareer() {
		return career;
	}
	public void setCareer(String career) {
		this.career = career;
	}



	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}



	public String getBrowser() {
		return browser;
	}
	public void setBrowser(String browser) {
		this.browser = browser;
	}

}