package in.co.rays.dto;

import java.io.IOException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.springframework.web.multipart.MultipartFile;

import in.co.rays.common.BaseDTO;

@Entity
@Table(name = "ST_ATTACHMENT ")
public class AttachmentDTO extends BaseDTO {

	@Column(name = "NAME")
	private String name;

	@Column(name = "TYPE")
	private String type;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "USER_ID")
	private Long userId;

	@Lob
	@Column(name = "DOC")
	private byte[] doc;

	public AttachmentDTO() {

	}

	public AttachmentDTO(MultipartFile file) {

		this.name = file.getOriginalFilename();
		this.type = file.getContentType();

		try {
			this.doc = file.getBytes();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public byte[] getDoc() {
		return doc;
	}

	public void setDoc(byte[] doc) {
		this.doc = doc;
	}

}
