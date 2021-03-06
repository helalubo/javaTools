package com.helalubo.mook.cuenta.model;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import com.helalubo.mook.cuenta.exceptions.DineroInsuficienteException;

public class CuentaTest {
	

	@Test	
	void testNombreCuenta() {
		Cuenta cuenta = new Cuenta("helalubo", new BigDecimal("100.000"));
		
		String expected = "helalubo";
		String actual = cuenta.getPersona();
		
		assertEquals(expected, actual);
		
	}
	@Test
	void testSaldoCliente() {
		Cuenta cuenta = new Cuenta("helalubo", new BigDecimal("100.000"));
		assertEquals(100.000, cuenta.getSaldo().doubleValue());
	}
	
	@Test
	void testSaldoNoNegativo()
	{
		Cuenta cuenta = new Cuenta("helalubo", new BigDecimal("100.000"));
		assertFalse(cuenta.getSaldo().compareTo(BigDecimal.ZERO)< 0);
		
	}
	
	@Test
	void testReferenciaCuenta() {
		Cuenta cuenta = new Cuenta("helalubo", new BigDecimal("100.000"));
		Cuenta cuentaComparate = new Cuenta("helalubo", new BigDecimal("100.000"));
		

	//	assertNotEquals(cuenta, cuentaComparate); // verifica por referencia
		assertEquals(cuentaComparate, cuenta);
		
	}
	
	@Test
	void testDebitoCuenta() throws DineroInsuficienteException {
		Cuenta cuenta = new Cuenta("helalubo", new BigDecimal("100.000"));
		cuenta.debito(new BigDecimal(50));
		assertEquals("50.000", cuenta.getSaldo().toPlainString());
		
		
		
	}
	
	@Test
	void testCreditoCuenta() {
		Cuenta cuenta = new Cuenta("helalubo", new BigDecimal("1000.000"));
		cuenta.credito(new BigDecimal(200));
		assertEquals("1200.000", cuenta.getSaldo().toPlainString());
		
		
		
	}
	@Test
	void testSaldoNotNull() {
		Cuenta cuenta = new Cuenta("helalubo", new BigDecimal("100.000"));
		assertNotNull(cuenta.getSaldo().intValue());
		
	}
	
	@Test
	void testDineroInsuficiente() {
		Cuenta cuenta = new Cuenta("helalubo", new BigDecimal("100.000"));
		
	Exception e =	assertThrows(DineroInsuficienteException.class, () ->{
			cuenta.debito(new BigDecimal("199.999"));
		});
	String actual = e.getMessage();
	String expected = "Fondos insuficientes";
	
	assertEquals(expected, actual);
	
	}
	


}
