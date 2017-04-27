package org.cloud.file.client.service.breaker;

import java.util.List;

import org.cloud.file.client.model.File;
import org.cloud.file.client.service.FileService;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileServiceBreaker implements FileService{

	@Override
	public List<File> upload_image(List<MultipartFile> files) {
		throw new RuntimeException();
	}


}
