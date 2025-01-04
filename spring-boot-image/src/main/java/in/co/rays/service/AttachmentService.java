package in.co.rays.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import in.co.rays.dao.AttachmentDAO;
import in.co.rays.dto.AttachmentDTO;

@Service
@Transactional
public class AttachmentService {

	@Autowired
	public AttachmentDAO dao;

	@Transactional(propagation = Propagation.REQUIRED)
	public long add(AttachmentDTO dto) {
		long pk = dao.add(dto);
		return pk;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void update(AttachmentDTO dto) {
		dao.delete(dto);
	}

	@Transactional(readOnly = true)
	public AttachmentDTO findById(long id) {
		AttachmentDTO dto = dao.findByPk(id);
		return dto;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(long id) {

		try {
			AttachmentDTO dto = findById(id);
			dao.delete(dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public long save(AttachmentDTO dto) {

		Long id = dto.getId();

		if (id != null && id > 0) {
			dao.update(dto);
		} else {
			id = dao.add(dto);
		}
		return id;
	}
}
