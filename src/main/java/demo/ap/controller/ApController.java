package demo.ap.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import demo.ap.entity.Recorddemo;
import demo.ap.repo.Recorddemorepo;
import demo.ap.service.AiServiceAp;

@Controller
@RequestMapping("/api")
public class ApController {
	
	@Autowired
	private AiServiceAp s;
	
	@Autowired 
	private Recorddemorepo rrepo;
	
	
	
	@RequestMapping("/open")
	public String denap() {
		return "add";
	}

	@RequestMapping("/open7")
	public String denaap() {
		return "add7";
	}
	
	
	@PostMapping("/add")
	public String addre(@ModelAttribute Recorddemo m) {
		rrepo.save(m);
		
		return "redirect:/api/open";
		
	}
	
	
	
}
