package com.helalubo.mook.banco.model;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Properties;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnJre;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

import com.helalubo.mook.cuenta.model.Cuenta;

public class BancoTest {
	private Banco banco;
	private Cuenta cuenta1;
	private Cuenta cuenta2;

	@BeforeAll
	static void init() {
		System.out.println("Inicio la clase test");

	}

	@BeforeEach
	void begin() {
		this.cuenta1 = new Cuenta("helalubo", new BigDecimal("700000"));
		this.cuenta2 = new Cuenta("maite", new BigDecimal("900000"));
		this.banco = new Banco("banco");
		banco.addCuenta(cuenta1);
		banco.addCuenta(cuenta2);

	}

	@AfterEach
	void ending() {
		System.out.println("Cerrando metodo de prueba");

	}

	@AfterAll
	static void end() {
		System.out.println("termino la clase test");

	}

	@Test
	void testRelacionBancocuentas() {

		assertAll(
			() -> {
			String expected = "helalubo";
			assertTrue(banco.getCuentas().stream().anyMatch(c -> expected.equals(c.getPersona())));
				},
			() -> {
			int real = banco.getCuentas().size();
			int expected = 2;
			StringBuilder error = new StringBuilder();

			error.append("El tamaño de fue de ").append(real).append(" y no de ").append(expected);

			assertEquals(2, expected, () -> error.toString());
		}, () -> {
			String expected = "helalubo";
			Optional<String> actual = banco.getCuentas().stream().filter(c -> expected.equals(c.getPersona()))
					.map(p -> p.getPersona()).findFirst();
			assertEquals(expected, actual.isPresent() ? actual.get().toString():"Cliente no encontrado"  );

		});
		assertEquals(2, banco.getCuentas().size());

	}

	@Test
	void testTransferirDineroCuentas() {

		banco.transferir(cuenta1, cuenta2, new BigDecimal("99999"));
		assertEquals("999999", cuenta2.getSaldo().toPlainString());
		assertEquals("600001", cuenta1.getSaldo().toPlainString());

	}

	@Test
	void testRelacionBancoCuentas() {
		;

		assertEquals(2, banco.getCuentas().size());

	}

	@Test
	@DisplayName("Verifica si el nombre tiene formato valido")
	void verificaNombreValido() {

		String expected = "banco";
		String actual = banco.getNombre();
		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("Verifica si el nombre tiene formato valido")
	void testTieneCuentaEnElBanco() {

		String expected = "helalubo";
		String actual = banco.getCuentas().stream().filter(c -> expected.equals(c.getPersona()))
				.map(p -> p.getPersona()).findFirst().get().toString();
		assertEquals(expected, actual);

	}

	@DisplayName("Verifica si la cuenta esta presente en el banco")
	@Test
	void testEstaPresente() {

		assertTrue(banco.getCuentas().stream().filter(c -> "helalubo".equals(c.getPersona())).map(p -> p.getPersona())
				.findFirst().isPresent());
	}
	
	
	@Test
	@DisplayName("determinar si es solo para windows")
	@EnabledOnOs({OS.WINDOWS})
	void testSoloWindows() {
		
	}

	@Test
	@DisplayName("determinar si es solo para windows")
	@EnabledOnOs({OS.LINUX})
	void testSoloLinux() {
		
	}
	
	@Test
	@DisplayName("desabilitar para linux")
	@DisabledOnOs({OS.LINUX})
	void testDesabilitarParaLinux() {
		
	}
	
	@Test
	@DisplayName("desabilitar para windows")
	@DisabledOnOs({OS.LINUX})
	void testDesabilitarParaWindows() {
		
	}
	
	@Test
	@DisplayName("desabilitar para windows")
	@DisabledOnJre(JRE.JAVA_8)
	void SoloJDK8() {
		
	}
	@Test
	@DisplayName("desabilitar para windows")
	@EnabledOnJre(JRE.JAVA_11)
	void SoloJDK11() {
		
	}
	
	
	@Test 
	void implimirSystemProperties() {
		Properties properties = System.getProperties();
		properties.forEach((k, v) ->{
			System.out.println(k + "=>" + v);
		});
	}
	
}
