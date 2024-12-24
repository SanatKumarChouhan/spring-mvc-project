package in.co.rays.ctl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.co.rays.dto.UserDTO;
import in.co.rays.form.UserForm;
import in.co.rays.service.UserService;
import in.co.rays.util.DateUtility;

@Controller
@RequestMapping(value = "User")
public class UserCtl {

	@Autowired
	private UserService service;

	@ModelAttribute("form")
	public void preload(Model model) {
		List list = service.search(null, 0, 0);
		model.addAttribute("userList", list);
	}

	@GetMapping
	public String display(@ModelAttribute("form") UserForm form, @RequestParam(required = false) Long id) {

		if (id != null && id > 0) {

			UserDTO dto = service.findByPk(id);

			form.setId(dto.getId());
			form.setFirstName(dto.getFirstName());
			form.setLastName(dto.getLastName());
			form.setLogin(dto.getLastName());
			form.setPassword(dto.getPassword());
			form.setDob(DateUtility.dateToString(dto.getDob()));
			form.setAddress(dto.getAddress());
		}
		return "UserView";
	}

	@GetMapping("search")
	public String diaplay(@ModelAttribute("form") UserForm form, Model model) {

		int pageNo = 1;
		int pageSize = 5;

		List list = service.search(null, pageNo, pageSize);

		model.addAttribute("list", list);

		form.setPageNo(pageNo);

		return "UserListView";

	}

	@PostMapping
	public String submit(@ModelAttribute("form") UserForm form) {

		UserDTO dto = form.getDto();

		if (form.getId() > 0) {
			service.update(dto);
		} else {
			service.add(dto);
		}
		return "UserView";
	}

	@PostMapping("search")
	public String search(@ModelAttribute("form") UserForm form, @RequestParam(required = false) String operation,
			Model model) {

		UserDTO dto = null;

		int pageNo = 1;
		int pageSize = 5;

		if (operation.equals("next")) {
			pageNo = form.getPageNo();
			pageNo++;
		}

		if (operation.equals("previous")) {
			pageNo = form.getPageNo();
			pageNo--;
		}

		if (operation.equals("add")) {
			return "redirect:/User";
		}

		if (operation.equals("search")) {
			dto = new UserDTO();
			dto.setFirstName(form.getFirstName());
		}

		if (operation.equals("delete")) {
			if (form.getIds() != null && form.getIds().length > 0) {
				for (long id : form.getIds()) {
					service.delete(id);
				}
			}
		}

		form.setPageNo(pageNo);

		List list = service.search(dto, pageNo, pageSize);

		model.addAttribute("list", list);

		return "UserListView";
	}
}
