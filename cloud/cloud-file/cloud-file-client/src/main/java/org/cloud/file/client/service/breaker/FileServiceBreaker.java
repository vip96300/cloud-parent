package org.cloud.file.client.service.breaker;


import org.cloud.file.client.model.File;
import org.cloud.file.client.service.FileService;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileServiceBreaker implements FileService{

	@Override
	public File upload_image(MultipartFile files) {
		throw new RuntimeException();
	}

	@Override
	public java.io.File download_image(String fileName) {
		// TODO Auto-generated method stub
		return null;
	}


}
