package org.cloud.file.server.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.cloud.file.server.model.File;
import org.cloud.file.server.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@EnableAutoConfiguration
@RestController
@RequestMapping(value="/file")
public class FileController {
	
	@Autowired
	private FileService fileService;
	
	@RequestMapping(value="/upload_image",method=RequestMethod.POST)
	public List<File> upload_image(HttpServletRequest request){
		List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
		List<File> fileDirs=fileService.upload_image(files);
		return fileDirs;
	}
	
}
