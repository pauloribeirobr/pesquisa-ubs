package dev.informacoesUbs.service;

import org.springframework.stereotype.Service;

/**
 * Classe relacionada ao Cálculo de Distância (em Km) de 2 pontos (referenciados com latitude e longitude)
 * 
 * Baseado na Fórmula de Haversine 
 * http://rosettacode.org/wiki/Haversine_formula#Java
 * @author Paulo Ribeiro <pauloribeirobr@gmail.com>
 *
 */
@Service
public class CalculoDistancia {

	public static final double RAIO = 6372.8;
	
	/**
	 * Efetua o cálculo da distância (em KM) entre 2 pontos
	 * @param latitudeOrigem
	 * @param longitudeOrigem
	 * @param latitudeDestino
	 * @param longitudeDestino
	 * @return
	 */
	public static double distanciaEmKm(double latitudeOrigem, double longitudeOrigem, double latitudeDestino, double longitudeDestino) {

        double dLat = Math.toRadians(latitudeDestino - latitudeOrigem);
        double dLon = Math.toRadians(longitudeDestino - longitudeOrigem);
        latitudeOrigem = Math.toRadians(latitudeOrigem);
        latitudeDestino = Math.toRadians(latitudeDestino);
 
        double a = Math.pow(Math.sin(dLat / 2),2) + Math.pow(Math.sin(dLon / 2),2) * Math.cos(latitudeOrigem) * Math.cos(latitudeDestino);
        double c = 2 * Math.asin(Math.sqrt(a));
        return RAIO * c;
	}
}
