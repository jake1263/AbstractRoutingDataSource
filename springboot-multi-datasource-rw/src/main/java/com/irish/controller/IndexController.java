package com.irish.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.irish.service.TestService;

@RestController
public class IndexController {

	@Autowired
	private TestService testService;
	
	@RequestMapping("/save")
	public String save() {
		testService.save();
		return "success";
	}
	
	@RequestMapping("/sel")
	public String selectMember() {
		testService.query();
		return "success";
	}
}
