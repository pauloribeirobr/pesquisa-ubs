package dev.informacoesubs.service;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import dev.informacoesubs.model.Ubs;
import dev.informacoesubs.model.UbsBase;
import dev.informacoesubs.repository.UbsBaseRepository;
import dev.informacoesubs.service.ListaUbsService;

@SpringBootTest(classes = { ListaUbsService.class })
public class ListaUbsServiceTest {

	@Autowired
	ListaUbsService listaUbsService;

	@MockBean
	UbsBaseRepository ubsBaseRepository;

	@Test
	/**
	 * Verifica se a distância está sendo calculada
	 */
	void deveCalcularDistanciaDeTodaLista() {

		// Localização - Rua da Consolação - São Paulo/SP
		double latitude = -23.5555321;
		double longitude = -46.6648427;
		UbsBase ubsBase;

		List<UbsBase> listaUbsBase = new ArrayList<UbsBase>();
		ubsBase = new UbsBase(-10.9112370014188, -37.0620775222768, "280030", "3492", "US OSWALDO DE SOUZA",
				"TV ADALTO BOTELHO", "GETULIO VARGAS", "Aracaju", "7931791326", "Desempenho acima da média",
				"Desempenho muito acima da média", "Desempenho mediano ou  um pouco abaixo da média",
				"Desempenho acima da média");
		listaUbsBase.add(ubsBase);
		ubsBase = new UbsBase(-23.896, -53.41, "411885", "6811299", "UNIDADE DE ATENCAO PRIMARIA SAUDE DA FAMILIA",
				"RUA GUILHERME BRUXEL", "CENTRO", "Perobal", "4436251462", "Desempenho muito acima da média",
				"Desempenho muito acima da média", "Desempenho mediano ou  um pouco abaixo da média",
				"Desempenho muito acima da média");
		listaUbsBase.add(ubsBase);

		List<Ubs> listaUbs = listaUbsService.calculaDistancia(listaUbsBase, latitude, longitude);

		Assertions.assertThat(listaUbs.get(0).getDistancia()).isPositive();
	}

	@Test
	/**
	 * Retorna a quantidade de itens por página
	 */
	void deveCalcularDistanciaDeTodaListaRetornaListaComQtdePorPagina() {

		// Localização - Rua da Consolação - São Paulo/SP
		double latitude = -23.5555321;
		double longitude = -46.6648427;
		UbsBase ubsBase;
		int qtdePorPagina = 2;
		int pagina = 1;

		List<UbsBase> listaUbsBase = new ArrayList<UbsBase>();

		ubsBase = new UbsBase(-23.6420202255242, -46.5490293502794, "354780", "8591", "UNIDADE DE SAUDE CAMPESTRE",
				"RUA SIMAO JORGE", "CAMPESTRE", "Santo André", "1144734065", "Desempenho muito acima da média",
				"Desempenho mediano ou  um pouco abaixo da média", "Desempenho mediano ou  um pouco abaixo da média",
				"Desempenho acima da média");
		listaUbsBase.add(ubsBase);
		
		ubsBase = new UbsBase(-23.6530494689935, -46.5433859825121, "354780", "2025329",
				"UNIDADE DE SAUDE VILA GUIOMAR", "RUA DAS SILVEIRAS", "VILA GUIOMAR", "Santo André", "1149940835",
				"Desempenho muito acima da média", "Desempenho acima da média",
				"Desempenho mediano ou  um pouco abaixo da média", "Desempenho muito acima da média");
		listaUbsBase.add(ubsBase);
		
		List<Ubs> listaUbs = listaUbsService.calculaDistancia(listaUbsBase, latitude, longitude);
	
		List<Ubs> listaUbsPaginada = listaUbsService.retornaListaUbsPaginada(listaUbs, pagina, qtdePorPagina);
		Assertions.assertThat(listaUbsPaginada.size()).isEqualTo(2);
	}
	
	@Test
	/**
	 * Como o total de páginas é menor que a página selecionada, retorna lista vazia
	 */
	void deveCalcularDistanciaDeTodaListaRetornaListaVazia() {

		// Localização - Rua da Consolação - São Paulo/SP
		double latitude = -23.5555321;
		double longitude = -46.6648427;
		UbsBase ubsBase;
		int qtdePorPagina = 2;
		int pagina = 10;

		List<UbsBase> listaUbsBase = new ArrayList<UbsBase>();

		ubsBase = new UbsBase(-23.6420202255242, -46.5490293502794, "354780", "8591", "UNIDADE DE SAUDE CAMPESTRE",
				"RUA SIMAO JORGE", "CAMPESTRE", "Santo André", "1144734065", "Desempenho muito acima da média",
				"Desempenho mediano ou  um pouco abaixo da média", "Desempenho mediano ou  um pouco abaixo da média",
				"Desempenho acima da média");
		listaUbsBase.add(ubsBase);
		
		ubsBase = new UbsBase(-23.6530494689935, -46.5433859825121, "354780", "2025329",
				"UNIDADE DE SAUDE VILA GUIOMAR", "RUA DAS SILVEIRAS", "VILA GUIOMAR", "Santo André", "1149940835",
				"Desempenho muito acima da média", "Desempenho acima da média",
				"Desempenho mediano ou  um pouco abaixo da média", "Desempenho muito acima da média");
		listaUbsBase.add(ubsBase);
		
		List<Ubs> listaUbs = listaUbsService.calculaDistancia(listaUbsBase, latitude, longitude);
	
		List<Ubs> listaUbsPaginada = listaUbsService.retornaListaUbsPaginada(listaUbs, pagina, qtdePorPagina);

		Assertions.assertThat(listaUbsPaginada.size()).isZero();
	}
}
