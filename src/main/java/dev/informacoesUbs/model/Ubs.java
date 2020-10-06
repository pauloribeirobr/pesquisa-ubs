package dev.informacoesUbs.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class Ubs {

	public Ubs() {
	}
	
	public Ubs(double latitude, double longitude, String codigoMunicipio, String codigoCnes, String nome,
			String endereco, String bairro, String cidade, String telefone, String situacaoEstrutura,
			String situacaoAdaptacoes, String situacaoEquipamentos, String situacaoMedicamento, double distancia) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
		this.codigoMunicipio = codigoMunicipio;
		this.codigoCnes = codigoCnes;
		this.nome = nome;
		this.endereco = endereco;
		this.bairro = bairro;
		this.cidade = cidade;
		this.telefone = telefone;
		this.situacaoEstrutura = situacaoEstrutura;
		this.situacaoAdaptacoes = situacaoAdaptacoes;
		this.situacaoEquipamentos = situacaoEquipamentos;
		this.situacaoMedicamento = situacaoMedicamento;
		this.distancia = distancia;
	}
	
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
	@Getter
	private double distancia;

}
