package org.cloud.file.server.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.cloud.common.util.FileUtil;
import org.cloud.common.util.UuidUtil;
import org.cloud.file.server.model.File;
import org.cloud.file.server.service.FileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileServiceImpl implements FileService{
	
	/**
	 * 圖片根路徑
	 */
	private static final String IMAGE_PATH="/file/image/";
	
	@Override
	public List<File> upload_image(List<MultipartFile> files) {
		List<File> fileDirs=new ArrayList<File>();
		File fileDir=null;
		String fileName=null;
		for(MultipartFile file:files){
			fileName=UuidUtil.uuidBuilder()+FileUtil.getSuffix(file.getName());
			try {
				file.transferTo(new java.io.File(IMAGE_PATH+fileName));
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			fileDir=new File();
			fileDir.setName(fileName);
			fileDir.setUrl(IMAGE_PATH+fileName);
			fileDirs.add(fileDir);
		}
		return fileDirs;
	}

}
