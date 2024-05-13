package ar.utn.frbb.tup.utils;

import java.util.HashMap;
import java.util.Map;

public class OperacionesBancarias {
    private Map<String, CuentaBancaria> cuentasBancarias;

    // Constructor
    public OperacionesBancarias() {
        this.cuentasBancarias = new HashMap<>();
    }
    //metodos
    //agrega una cuenta bancaria
    public void agregarCuentaBancaria(String numCuenta, CuentaBancaria cuenta) {
        cuentasBancarias.put(numCuenta, cuenta);
    }

    //obtiene cuenta segun su numero de cuenta
    public CuentaBancaria obtenerCuentaBancaria(String numCuenta) {
        return cuentasBancarias.get(numCuenta);
    }

    // para realizar deposito
    public void depositarDinero(String numCuenta, double monto) {
        CuentaBancaria cuenta = obtenerCuentaBancaria(numCuenta);
        if (cuenta != null) {
            cuenta.depositarDinero(monto);
        } else {
            System.out.println("La cuenta bancaria no existe.");
        }
    }

    public void retirarDinero(String numCuenta, double monto) {
        CuentaBancaria cuenta = obtenerCuentaBancaria(numCuenta);
        if (cuenta != null) {
            cuenta.retirarDinero(monto);
        } else {
            System.out.println("La cuenta bancaria no existe.");
        }
    }

    public void transferirDinero(String numCuentaOrigen, String numCuentaDestino, double monto) {
        CuentaBancaria cuentaOrigen = obtenerCuentaBancaria(numCuentaOrigen);
        CuentaBancaria cuentaDestino = obtenerCuentaBancaria(numCuentaDestino);
        if (cuentaOrigen != null && cuentaDestino != null) {
            cuentaOrigen.transferirDinero(cuentaDestino, monto);
        } else {
            System.out.println("Una o ambas cuentas bancarias no existen.");
        }
    }

    public double consultarSaldo(String numCuenta) {
        CuentaBancaria cuenta = obtenerCuentaBancaria(numCuenta);
        if (cuenta != null) {
            return cuenta.consultarSaldo();
        } else {
            System.out.println("La cuenta bancaria no existe.");
            return 0;
        }
    }

}

