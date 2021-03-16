package com.se2_project.group8C18.demoEBanking.IService;

import java.util.List;

import org.springframework.stereotype.Service;

import com.se2_project.group8C18.demoEBanking.Model.Normal;
@Service
public interface INormalService {
	
	public Normal getNormalById(int normalId);
	public List<Normal> getAllNormal();
	public String addNormal(String normal);
	public String deleteNormalById(int normalId);
	public String editNormal(String normal);
}
	