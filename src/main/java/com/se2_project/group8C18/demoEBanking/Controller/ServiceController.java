package com.se2_project.group8C18.demoEBanking.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.se2_project.group8C18.demoEBanking.Service.ServiceService;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class ServiceController {
	@Autowired
	ServiceService serviceService;
}
