package in.co.rays.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import in.co.rays.dao.UserDAO;
import in.co.rays.dto.UserDTO;

@Service
@Transactional
public class UserService {

	@Autowired
	public UserDAO dao;

	@Transactional(propagation = Propagation.REQUIRED)
	public long add(UserDTO dto) {
		long pk = dao.add(dto);
		return pk;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void update(UserDTO dto) {
		dao.update(dto);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(long id) {
		try {
			UserDTO dto = findById(id);
			dao.delete(dto);
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
	}

	@Transactional(readOnly = true)
	public UserDTO findById(long pk) {
		UserDTO dto = dao.findByPk(pk);
		return dto;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public long save(UserDTO dto) {
		Long id = dto.getId();
		if (id != null && id > 0) {
			update(dto);
		} else {
			id = add(dto);
		}
		return id;
	}

	@Transactional(readOnly = true)
	public UserDTO findByLogin(String login) {

		UserDTO dto = dao.findByUniqueKey("login", login);

		return dto;
	}

//	@Transactional(propagation = Propagation.REQUIRED)
	@Transactional(readOnly = true)
	public UserDTO authenticate(String loginId, String password) {

		UserDTO dto = dao.findByUniqueKey("loginId", loginId);

		if (dto != null) {
			if (dto.getPassword().equals(password)) {
				return dto;
			}
		}
		return null;
	}

	@Transactional(readOnly = true)
	public List search(UserDTO dto, int pageNo, int pageSize) {

		List list = dao.search(dto, pageNo, pageSize);

		return list;
	}
}
