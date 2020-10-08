package dev.informacoesubs.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.Getter;
import lombok.Setter;

public class UbsGeocodeDto {

	@Getter @Setter
	@JsonAlias("lat")
	private double latitude;
	@Getter @Setter
	@JsonAlias("long")
	private double longitude;
}
