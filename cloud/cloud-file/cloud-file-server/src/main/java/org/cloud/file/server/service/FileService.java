package org.cloud.file.server.service;

import java.util.List;

import org.cloud.file.server.model.File;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {
	
	/**
	 * 多圖片上傳
	 * @param files
	 * @return
	 */
	public List<File> upload_image(List<MultipartFile> files);
}
