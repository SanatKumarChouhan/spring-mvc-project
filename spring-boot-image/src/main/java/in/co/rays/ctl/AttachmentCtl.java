package in.co.rays.ctl;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import in.co.rays.common.ORSResponse;
import in.co.rays.dto.AttachmentDTO;
import in.co.rays.service.AttachmentService;

@RestController
@RequestMapping(value = "TestAttachment")
public class AttachmentCtl {

	@Autowired
	public AttachmentService attachmentService;

	@PostMapping("/profilePic/{userId}")
	public ORSResponse uploadPic(@PathVariable Long userId, @RequestParam("file") MultipartFile file,
			HttpServletRequest req) {

		AttachmentDTO attachmentDto = new AttachmentDTO(file);

		attachmentDto.setDescription("profile pic");

		attachmentDto.setUserId(userId);

		Long imageId = attachmentService.save(attachmentDto);

		ORSResponse res = new ORSResponse();

		res.addResult("image", imageId);

		return res;

	}

	@GetMapping("/profilePic/{imageId}")
	public void downloadpic(@PathVariable Long imageId, HttpServletResponse response) {

		try {
			AttachmentDTO attachmentDto = null;

			attachmentDto = attachmentService.findById(imageId);

			if (attachmentDto != null) {

				response.setContentType(attachmentDto.getType());
				OutputStream out = response.getOutputStream();
				out.write(attachmentDto.getDoc());
				out.close();
			} else {
				response.getWriter().write("ERROR: file not found");
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
