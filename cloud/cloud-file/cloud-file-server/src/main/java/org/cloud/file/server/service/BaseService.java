package org.cloud.file.server.service;

import java.io.IOException;
import java.util.List;

import org.cloud.file.server.model.File;
import org.springframework.web.multipart.MultipartFile;

public interface BaseService {
	
	/**
	 * 上传文件
	 * @param file
	 */
	public List<File> upload(List<MultipartFile> files) throws IOException;
	/**
	 * 删除文件
	 * @param url
	 */
	public void delete(String url);
}
