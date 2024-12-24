package in.co.rays.form;

import in.co.rays.dto.UserDTO;
import in.co.rays.util.DateUtility;

public class UserForm {

	private long id = 0;
	private Long[] ids;
	private String firstName;
	private String lastName;
	private String login;
	private String password;
	private String dob;
	private String address;
	private int pageNo;

	public Long[] getIds() {
		return ids;
	}

	public void setIds(Long[] ids) {
		this.ids = ids;
	}

	public long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}

	public String getDob() {
		return dob;
	}

	public String getAddress() {
		return address;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public UserDTO getDto() {

		UserDTO dto = new UserDTO();

		dto.setId(id);
		dto.setFirstName(firstName);
		dto.setLastName(lastName);
		dto.setLogin(login);
		dto.setPassword(password);
		dto.setDob(DateUtility.stringToDate(dob));
		dto.setAddress(address);

		return dto;
	}

}
