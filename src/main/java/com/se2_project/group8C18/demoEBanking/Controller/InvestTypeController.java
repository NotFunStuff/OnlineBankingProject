package com.se2_project.group8C18.demoEBanking.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.se2_project.group8C18.demoEBanking.Service.InvestTypeService;

@RestController
public class InvestTypeController {
	
	@Autowired
	InvestTypeService investTypeService;
}
