package in.co.rays.form;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import in.co.rays.common.BaseForm;

public class UserRegistrationForm extends BaseForm {

	@NotEmpty(message = "firstName is required")
	private String firstName;
	
	@NotEmpty(message = "lastName is required")
	private String lastName;
	
	@NotEmpty(message = "loginId is required")
	private String loginId;
	
	@NotEmpty(message = "password is required")
	private String password;
	
	@NotNull(message = "Date of birth is required")
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
