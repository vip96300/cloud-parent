package org.cloud.file.client.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.cloud.file.client.controller.dto.Result;
import org.cloud.file.client.model.File;
import org.cloud.file.client.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@RestController
@EnableAutoConfiguration
@RequestMapping(value="/file")
public class FileController {
	
	@Autowired
	private FileService fileService;
	
	@RequestMapping(value="/upload_image",method=RequestMethod.GET)
	public Result<List<File>> upload_image(HttpServletRequest request){
		List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
		if(files.isEmpty()){
			return null;
		}
		List<File> fileDirs=fileService.upload_image(files);
		return new Result<List<File>>(200,null,fileDirs);
	}
}
