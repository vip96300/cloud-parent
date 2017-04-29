package org.cloud.file.server.service.impl;

import java.io.IOException;
import java.util.List;

import org.cloud.file.server.model.File;
import org.cloud.file.server.service.BaseService;
import org.cloud.file.server.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileServiceImpl implements FileService{
	
	@Autowired
	private BaseService baseService;
	
	@Override
	public List<File> upload_image(List<MultipartFile> files) {
		List<File> fileDirs=null;
		try {
			fileDirs = baseService.upload(files);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fileDirs;
	}

}
