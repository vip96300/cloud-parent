package org.cloud.file.server.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.cloud.file.server.model.File;
import org.cloud.file.server.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;

@Service
public class BaseServiceImpl implements BaseService{
	
	@Autowired
    private FastFileStorageClient storageClient;

	@Override
	public List<File> upload(List<MultipartFile> files) throws IOException {
		List<File> fileDirs=new ArrayList<File>();
		File fileDir=null;
		String fileName=null;
		for(MultipartFile file:files){
			StorePath storePath=storageClient.uploadFile(file.getInputStream(),file.getSize(), FilenameUtils.getExtension(file.getOriginalFilename()),null);
			fileDir=new File();
			fileDir.setName(fileName);
			fileDir.setUrl(storePath.getFullPath());
			fileDirs.add(fileDir);
		}
		return fileDirs;
	}

	@Override
	public void delete(String url) {
		StorePath storePath = StorePath.praseFromUrl(url);
        storageClient.deleteFile(storePath.getGroup(), storePath.getPath());
	}

}
