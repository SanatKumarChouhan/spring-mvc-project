package in.co.rays.ctl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.co.rays.common.ORSResponse;
import in.co.rays.dto.UserDTO;
import in.co.rays.form.LoginForm;
import in.co.rays.form.UserRegistrationForm;
import in.co.rays.service.UserService;

@RestController
@RequestMapping(value = "Auth")
public class LoginCtl {

	@Autowired
	private UserService service;

	@GetMapping
	public String display() {

//		ORSResponse res = new ORSResponse();

		return "This is @GetMapping signUp1() method from LoginCtl Class";
	}

	@PostMapping("signUp")
	public ORSResponse signUp(@RequestBody UserRegistrationForm form) {

		ORSResponse res = new ORSResponse();

		UserDTO dto = new UserDTO();

		dto.setFirstName(form.getFirstName());
		dto.setLastName(form.getLastName());
		dto.setLoginId(form.getLoginId());
		dto.setPassword(form.getPassword());
		dto.setDob(form.getDob());

		long pk = service.add(dto);

		if (pk != 0) {

		}

		res.addData(dto);
//		res.addData(pk);
		res.addMessage("User Registered Successfully....!!!!");

		return res;
	}

	@PostMapping("login")
	public ORSResponse login(@RequestBody LoginForm form) {

		ORSResponse res = new ORSResponse();

		UserDTO dto = service.authenticate(form.getLoginId(), form.getPassword());

		if (dto != null) {

			res.addData(dto);
			res.addMessage("User LoggedIn successfully....!!!");
		} else {

			res.addMessage("LoginId and Password is Invalid....!!!!");
		}

		return res;
	}

}
