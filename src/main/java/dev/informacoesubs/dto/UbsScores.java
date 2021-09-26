package dev.informacoesubs.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.Getter;
import lombok.Setter;

public class UbsScores {

	@Getter @Setter
	private String size;
	@Getter @Setter
	@JsonAlias("adaptation_for_seniors")
	private String adaptationForSeniors;
	@Getter @Setter
	@JsonAlias("medical_equipment")
	private String medicalEquipment;
	@Getter @Setter
	private String medicine;
}
