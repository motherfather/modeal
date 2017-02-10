package com.ff.modeal.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ff.modeal.service.StatsService;

@Controller
@RequestMapping("/stats")
public class StatsController {
	
	@Autowired
	private StatsService statsService;
	
	@RequestMapping("")
	public String statsIndex(Model model){
		
		List<Map<String, Object>> genderlist = statsService.getgenderCount();
		List<Map<String, Object>> locationlist = statsService.genlocationCount();
		model.addAttribute("genderlist",genderlist);
		model.addAttribute("locationlist",locationlist);
		return "stats/statsMain";
	}
	
}
