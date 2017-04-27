package org.cloud.file.server.controller;

import org.cloud.file.server.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableAutoConfiguration
@RestController
@RequestMapping(value="/file")
public class FileController {
	
	@Autowired
	private FileService fileService;
	
	
}
