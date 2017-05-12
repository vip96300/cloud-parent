package org.cloud.file.server.service;


import org.cloud.file.server.model.File;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {
	
	/**
	 * 多圖片上傳
	 * @param files
	 * @return
	 */
	public File upload_image(MultipartFile file);
	/**
	 * 下载文件
	 * @param fileName
	 * @return
	 */
	public java.io.File download_image(String fileName);
}
