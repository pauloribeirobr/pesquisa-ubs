package dev.informacoesubs.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import dev.informacoesubs.service.CalculoDistancia;

class CalculoDistanciaTest {

	@Test
	void deveCalcularDistancia() {
		
		double distancia = CalculoDistancia.distanciaEmKm(36.12, -86.67, 33.94, -118.40);
		
		Assertions.assertEquals(2887.2599506071106, distancia);
		
	}
}
