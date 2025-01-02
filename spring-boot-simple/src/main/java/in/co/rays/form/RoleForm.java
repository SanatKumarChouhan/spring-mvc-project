package in.co.rays.form;

import javax.validation.constraints.NotEmpty;

import in.co.rays.common.BaseForm;

public class RoleForm extends BaseForm {

	@NotEmpty(message = "name is required")
	private String name;

	@NotEmpty(message = "description is required")
	private String description;

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
