package com.praveen.demo.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.praveen.demo.model.ScanRequest;
import com.praveen.demo.model.ScanResponse;
import com.praveen.demo.service.ScanService;

@RestController
public class CodeScanController {

	@Autowired
	ScanRequest request;

	@Autowired
	ScanResponse result;

	@Autowired
	ScanService scanService;

	@GetMapping("/")
	public ScanResponse scan(@RequestBody ScanRequest request) {
		result = scanService.scan(request);
		return result;
	}

	@GetMapping("/ui")
	public ModelAndView scanUI() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home.html");
		return mv;
	}

	@GetMapping("/analyse")
	public ModelAndView analyse(@RequestParam String language, @RequestParam String codeFile) {
		ModelAndView mv = new ModelAndView("result.jsp");
		request.setLanguage(language);
		ArrayList<String> filePath = new ArrayList<String>();
		filePath.add(codeFile);
		request.setFilePath(filePath);
		result = scanService.scan(request);
		mv.addObject("result", result);
		return mv;
	}

}
