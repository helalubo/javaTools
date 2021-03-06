package com.helalubo.mook.banco.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.helalubo.mook.cuenta.model.Cuenta;

public class Banco {

	private String nombre;
	private List <Cuenta> cuentas;
	
	
	
	
	
	public Banco() {
	
		this.cuentas = new ArrayList<>();
	}
	


	public void addCuenta(Cuenta cuenta)
	{
		this.cuentas.add(cuenta);
		
	}
		

	public List<Cuenta> getCuentas() {
		return cuentas;
	}

	public void setCuentas(List<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}

	public Banco(String nombre) {
		this();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	public void transferir(Cuenta origen, Cuenta destino, BigDecimal monto)
	{
		origen.setSaldo(origen.getSaldo().subtract(monto));
		destino.setSaldo(destino.getSaldo().add(monto));
		
	}
	
}
