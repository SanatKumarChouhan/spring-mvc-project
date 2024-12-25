package in.co.rays.ctl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.co.rays.common.DemoResponse;
import in.co.rays.common.ORSResponse;
import in.co.rays.dto.Person;

@RestController
@RequestMapping(value = "Demo")
public class DemoCtl {

	@GetMapping
	public String display() {
		return "Sanat Spring Boot Application";
	}

	@GetMapping("display2")
	public Person display2() {

		Person dto = new Person();

		dto.setFirstName("menika");
		dto.setLastName("kumari");
		dto.setLogin("menika@gmail.com");
		dto.setPassword("pass123");

		return dto;
	}

	@GetMapping("display3")
	public DemoResponse display3() {

		DemoResponse res = new DemoResponse();

		Person dto = new Person();

		dto.setFirstName("priyansh");
		dto.setLastName("singh");
		dto.setLogin("priyansh@gmail.com");
		dto.setPassword("priyansh123");

		Person dto1 = new Person();

		dto1.setFirstName("rahul");
		dto1.setLastName("chouhan");
		dto1.setLogin("rahul@gmail.com");
		dto1.setPassword("rahul123");

		Map map = new HashMap();

		map.put("dto", dto);
		map.put("dto1", dto1);

		res.setResult(map);

		res.setMessage("Data Added Successfully....");

		res.setData("Person's Data");

		return res;
	}

	@GetMapping("display4")
	public ORSResponse display4() {

		ORSResponse res = new ORSResponse();

		Map error = new HashMap();

		error.put("firstName", "first name is required");
		error.put("lastName", "last name is required");
		error.put("login", "login id is required");
		error.put("password", "password is required");

		Person dto = new Person();

		dto.setFirstName("abhishek");
		dto.setLastName("singh");
		dto.setLogin("abhishek@gmail.com");
		dto.setPassword("abhishek123");

		Person dto1 = new Person();

		dto1.setFirstName("anmol");
		dto1.setLastName("chouhan");
		dto1.setLogin("anmol@gmail.com");
		dto1.setPassword("anmol123");

		Person dto2 = new Person();

		dto2.setFirstName("menika");
		dto2.setLastName("kumari");
		dto2.setLogin("menika@gmail.com");
		dto2.setPassword("pass123");

//		List list = new ArrayList();
//
//		list.add(dto);
//		list.add(dto1);
//		list.add(dto2);
//
//		res.addData(list);

		Map map1 = new HashMap();

		map1.put("dto", dto);
		map1.put("dto1", dto1);
		map1.put("dto2", dto2);

		res.addData(map1);

		res.addMessage("user loggedIn successesfully.....");

		res.addInputError(error);

		res.addResult("Tocken", "lkjfhghladsjg");

		res.setSuccess(true);

		return res;
	}
	
	@PostMapping
	public String submit() {
		
//		ORSResponse res=new ORSResponse();
//		
//		res.addData(person);
		
		return "This is submit() method of DemoCtl Class";
	}
	
	@PostMapping("submit2")
	public ORSResponse submit2(@RequestBody Person person) {
		
		ORSResponse res=new ORSResponse();
		
		res.addData(person);
		
		return res;
	}
}
