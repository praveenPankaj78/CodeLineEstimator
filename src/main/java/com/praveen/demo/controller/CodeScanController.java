package com.praveen.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.praveen.demo.model.ScanRequest;
import com.praveen.demo.model.ScanResponse;
import com.praveen.demo.service.ScanService;

@RestController
public class CodeScanController {

	@Autowired
	ScanResponse result;

	@Autowired
	ScanService scanService;

	@GetMapping("/")
	public ScanResponse scan(@RequestBody ScanRequest request) {
		result = scanService.scan(request);
		return result;
	}

}
