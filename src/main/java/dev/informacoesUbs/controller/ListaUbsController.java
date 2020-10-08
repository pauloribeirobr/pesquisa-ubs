package dev.informacoesubs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dev.informacoesubs.dto.ListaUbsDto;
import dev.informacoesubs.service.ListaUbsService;

@Controller
public class ListaUbsController {

	@Autowired
	ListaUbsService listaUbsService;
	
	/**
	 * Pesquisa as UBSs próximas	
	 * @param query 
	 * @param page
	 * @param perPage
	 * @return
	 */
	@GetMapping(value="/find_ubs", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ListaUbsDto> findUbs(@RequestParam String query, @RequestParam(name="page", required=false) Integer page, @RequestParam(name="per_page", required=false) Integer perPage) {
		
		Integer pageFinal = StringUtils.isEmpty(page) ? 1 : page;
		Integer perPageFinal = StringUtils.isEmpty(perPage) ? 10 : perPage;
		
		ListaUbsDto response = listaUbsService.listaUBSsProximas(Double.valueOf(query.split(",")[0]), Double.valueOf(query.split(",")[1]), pageFinal, perPageFinal);
		
		if(response.getEntries().isEmpty()) {
			return (ResponseEntity<ListaUbsDto>) ResponseEntity.notFound();
		}else {
			return ResponseEntity.ok().body(response);
		}
	}

	
}
