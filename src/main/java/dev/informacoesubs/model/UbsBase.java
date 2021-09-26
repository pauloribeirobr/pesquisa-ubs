package dev.informacoesubs.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;

/**
 * Importação dos registros do CSV em um banco em memória para agilizar o processamento.
 * 
 * @author Paulo Ribeiro <pauloribeirobr@gmail.com>
 *
 */
@Entity
@Table(name = "ubs_base")
public class UbsBase {

	public UbsBase() {
	}
	
	public UbsBase(double latitude, double longitude, String codigoMunicipio, String codigoCNES, String nome,
			String endereco, String bairro, String cidade, String telefone, String situacaoEstrutura,
			String situacaoAdaptacoes, String situacaoEquipamentos, String situacaoMedicamento) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
		this.codigoMunicipio = codigoMunicipio;
		this.codigoCnes = codigoCNES;
		this.nome = nome;
		this.endereco = endereco;
		this.bairro = bairro;
		this.cidade = cidade;
		this.telefone = telefone;
		this.situacaoEstrutura = situacaoEstrutura;
		this.situacaoAdaptacoes = situacaoAdaptacoes;
		this.situacaoEquipamentos = situacaoEquipamentos;
		this.situacaoMedicamento = situacaoMedicamento;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Getter
	private Integer id;
	@Getter
	private double latitude;
	@Getter
	private double longitude;
	@Getter
	private String codigoMunicipio;
	@Getter
	private String codigoCnes;
	@Getter
	private String nome;
	@Getter
	private String endereco;
	@Getter
	private String bairro;
	@Getter
	private String cidade;
	@Getter
	private String telefone;
	@Getter
	private String situacaoEstrutura;
	@Getter
	private String situacaoAdaptacoes;
	@Getter
	private String situacaoEquipamentos;
	@Getter
	private String situacaoMedicamento;

}
