package dev.informacoesubs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/")
	public String main() {
		return "index";
	}
	
	@GetMapping("/pesquisa-ubs")
	public String pesquisaUbs() {
		return "pesquisa_ubs";
	}
}
