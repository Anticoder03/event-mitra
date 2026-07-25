package com.excelr.project.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {
@RequestMapping("/home")
public String hello() {
	return "Hello";
}
}
