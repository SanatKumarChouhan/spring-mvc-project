package in.co.rays.form;

import javax.validation.constraints.NotEmpty;

import in.co.rays.common.BaseForm;

public class LoginForm extends BaseForm {

	@NotEmpty(message = "loginId is required")
	private String loginId;
	
	@NotEmpty(message = "password is required")
	private String password;

	public String getLoginId() {
		return loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
