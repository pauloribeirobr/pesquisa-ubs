package dev.informacoesUbs.service;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;

import dev.informacoesUbs.model.Ubs;
import dev.informacoesUbs.model.UbsBase;
import dev.informacoesUbs.repository.UbsBaseRepository;

@SpringBootTest(classes = { ListaUbsService.class })
public class ListaUbsServiceTest {

	@Autowired
	ListaUbsService listaUbsService;

	@MockBean
	UbsBaseRepository ubsBaseRepository;

	@Test
	public void deveImportarCsv() {

		List<UbsBase> listaUbsBase = new ArrayList<UbsBase>();

		listaUbsBase = listaUbsService.importarCsv();

		Assertions.assertThat(listaUbsBase.size() > 0);
	}

	@Test
	public void deveCalcularDistanciaDeTodaLista() {
		
		//Localização - Rua da Consolação - São Paulo/SP
		double latitude = -23.5555321;
		double longitude = -46.6648427;
		UbsBase ubsBase;
		
		List<UbsBase> listaUbsBase = new ArrayList<UbsBase>();
		ubsBase = new UbsBase(-10.9112370014188,-37.0620775222768, "280030", "3492", "US OSWALDO DE SOUZA", "TV ADALTO BOTELHO", "GETULIO VARGAS", "Aracaju", "7931791326", "Desempenho acima da média", "Desempenho muito acima da média", "Desempenho mediano ou  um pouco abaixo da média", "Desempenho acima da média");
		listaUbsBase.add(ubsBase);
		ubsBase = new UbsBase(-23.896, -53.41, "411885", "6811299", "UNIDADE DE ATENCAO PRIMARIA SAUDE DA FAMILIA", "RUA GUILHERME BRUXEL", "CENTRO", "Perobal", "4436251462", "Desempenho muito acima da média", "Desempenho muito acima da média", "Desempenho mediano ou  um pouco abaixo da média", "Desempenho muito acima da média");
		listaUbsBase.add(ubsBase);
		
		List<Ubs> listaUbs = listaUbsService.calculaDistancia(listaUbsBase, latitude,longitude);
		
		Assertions.assertThat(listaUbs.get(0).getDistancia() > 0);
	}
	
	@Test
	public void deveCalcularDistanciaDeTodaListaRetornaPage() {

		//Localização - Rua da Consolação - São Paulo/SP
		double latitude = -23.5555321;
		double longitude = -46.6648427;
		UbsBase ubsBase;
		
		List<UbsBase> listaUbsBase = new ArrayList<UbsBase>();
		ubsBase = new UbsBase(-10.9112370014188,-37.0620775222768, "280030", "3492", "US OSWALDO DE SOUZA", "TV ADALTO BOTELHO", "GETULIO VARGAS", "Aracaju", "7931791326", "Desempenho acima da média", "Desempenho muito acima da média", "Desempenho mediano ou  um pouco abaixo da média", "Desempenho acima da média");
		listaUbsBase.add(ubsBase);
		ubsBase = new UbsBase(-23.896, -53.41, "411885", "6811299", "UNIDADE DE ATENCAO PRIMARIA SAUDE DA FAMILIA", "RUA GUILHERME BRUXEL", "CENTRO", "Perobal", "4436251462", "Desempenho muito acima da média", "Desempenho muito acima da média", "Desempenho mediano ou  um pouco abaixo da média", "Desempenho muito acima da média");
		listaUbsBase.add(ubsBase);
		
		List<Ubs> listaUbs = listaUbsService.calculaDistancia(listaUbsBase, latitude,longitude);
		
		Page<Ubs> listaUbsPage = listaUbsService.converteListParaPage(listaUbs);
		
		Assertions.assertThat(listaUbsPage.getTotalPages() > 0);
		
	}

}
