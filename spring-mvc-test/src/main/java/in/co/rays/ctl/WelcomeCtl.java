package in.co.rays.ctl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "Welcome")
public class WelcomeCtl {

	@GetMapping
	public String display() {
		System.out.println("display");
		return "Welcome";
	}

	@GetMapping("first")
	public String display1() {
		System.out.println("display1");
		return "Welcome";
	}

	@GetMapping("second")
	public String display2() {
		System.out.println("display2");
		return "Welcome";
	}

	@GetMapping("third")
	public String display3() {
		System.out.println("display3");
		return "Welcome";
	}

}