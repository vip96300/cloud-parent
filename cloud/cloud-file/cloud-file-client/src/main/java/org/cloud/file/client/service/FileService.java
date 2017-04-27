package org.cloud.file.client.service;

import java.util.List;

import org.cloud.file.client.feign.FeignConfig;
import org.cloud.file.client.model.File;
import org.cloud.file.client.service.breaker.FileServiceBreaker;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(value="cloud-file-server",configuration=FeignConfig.class,fallback=FileServiceBreaker.class)
public interface FileService {

	/**
	 * 上传图片
	 * @param file
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/upload_image",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE},consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public List<File> upload_image(@RequestPart(value = "file") List<MultipartFile> files);
	
}
