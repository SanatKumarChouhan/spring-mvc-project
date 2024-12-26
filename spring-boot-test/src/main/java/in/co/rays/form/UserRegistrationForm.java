package in.co.rays.form;

import java.util.Date;

public class UserRegistrationForm {

	private String firstName;
	private String lastName;
	private String loginId;
	private String password;
	private Date dob;

	public UserRegistrationForm() {
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getLoginId() {
		return loginId;
	}

	public String getPassword() {
		return password;
	}

	public Date getDob() {
		return dob;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

}
