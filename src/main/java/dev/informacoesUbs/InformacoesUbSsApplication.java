package dev.informacoesUbs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

import dev.informacoesUbs.service.ListaUbsService;

@SpringBootApplication
public class InformacoesUbSsApplication {

	@Autowired
	ListaUbsService listaUbsService;
	
	public static void main(String[] args) {
		SpringApplication.run(InformacoesUbSsApplication.class, args);
	}

	/**
	 * Inicializa o Banco de Dados e Importa o CSV
	 * 
	 * @throws InterruptedException
	 */
	@EventListener(ContextRefreshedEvent.class)
	public void inicializaConfig() throws InterruptedException {
		listaUbsService.importarCsv();
	}
}
