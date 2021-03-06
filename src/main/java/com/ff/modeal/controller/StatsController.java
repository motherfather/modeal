package com.ff.modeal.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ff.modeal.security.Admin;
import com.ff.modeal.service.StatsService;

@Controller
@RequestMapping("/stats")
public class StatsController {
	
	@Autowired
	private StatsService statsService;
	
	@Admin
	@RequestMapping("")
	public String statsIndex(Model model){
		List<Map<String, Object>> genderlist = statsService.getgenderCount();
		List<Map<String, Object>> agelist = statsService.getAgeCount();

		
		model.addAttribute("genderlist",genderlist);
		model.addAttribute("agelist",agelist);

		return "stats/statsMain_boot";
	}
}
