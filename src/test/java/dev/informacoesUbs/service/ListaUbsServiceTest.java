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

@SpringBootTest(classes = { ListaUbsService.class })
public class ListaUbsServiceTest {

	@Autowired
	ListaUbsService listaUbsService;

	@MockBean
	UbsBaseRepository ubsBaseRepository;

	@Test
	/**
	 * Deve importar o CSV e criar um Banco de Dados em memória
	 */
	void deveImportarCsv() {

		List<UbsBase> listaUbsBase = new ArrayList<UbsBase>();

		listaUbsBase = listaUbsService.importarCsv();

		Assertions.assertThat(listaUbsBase.size()).isPositive();
	}

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
		int qtdePorPagina = 10;
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
		
		ubsBase = new UbsBase(-23.6517405509942, -46.5609598159777, "354780", "8613", "UNIDADE DE SAUDE VILA PALMARES",
				"PRC AUREA", "VIL PALMARES", "Santo André", "1144216419", "Desempenho muito acima da média",
				"Desempenho acima da média", "Desempenho mediano ou  um pouco abaixo da média",
				"Desempenho acima da média");
		listaUbsBase.add(ubsBase);
		
		ubsBase = new UbsBase(-23.729878664016, -46.4840984344469, "354780", "8885", "U S F RECREIO DA BORDA DO CAMPO",
				"RUA CATURRITA", "REC BORDA DO CAMPO", "Santo André", "1149746861", "Desempenho acima da média",
				"Desempenho mediano ou  um pouco abaixo da média", "Desempenho mediano ou  um pouco abaixo da média",
				"Desempenho acima da média");
		listaUbsBase.add(ubsBase);
		
		ubsBase = new UbsBase(-23.641076087951, -46.5267133712755, "354780", "8621",
				"UNIDADE DE SAUDE PARQUE DAS NACOES", "RUA FREI CANECA", "BANGU", "Santo André", "1149961630",
				"Desempenho mediano ou  um pouco abaixo da média", "Desempenho acima da média",
				"Desempenho mediano ou  um pouco abaixo da média", "Desempenho acima da média");
		listaUbsBase.add(ubsBase);
		
		ubsBase = new UbsBase(-23.6272466182702, -46.5159630775438, "354780", "8583", "UNIDADE DE SAUDE VILA LUCINDA",
				"RUA CACONDE", "VILA LUCINDA", "Santo André", "44791221",
				"Desempenho mediano ou  um pouco abaixo da média", "Desempenho mediano ou  um pouco abaixo da média",
				"Desempenho mediano ou  um pouco abaixo da média", "Desempenho acima da média");
		listaUbsBase.add(ubsBase);
		
		ubsBase = new UbsBase(-23.6650443077081, -46.5496087074266, "354780", "3554570", "U S F VALPARAISO",
				"RUA ANDRADINA", "VALPARAISO", "Santo André", "44279875", "Desempenho muito acima da média",
				"Desempenho mediano ou  um pouco abaixo da média", "Desempenho mediano ou  um pouco abaixo da média",
				"Desempenho acima da média");
		listaUbsBase.add(ubsBase);
		
		ubsBase = new UbsBase(-23.6954605579369, -46.5204477310167, "354780", "8826",
				"UNIDADE DE SAUDE JARDIM ALVORADA", "RUA DR ALMENOR", "JD ALVORADA", "Santo André", "1149724664",
				"Desempenho muito acima da média", "Desempenho acima da média",
				"Desempenho mediano ou  um pouco abaixo da média", "Desempenho acima da média");
		listaUbsBase.add(ubsBase);
		
		ubsBase = new UbsBase(-23.7757658958428, -46.2992405891405, "354780", "8524",
				"P A PARANAPIACABA USF PARANAPIACABA", "AV RODRIGUES ALVES", "PARANAPIACABA", "Santo André",
				"1144390030", "Desempenho muito acima da média", "Desempenho muito acima da média",
				"Desempenho mediano ou  um pouco abaixo da média", "Desempenho muito acima da média");
		listaUbsBase.add(ubsBase);
		
		ubsBase = new UbsBase(-23.6397457122796, -46.49293899536, "354780", "2056836", "UNIDADE DE SAUDE CAPUAVA",
				"RUA IRLANDA", "", "Santo André", "44762787", "Desempenho acima da média",
				"Desempenho mediano ou  um pouco abaixo da média", "Desempenho mediano ou  um pouco abaixo da média",
				"Desempenho acima da média");
		listaUbsBase.add(ubsBase);
		
		ubsBase = new UbsBase(-23.6473739147179, -46.4999556541429, "354780", "3043584", "U S F JARDIM SOROCABA",
				"AV SOROCABA", "PQUE JOA RAMALHO", "Santo André", "44791746", "Desempenho acima da média",
				"Desempenho mediano ou  um pouco abaixo da média", "Desempenho mediano ou  um pouco abaixo da média",
				"Desempenho acima da média");
		listaUbsBase.add(ubsBase);
		
		ubsBase = new UbsBase(-23.7072622776025, -46.4954066276537, "354780", "5085462", "U S F JARDIM SANTO ANDRE",
				"RUA SETE", "JDIM SANTO ANDRE", "Santo André", "1144333058", "Desempenho muito acima da média",
				"Desempenho muito acima da média", "Desempenho muito acima da média", "Desempenho acima da média");
		listaUbsBase.add(ubsBase);
		
		ubsBase = new UbsBase(-23.6581349372857, -46.524095535277, "354780", "8958", "UNIDADE DE SAUDE CENTRO",
				"RUA CAMPOS SALES", "CENTRO", "Santo André", "1144362118", "Desempenho acima da média",
				"Desempenho muito acima da média", "Desempenho mediano ou  um pouco abaixo da média",
				"Desempenho mediano ou  um pouco abaixo da média");
		listaUbsBase.add(ubsBase);
		
		ubsBase = new UbsBase(-23.669893741607, -46.4870810508715, "354780", "8664",
				"UNIDADE DE SAUDE CIDADE SAO JORGE", "AVN SAO PAULO", "CIDADE SAO JORGE", "Santo André", "49783836",
				"Desempenho muito acima da média", "Desempenho mediano ou  um pouco abaixo da média",
				"Desempenho mediano ou  um pouco abaixo da média", "Desempenho acima da média");
		listaUbsBase.add(ubsBase);
		
		ubsBase = new UbsBase(-23.6275041103356, -46.5219712257372, "354780", "8508", "UNIDADE DE SAUDE MOISES FUCKS",
				"RUA ALEXANDRETA", "JD SANTO ANTONIO", "Santo André", "49963406", "Desempenho muito acima da média",
				"Desempenho mediano ou  um pouco abaixo da média", "Desempenho mediano ou  um pouco abaixo da média",
				"Desempenho acima da média");
		listaUbsBase.add(ubsBase);
		
		ubsBase = new UbsBase(-23.6813950538628, -46.5141391754137, "354780", "8680", "UNIDADE DE SAUDE VILA HELENA",
				"AV ANDRADE NEVES", "VIL HELENA", "Santo André", "1144539687", "Desempenho acima da média",
				"Desempenho acima da média", "Desempenho mediano ou  um pouco abaixo da média",
				"Desempenho acima da média");
		listaUbsBase.add(ubsBase);
		
		ubsBase = new UbsBase(-23.6285233497613, -46.4880251884447, "354780", "8931", "U S F JARDIM ITAPOAN ANA MARIA",
				"RUA OTAVIO MANGABEIRA", "JARDIM ANA MARIA", "Santo André", "1144793396", "Desempenho acima da média",
				"Desempenho acima da média", "Desempenho muito acima da média", "Desempenho acima da média");
		listaUbsBase.add(ubsBase);
		
		ubsBase = new UbsBase(-23.6781978607171, -46.5525913238512, "354780", "8567",
				"UNIDADE DE SAUDE JARDIM BOM PASTOR", "RUA JOSE D ANGELO", "BOM PASTOR", "Santo André", "1144268988",
				"Desempenho muito acima da média", "Desempenho muito acima da média",
				"Desempenho mediano ou  um pouco abaixo da média", "Desempenho acima da média");
		listaUbsBase.add(ubsBase);
		
		ubsBase = new UbsBase(-23.7005996704095, -46.5047621726976, "354780", "8788", "UNIDADE DE SAUDE VILA LUZITA",
				"AVN DOM PEDRO I", "VIL LUZITA", "Santo André", "1144535755", "Desempenho acima da média",
				"Desempenho mediano ou  um pouco abaixo da média", "Desempenho mediano ou  um pouco abaixo da média",
				"Desempenho acima da média");
		listaUbsBase.add(ubsBase);
		
		ubsBase = new UbsBase(-23.7135171890252, -46.518344879149, "354780", "29181", "U S F JARDIM IRENE II",
				"RUA LEVI DE SOUZA", "JARDIM CIPRESTE", "Santo André", "1149734791",
				"Desempenho mediano ou  um pouco abaixo da média", "Desempenho mediano ou  um pouco abaixo da média",
				"Desempenho mediano ou  um pouco abaixo da média", "Desempenho acima da média");
		listaUbsBase.add(ubsBase);
		
		ubsBase = new UbsBase(-23.7097299098962, -46.5060067176805, "354780", "8699", "UNIDADE DE SAUDE JARDIM IRENE",
				"ESTRADA DA CATA PRETA", "JARDIM IRENE", "Santo André", "44535781", "Desempenho acima da média",
				"Desempenho acima da média", "Desempenho mediano ou  um pouco abaixo da média",
				"Desempenho acima da média");
		listaUbsBase.add(ubsBase);
		
		ubsBase = new UbsBase(-23.6740887165063, -46.4950847625719, "354780", "8761", "UNIDADE DE SAUDE CENTREVILLE",
				"RUA BEZERRA DE MENEZES", "CENTREVILLE", "Santo André", "44583500",
				"Desempenho mediano ou  um pouco abaixo da média", "Desempenho mediano ou  um pouco abaixo da média",
				"Desempenho mediano ou  um pouco abaixo da média", "Desempenho acima da média");
		listaUbsBase.add(ubsBase);
		
		ubsBase = new UbsBase(-23.6327075958245, -46.4946341514574, "354780", "5380278", "U S F JARDIM SANTO ALBERTO",
				"RUA ALMADA", "JDIM SANTO ALBERTO", "Santo André", "1144758584",
				"Desempenho mediano ou  um pouco abaixo da média", "Desempenho acima da média",
				"Desempenho muito acima da média", "Desempenho acima da média");
		listaUbsBase.add(ubsBase);
		
		ubsBase = new UbsBase(-23.6806440353387, -46.5327000617967, "354780", "8605", "UNIDADE DE SAUDE BAIRRO PARAISO",
				"RUA JUQUIA", "VILA ASSUNCAO", "Santo André", "1144232250", "Desempenho muito acima da média",
				"Desempenho acima da média", "Desempenho mediano ou  um pouco abaixo da média",
				"Desempenho acima da média");
		listaUbsBase.add(ubsBase);
		
		ubsBase = new UbsBase(-23.6251866817468, -46.5347385406481, "354780", "8532", "UNIDADE DE SAUDE UTINGA",
				"ALAMEDA MEXICO", "VIL METALURGICA", "Santo André", "49761000",
				"Desempenho mediano ou  um pouco abaixo da média", "Desempenho acima da média",
				"Desempenho mediano ou  um pouco abaixo da média", "Desempenho acima da média");
		listaUbsBase.add(ubsBase);
		
		ubsBase = new UbsBase(-23.6300361156457, -46.5077447891222, "354780", "8656",
				"UNIDADE DE SAUDE PARQUE NOVO ORATORIO", "RUA TUNISIA", "PRQ NOVO ORATORIO", "Santo André", "44797368",
				"Desempenho acima da média", "Desempenho acima da média",
				"Desempenho mediano ou  um pouco abaixo da média", "Desempenho acima da média");
		listaUbsBase.add(ubsBase);
		
		List<Ubs> listaUbs = listaUbsService.calculaDistancia(listaUbsBase, latitude, longitude);

	
		List<Ubs> listaUbsPaginada = listaUbsService.retornaListaUbsPaginada(listaUbs, pagina, qtdePorPagina);

		System.out.println("Total de Registros nessa página " + listaUbsPaginada.size());
		Assertions.assertThat(listaUbsPaginada.size()).isEqualTo(10);

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
		int qtdePorPagina = 10;
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
		
		ubsBase = new UbsBase(-23.6517405509942, -46.5609598159777, "354780", "8613", "UNIDADE DE SAUDE VILA PALMARES",
				"PRC AUREA", "VIL PALMARES", "Santo André", "1144216419", "Desempenho muito acima da média",
				"Desempenho acima da média", "Desempenho mediano ou  um pouco abaixo da média",
				"Desempenho acima da média");
		listaUbsBase.add(ubsBase);
		
		ubsBase = new UbsBase(-23.729878664016, -46.4840984344469, "354780", "8885", "U S F RECREIO DA BORDA DO CAMPO",
				"RUA CATURRITA", "REC BORDA DO CAMPO", "Santo André", "1149746861", "Desempenho acima da média",
				"Desempenho mediano ou  um pouco abaixo da média", "Desempenho mediano ou  um pouco abaixo da média",
				"Desempenho acima da média");
		listaUbsBase.add(ubsBase);
		
		ubsBase = new UbsBase(-23.641076087951, -46.5267133712755, "354780", "8621",
				"UNIDADE DE SAUDE PARQUE DAS NACOES", "RUA FREI CANECA", "BANGU", "Santo André", "1149961630",
				"Desempenho mediano ou  um pouco abaixo da média", "Desempenho acima da média",
				"Desempenho mediano ou  um pouco abaixo da média", "Desempenho acima da média");
		listaUbsBase.add(ubsBase);
		
		ubsBase = new UbsBase(-23.6272466182702, -46.5159630775438, "354780", "8583", "UNIDADE DE SAUDE VILA LUCINDA",
				"RUA CACONDE", "VILA LUCINDA", "Santo André", "44791221",
				"Desempenho mediano ou  um pouco abaixo da média", "Desempenho mediano ou  um pouco abaixo da média",
				"Desempenho mediano ou  um pouco abaixo da média", "Desempenho acima da média");
		listaUbsBase.add(ubsBase);
		
		ubsBase = new UbsBase(-23.6650443077081, -46.5496087074266, "354780", "3554570", "U S F VALPARAISO",
				"RUA ANDRADINA", "VALPARAISO", "Santo André", "44279875", "Desempenho muito acima da média",
				"Desempenho mediano ou  um pouco abaixo da média", "Desempenho mediano ou  um pouco abaixo da média",
				"Desempenho acima da média");
		listaUbsBase.add(ubsBase);
		
		ubsBase = new UbsBase(-23.6954605579369, -46.5204477310167, "354780", "8826",
				"UNIDADE DE SAUDE JARDIM ALVORADA", "RUA DR ALMENOR", "JD ALVORADA", "Santo André", "1149724664",
				"Desempenho muito acima da média", "Desempenho acima da média",
				"Desempenho mediano ou  um pouco abaixo da média", "Desempenho acima da média");
		listaUbsBase.add(ubsBase);
		
		ubsBase = new UbsBase(-23.7757658958428, -46.2992405891405, "354780", "8524",
				"P A PARANAPIACABA USF PARANAPIACABA", "AV RODRIGUES ALVES", "PARANAPIACABA", "Santo André",
				"1144390030", "Desempenho muito acima da média", "Desempenho muito acima da média",
				"Desempenho mediano ou  um pouco abaixo da média", "Desempenho muito acima da média");
		listaUbsBase.add(ubsBase);
		
		ubsBase = new UbsBase(-23.6397457122796, -46.49293899536, "354780", "2056836", "UNIDADE DE SAUDE CAPUAVA",
				"RUA IRLANDA", "", "Santo André", "44762787", "Desempenho acima da média",
				"Desempenho mediano ou  um pouco abaixo da média", "Desempenho mediano ou  um pouco abaixo da média",
				"Desempenho acima da média");
		listaUbsBase.add(ubsBase);
		
		ubsBase = new UbsBase(-23.6473739147179, -46.4999556541429, "354780", "3043584", "U S F JARDIM SOROCABA",
				"AV SOROCABA", "PQUE JOA RAMALHO", "Santo André", "44791746", "Desempenho acima da média",
				"Desempenho mediano ou  um pouco abaixo da média", "Desempenho mediano ou  um pouco abaixo da média",
				"Desempenho acima da média");
		listaUbsBase.add(ubsBase);
		
		ubsBase = new UbsBase(-23.7072622776025, -46.4954066276537, "354780", "5085462", "U S F JARDIM SANTO ANDRE",
				"RUA SETE", "JDIM SANTO ANDRE", "Santo André", "1144333058", "Desempenho muito acima da média",
				"Desempenho muito acima da média", "Desempenho muito acima da média", "Desempenho acima da média");
		listaUbsBase.add(ubsBase);
		
		ubsBase = new UbsBase(-23.6581349372857, -46.524095535277, "354780", "8958", "UNIDADE DE SAUDE CENTRO",
				"RUA CAMPOS SALES", "CENTRO", "Santo André", "1144362118", "Desempenho acima da média",
				"Desempenho muito acima da média", "Desempenho mediano ou  um pouco abaixo da média",
				"Desempenho mediano ou  um pouco abaixo da média");
		listaUbsBase.add(ubsBase);
		
		ubsBase = new UbsBase(-23.669893741607, -46.4870810508715, "354780", "8664",
				"UNIDADE DE SAUDE CIDADE SAO JORGE", "AVN SAO PAULO", "CIDADE SAO JORGE", "Santo André", "49783836",
				"Desempenho muito acima da média", "Desempenho mediano ou  um pouco abaixo da média",
				"Desempenho mediano ou  um pouco abaixo da média", "Desempenho acima da média");
		listaUbsBase.add(ubsBase);
		
		ubsBase = new UbsBase(-23.6275041103356, -46.5219712257372, "354780", "8508", "UNIDADE DE SAUDE MOISES FUCKS",
				"RUA ALEXANDRETA", "JD SANTO ANTONIO", "Santo André", "49963406", "Desempenho muito acima da média",
				"Desempenho mediano ou  um pouco abaixo da média", "Desempenho mediano ou  um pouco abaixo da média",
				"Desempenho acima da média");
		listaUbsBase.add(ubsBase);
		
		ubsBase = new UbsBase(-23.6813950538628, -46.5141391754137, "354780", "8680", "UNIDADE DE SAUDE VILA HELENA",
				"AV ANDRADE NEVES", "VIL HELENA", "Santo André", "1144539687", "Desempenho acima da média",
				"Desempenho acima da média", "Desempenho mediano ou  um pouco abaixo da média",
				"Desempenho acima da média");
		listaUbsBase.add(ubsBase);
		
		ubsBase = new UbsBase(-23.6285233497613, -46.4880251884447, "354780", "8931", "U S F JARDIM ITAPOAN ANA MARIA",
				"RUA OTAVIO MANGABEIRA", "JARDIM ANA MARIA", "Santo André", "1144793396", "Desempenho acima da média",
				"Desempenho acima da média", "Desempenho muito acima da média", "Desempenho acima da média");
		listaUbsBase.add(ubsBase);
		
		ubsBase = new UbsBase(-23.6781978607171, -46.5525913238512, "354780", "8567",
				"UNIDADE DE SAUDE JARDIM BOM PASTOR", "RUA JOSE D ANGELO", "BOM PASTOR", "Santo André", "1144268988",
				"Desempenho muito acima da média", "Desempenho muito acima da média",
				"Desempenho mediano ou  um pouco abaixo da média", "Desempenho acima da média");
		listaUbsBase.add(ubsBase);
		
		ubsBase = new UbsBase(-23.7005996704095, -46.5047621726976, "354780", "8788", "UNIDADE DE SAUDE VILA LUZITA",
				"AVN DOM PEDRO I", "VIL LUZITA", "Santo André", "1144535755", "Desempenho acima da média",
				"Desempenho mediano ou  um pouco abaixo da média", "Desempenho mediano ou  um pouco abaixo da média",
				"Desempenho acima da média");
		listaUbsBase.add(ubsBase);
		
		ubsBase = new UbsBase(-23.7135171890252, -46.518344879149, "354780", "29181", "U S F JARDIM IRENE II",
				"RUA LEVI DE SOUZA", "JARDIM CIPRESTE", "Santo André", "1149734791",
				"Desempenho mediano ou  um pouco abaixo da média", "Desempenho mediano ou  um pouco abaixo da média",
				"Desempenho mediano ou  um pouco abaixo da média", "Desempenho acima da média");
		listaUbsBase.add(ubsBase);
		
		ubsBase = new UbsBase(-23.7097299098962, -46.5060067176805, "354780", "8699", "UNIDADE DE SAUDE JARDIM IRENE",
				"ESTRADA DA CATA PRETA", "JARDIM IRENE", "Santo André", "44535781", "Desempenho acima da média",
				"Desempenho acima da média", "Desempenho mediano ou  um pouco abaixo da média",
				"Desempenho acima da média");
		listaUbsBase.add(ubsBase);
		
		ubsBase = new UbsBase(-23.6740887165063, -46.4950847625719, "354780", "8761", "UNIDADE DE SAUDE CENTREVILLE",
				"RUA BEZERRA DE MENEZES", "CENTREVILLE", "Santo André", "44583500",
				"Desempenho mediano ou  um pouco abaixo da média", "Desempenho mediano ou  um pouco abaixo da média",
				"Desempenho mediano ou  um pouco abaixo da média", "Desempenho acima da média");
		listaUbsBase.add(ubsBase);
		
		ubsBase = new UbsBase(-23.6327075958245, -46.4946341514574, "354780", "5380278", "U S F JARDIM SANTO ALBERTO",
				"RUA ALMADA", "JDIM SANTO ALBERTO", "Santo André", "1144758584",
				"Desempenho mediano ou  um pouco abaixo da média", "Desempenho acima da média",
				"Desempenho muito acima da média", "Desempenho acima da média");
		listaUbsBase.add(ubsBase);
		
		ubsBase = new UbsBase(-23.6806440353387, -46.5327000617967, "354780", "8605", "UNIDADE DE SAUDE BAIRRO PARAISO",
				"RUA JUQUIA", "VILA ASSUNCAO", "Santo André", "1144232250", "Desempenho muito acima da média",
				"Desempenho acima da média", "Desempenho mediano ou  um pouco abaixo da média",
				"Desempenho acima da média");
		listaUbsBase.add(ubsBase);
		
		ubsBase = new UbsBase(-23.6251866817468, -46.5347385406481, "354780", "8532", "UNIDADE DE SAUDE UTINGA",
				"ALAMEDA MEXICO", "VIL METALURGICA", "Santo André", "49761000",
				"Desempenho mediano ou  um pouco abaixo da média", "Desempenho acima da média",
				"Desempenho mediano ou  um pouco abaixo da média", "Desempenho acima da média");
		listaUbsBase.add(ubsBase);
		
		ubsBase = new UbsBase(-23.6300361156457, -46.5077447891222, "354780", "8656",
				"UNIDADE DE SAUDE PARQUE NOVO ORATORIO", "RUA TUNISIA", "PRQ NOVO ORATORIO", "Santo André", "44797368",
				"Desempenho acima da média", "Desempenho acima da média",
				"Desempenho mediano ou  um pouco abaixo da média", "Desempenho acima da média");
		listaUbsBase.add(ubsBase);
		
		List<Ubs> listaUbs = listaUbsService.calculaDistancia(listaUbsBase, latitude, longitude);

	
		List<Ubs> listaUbsPaginada = listaUbsService.retornaListaUbsPaginada(listaUbs, pagina, qtdePorPagina);

		System.out.println("Total de Registros nessa página " + listaUbsPaginada.size());
		Assertions.assertThat(listaUbsPaginada.size()).isEqualTo(0);

	}

}
