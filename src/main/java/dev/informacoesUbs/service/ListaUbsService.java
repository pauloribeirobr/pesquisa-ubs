package dev.informacoesubs.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Service;

import dev.informacoesubs.model.Ubs;
import dev.informacoesubs.model.UbsBase;
import dev.informacoesubs.repository.UbsBaseRepository;

@Service
public class ListaUbsService {
	
	@Autowired
	UbsBaseRepository ubsBaseRepository;
	
    public static final String PLANILHA_UBS = new FileSystemResource("").getFile().getAbsolutePath() + "/" + "ubs.csv";
    public static final String cvsSplitBy = ",";
    
    Logger logger = LoggerFactory.getLogger(ListaUbsService.class);
	
	public List<UbsBase> importarCsv() {
		
		BufferedReader bufferedReader;
		UbsBase ubsBase;
		int contador = 1;
		
		logger.info("Iniciando importação do CSV: " + PLANILHA_UBS );
		try {
			bufferedReader = new BufferedReader(new FileReader(PLANILHA_UBS));
			while(bufferedReader.readLine() != null) {
				String[] ubsDados = bufferedReader.readLine().split(cvsSplitBy);
				
				ubsBase = new UbsBase(Double.valueOf(ubsDados[0]), Double.valueOf(ubsDados[1]), ubsDados[2], ubsDados[3], ubsDados[4], ubsDados[5], ubsDados[6], ubsDados[7], ubsDados[8], ubsDados[9], ubsDados[10], ubsDados[11], ubsDados[12]);
				ubsBaseRepository.save(ubsBase);
				logger.info("Importada Linha: " + contador + " - " + ubsBase.getNome() );
				contador++;
			}
		} catch (Exception e) {
			logger.error("Erro ao tentar importar a linha " + contador + " do CSV no Banco de Dados. Erro:" + e.getMessage());
		} 
		logger.info("Finalização importação do CSV: " + PLANILHA_UBS );
		return ubsBaseRepository.findAll();
	}

	/**
	 * Efetua o Cálculo de Distância de todos os itens de uma Lista e ordena.
	 * 
	 * @author Paulo Ribeiro <pauloribeirobr@gmail.com>
	 * 
	 * @param listaUbsBase - base de dados importada do CSV do Portal Brasileiro de Dados Abertos - https://dados.gov.br/dataset/unidades-basicas-de-saude-ubs
	 * @param latitude - latitude do ponto de origem
	 * @param longitude - longitude do ponto de origem
	 * @return
	 */
	public List<Ubs> calculaDistancia(List<UbsBase> listaUbsBase, double latitude, double longitude) {
		
		//Converte uma lista em outra + efetua cálculo de distância
		List<Ubs> listaUbs = listaUbsBase.stream().map(ubsBase -> new Ubs(ubsBase.getLatitude(), ubsBase.getLongitude(), ubsBase.getCodigoMunicipio(), ubsBase.getCodigoCnes(), ubsBase.getNome(), ubsBase.getEndereco(), ubsBase.getBairro(), ubsBase.getCidade(), ubsBase.getTelefone(), ubsBase.getSituacaoEstrutura(), ubsBase.getSituacaoAdaptacoes(), ubsBase.getSituacaoEquipamentos(), ubsBase.getSituacaoMedicamento(), CalculoDistancia.distanciaEmKm(latitude, longitude, ubsBase.getLatitude(), ubsBase.getLongitude()))).collect(Collectors.toList());
		
		//Ordena por distância
		listaUbs.sort( (Ubs ubs1, Ubs ubs2)->Double.compare(ubs1.getDistancia(),ubs2.getDistancia()) );
		
		return listaUbs;
	}

	/**
	 * Retorna uma Lista de UBSs filtrada por página página
	 * 
	 * @param listaUbs
	 * @param pagina
	 * @param qtdePorPagina
	 * @return
	 */
	public List<Ubs> retornaListaUbsPaginada(List<Ubs> listaUbs, Integer pagina, Integer qtdePorPagina) {
		
		pagina = pagina == null ? 1 : pagina;
		qtdePorPagina = qtdePorPagina == null ? 10 : qtdePorPagina;
		List<Ubs> listaUbsPaginada = new ArrayList<>();
		
		PagedListHolder<Ubs> page = new PagedListHolder<>(listaUbs);
		page.setPageSize(qtdePorPagina); 
		page.setPage(pagina);

		if(page.getPageCount() >= pagina) {
			listaUbsPaginada = page.getPageList();
		}

		return listaUbsPaginada;
	}

}
