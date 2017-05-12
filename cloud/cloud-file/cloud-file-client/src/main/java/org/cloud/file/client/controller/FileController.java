package org.cloud.file.client.controller;

import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import io.swagger.annotations.ApiOperation;

import org.cloud.file.client.controller.dto.Result;
import org.cloud.file.client.model.File;
import org.cloud.file.client.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@ApiOperation(value="上传图片")
	@RequestMapping(value="/upload_image",method=RequestMethod.POST)
	public Result<File> upload_image(MultipartHttpServletRequest request){
		MultipartFile multipartFile = request.getFile("file");
		if(multipartFile.isEmpty()){
			return null;
		}
		File file=fileService.upload_image(multipartFile);
		return new Result<File>(200,null,file);
	}
	
	/**
	 * response.setHeader("content-type", "application/octet-stream");  
     * response.setContentType("application/octet-stream"); 
     * 设置为下载图片，而非显示
	 * @param fileName
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value="/image/{fileName}",method=RequestMethod.GET)
	public void download_image(@PathVariable(value="fileName",required=true) String fileName,HttpServletResponse  response) throws IOException{
		java.io.File file=fileService.download_image(fileName);
		System.out.println(file.getAbsolutePath());
		if(!file.exists()){
			System.out.println("file not exist!");
			return;
		}
		FileOutputStream fos=new FileOutputStream(file);  
        fos.close();  
	}

}
