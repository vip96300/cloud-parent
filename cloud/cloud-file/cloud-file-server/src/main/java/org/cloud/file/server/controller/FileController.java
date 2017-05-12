package org.cloud.file.server.controller;


import org.cloud.file.server.model.File;
import org.cloud.file.server.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@EnableAutoConfiguration
@RestController
@RequestMapping(value="/file")
public class FileController {
	
	@Autowired
	private FileService fileService;
	
	@RequestMapping(method = RequestMethod.POST, value = "/upload_image")
    public File upload_image(@RequestPart(value="file") MultipartFile multipartFile) {
		File file=fileService.upload_image(multipartFile);
		return file;
	}
	
	@RequestMapping(value = "/download_image",method = RequestMethod.GET)
	public java.io.File download_image(@RequestParam(value="fileName",required=true)String fileName) {
		java.io.File file=fileService.download_image(fileName);
		return file;
	}
	
}
