package org.cloud.file.client.service;

import org.cloud.file.client.feign.FeignMultipartSupportConfig;
import org.cloud.file.client.model.File;
import org.cloud.file.client.service.breaker.FileServiceBreaker;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(value="cloud-file-server",configuration=FeignMultipartSupportConfig.class,fallback=FileServiceBreaker.class)
public interface FileService {

	/**
	 * 上传图片
	 * @param file
	 * @return
	 */
	@RequestMapping(value = "/file/upload_image",method = RequestMethod.POST)
    public File upload_image(@RequestPart(value="file") MultipartFile file);
	
	/**
	 * 下载图片
	 * @param fileName
	 * @return
	 */
	@RequestMapping(value = "/file/download_image",method = RequestMethod.GET)
	public java.io.File download_image(@RequestParam(value="fileName",required=true)String fileName);
	
}
