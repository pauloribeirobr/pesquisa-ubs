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

import dev.informacoesubs.dto.ListaUbsDto;
import dev.informacoesubs.dto.UbsDto;
import dev.informacoesubs.dto.UbsGeocodeDto;
import dev.informacoesubs.dto.UbsScores;
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
	
    /**
     * Importa o arquivo CSV e cria um Banco de Dados em memória
     * @return
     */
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
	 * Lista todas as UBSs importadas pelo CSV
	 * @return
	 */
	public List<UbsBase> listaUBSs() {
		
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
	
	public ListaUbsDto listaUBSsProximas(Double latitude, Double longitude, Integer pagina, Integer qtdePorPagina) {
		
		ListaUbsDto listaUbsDto = new ListaUbsDto();
		List<UbsDto> relacaoUbs = new ArrayList<UbsDto>();
		UbsDto ubsDto;
		UbsGeocodeDto ubsGeoCodeDto;
		UbsScores ubsScores;
		
		logger.info("Lista todas as UBSs");
		List<UbsBase> listaUbsBase = listaUBSs();
		
		logger.info("Calculando a distância entre as UBSs e as coordenadas informadas");
		List<Ubs> listaUbs = calculaDistancia(listaUbsBase, latitude, longitude);
		
		logger.info("Filtrando pela página " + pagina + ", com " + qtdePorPagina + " máxina de registros por página");
		List<Ubs> listaUbsPaginada = retornaListaUbsPaginada(listaUbs, pagina, qtdePorPagina);
		
		logger.info("Iniciando a formatação da resposta");
				
		
		listaUbsDto.setCurrentPage(pagina);
		listaUbsDto.setPerPage(qtdePorPagina);
		listaUbsDto.setTotalEntries(listaUbs.size());
		
		for(Ubs ubs : listaUbsPaginada ) {
			
			ubsDto = new UbsDto();
			ubsDto.setId(1);
			ubsDto.setName(ubs.getNome());
			ubsDto.setAddress(ubs.getEndereco());
			ubsDto.setCity(ubs.getCidade());
			ubsDto.setPhone(ubs.getTelefone());
			
			ubsGeoCodeDto = new UbsGeocodeDto();
			ubsGeoCodeDto.setLatitude(ubs.getLatitude());
			ubsGeoCodeDto.setLongitude(ubs.getLongitude());
			ubsDto.setGeocode(ubsGeoCodeDto);
			
			ubsScores = new UbsScores();
			ubsScores.setAdaptationForSeniors(ubs.getSituacaoAdaptacoes());
			ubsScores.setMedicalEquipment(ubs.getSituacaoEquipamentos());
			ubsScores.setMedicine(ubs.getSituacaoMedicamento());
			ubsScores.setSize(ubs.getSituacaoEstrutura());
			ubsDto.setScores(ubsScores);
			
			relacaoUbs.add(ubsDto);
		}
		
		listaUbsDto.setEntries(relacaoUbs);
		return listaUbsDto;
	}

}
