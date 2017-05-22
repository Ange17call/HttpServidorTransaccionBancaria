package com.edu;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component("manejadorPersistencia")
public class ManejadorPersistenciaImpl implements ManejadorPersistencia{
	
	@Override
	public CuentaBancaria buscarCuenta(String numeroCuenta) {
		
		CuentaBancaria cliente1=new CuentaBancaria("002","Angel1",45);
		CuentaBancaria cliente2=new CuentaBancaria("003","Angel2",46);
		CuentaBancaria cliente3=new CuentaBancaria("004","Angel3",47);
		CuentaBancaria cliente4=new CuentaBancaria("005","Angel4",48);
		CuentaBancaria cliente5=new CuentaBancaria("006","Angel5",49);
		List<CuentaBancaria> clientes = new ArrayList<CuentaBancaria>();
		clientes.add(cliente1);
		clientes.add(cliente2);
		clientes.add(cliente3);
		clientes.add(cliente4);
		clientes.add(cliente5);
		
		for (CuentaBancaria cuentaBancaria : clientes) {
			
			if(cuentaBancaria.getNumeroCuenta().equals(numeroCuenta)){
				return cuentaBancaria;
			}
		}
		return null;
	}

}


