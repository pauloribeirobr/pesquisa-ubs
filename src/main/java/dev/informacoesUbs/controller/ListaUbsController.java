package dev.informacoesUbs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ListaUbsController {

	
	@GetMapping("/find_ubs")
	@ResponseBody
	public String findUbs() {
		return "index";
	}
	
}
