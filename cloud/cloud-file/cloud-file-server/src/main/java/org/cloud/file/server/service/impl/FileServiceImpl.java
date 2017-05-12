package org.cloud.file.server.service.impl;

import java.io.IOException;

import org.cloud.common.util.FileUtil;
import org.cloud.common.util.UuidUtil;
import org.cloud.file.server.model.File;
import org.cloud.file.server.service.FileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileServiceImpl implements FileService{
	
	private static final String IMAGE_PATH="file/image/";
	
	@Override
	public File upload_image(MultipartFile multipartFile) {
		if(multipartFile.isEmpty()){
			return null;
		}
		File file=null;
		try {
			//获取系统根路径
			String rootPath=java.io.File.listRoots()[0].getPath();
			//文件相对路径
			String relativePath=IMAGE_PATH;
			//验证文件夹是否存在
			mkdir(rootPath+relativePath);
			//文件名
			String fileName=UuidUtil.uuidBuilder()+FileUtil.getSuffix(multipartFile.getOriginalFilename());
			//目标文件
			java.io.File destFile=new java.io.File(rootPath+relativePath+fileName);
			//上传
			multipartFile.transferTo(destFile);
			//封装文件信息
			file=new File();
			file.setName(fileName);
			file.setDir(IMAGE_PATH);
			file.setTime(System.currentTimeMillis());
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return file;
	}
	/**
	 * 验证文件夹是否存在，不存在就创建
	 * @param path
	 */
	private void mkdir(String path){
		java.io.File fileDir=new java.io.File(path);
		if(!fileDir.exists()){
			fileDir.mkdirs();
		}
	}
	
	@Override
	public java.io.File download_image(String fileName) {
		String path=java.io.File.listRoots()[0]+IMAGE_PATH+fileName;
		java.io.File file=new java.io.File(path);
		if(!file.exists()){
			return null;
		}
		return file;
	}
}
