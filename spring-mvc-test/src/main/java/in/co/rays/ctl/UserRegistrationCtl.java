package in.co.rays.ctl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import in.co.rays.form.UserRegistrationForm;

@Controller
@RequestMapping(value = "Register")
public class UserRegistrationCtl {
	
	@GetMapping
	public String display(@ModelAttribute("form") UserRegistrationForm form) {
		
		
		form.getFirstName();
		form.getLastName();
		
		return "UserRegistration";
	}

}
