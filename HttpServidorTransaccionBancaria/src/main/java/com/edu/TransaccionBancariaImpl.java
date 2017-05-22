package com.edu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("transaccionBancaria")
public class TransaccionBancariaImpl implements TransaccionBancaria {
	
	@Autowired
	private ManejadorPersistenciaImpl manejadorPersistencia;
	
	/*@Autowired
	 * public void setManejadorPersistencia(ManejadorPersistenciaImpl manejadorPersistencia) {
		this.manejadorPersistencia = manejadorPersistencia;
	}*/

	@Override
	public String realizarTransferencia(String cuenta1, String cuenta2, float cantidad) {
		
		CuentaBancaria objCuenta1 =manejadorPersistencia.buscarCuenta(cuenta1);
		CuentaBancaria objCuenta2 = manejadorPersistencia.buscarCuenta(cuenta2);
		System.out.println("Saldo Actual antes de transaccion: "+objCuenta1.getNumeroCuenta()+" ===> "+objCuenta1.getSaldo());
		System.out.println("Saldo Actual antes de transaccion: "+objCuenta2.getNumeroCuenta()+" ===> "+objCuenta2.getSaldo());
		if(objCuenta1.getSaldo()>=cantidad){
			System.out.println("Transferencia de la cuenta:  "+"  "+objCuenta1.getNumeroCuenta()+" "+"a"+"  "+objCuenta2.getNumeroCuenta()+"  de"+"  "+  cantidad+"  dolares");
			objCuenta2.deposito(cantidad);
			objCuenta1.retiro(cantidad);
			System.out.println("Saldo Actual antes de transaccion: "+objCuenta1.getNumeroCuenta()+" ===> "+objCuenta1.getSaldo());
			System.out.println("Saldo Actual antes de transaccion: "+objCuenta2.getNumeroCuenta()+" ===> "+objCuenta2.getSaldo());
			return "Transaccion Exitosa";
		}
		else{
			System.out.println("Saldo insuficiente");
			return "Transaccion Fallida Saldo  insufuciente. ";
		}
		
		
	}
	
	
}
