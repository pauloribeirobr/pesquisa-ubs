package dev.informacoesubs.dto;

import lombok.Getter;
import lombok.Setter;

public class UbsDto {

	@Getter @Setter
	private int id;
	@Getter @Setter
	private String name;
	@Getter @Setter
	private String address;
	@Getter @Setter
	private String city;
	@Getter @Setter
	private String phone;
	@Getter @Setter
	private UbsGeocodeDto geocode;
	@Getter @Setter
	private UbsScores scores;
	
}
