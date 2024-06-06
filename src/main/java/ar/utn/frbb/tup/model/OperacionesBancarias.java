package ar.utn.frbb.tup.model;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import ar.utn.frbb.tup.model.enums.TipoOperacion;

public class OperacionesBancarias {
    private Map<String, CuentaBancaria> cuentas;

    // Constructor
    public OperacionesBancarias() {
        this.cuentas = new HashMap<>();
    }

    //metodos
    //obtiene cuenta segun su numero de cuenta
    // para realizar deposito
    public CuentaBancaria obtenerCuentaBancaria(String numCuentaUnico) {
        return this.cuentas.get(numCuentaUnico);
    }

    private void registrarMovimiento(CuentaBancaria cuenta, TipoOperacion tipoOperacion, double monto) {
        LocalDateTime fechaHora = LocalDateTime.now(); // Obtenemos la fecha y hora actual
        MovimientosCuenta movimiento = new MovimientosCuenta(cuenta.getTitular(), cuenta, fechaHora, tipoOperacion, monto);
        cuenta.agregarMovimiento(movimiento);
    }

    public void depositarDinero(String numCuentaUnico, double monto) {
        CuentaBancaria cuenta = obtenerCuentaBancaria(numCuentaUnico);
        if (cuenta != null) {
            cuenta.depositarDinero(monto);
            registrarMovimiento(cuenta, TipoOperacion.DEPOSITO, monto);
        } else {
            System.out.println("La cuenta bancaria no existe.");
        }
    }

    public boolean retirarDinero(String numCuentaUnico, double monto) {
        CuentaBancaria cuenta = obtenerCuentaBancaria(numCuentaUnico);
        if (cuenta != null) {
            if (cuenta.retirarDinero(monto)) {
                registrarMovimiento(cuenta, TipoOperacion.RETIRO, monto);
                return true;
            } else {
                System.out.println("Saldo insuficiente o saldo negativo.");
            }
        } else {
            System.out.println("La cuenta bancaria no existe.");
        }
        return false;
    }

    public void transferirDinero(String numCuentaOrigen, String numCuentaDestino, double monto) {
        CuentaBancaria cuentaOrigen = obtenerCuentaBancaria(numCuentaOrigen);
        CuentaBancaria cuentaDestino = obtenerCuentaBancaria(numCuentaDestino);
        if (cuentaOrigen != null && cuentaDestino != null) {
            if (cuentaOrigen.retirarDinero(monto)) {
                cuentaDestino.depositarDinero(monto);
                registrarMovimiento(cuentaOrigen, TipoOperacion.TRANSFERENCIA, monto);
                registrarMovimiento(cuentaDestino, TipoOperacion.TRANSFERENCIA, monto);
                System.out.println("Dinero transferido exitosamente.");
            } else {
                System.out.println("Saldo insuficiente para la transferencia.");
            }
        } else {
            System.out.println("Una o ambas cuentas bancarias no existen.");
        }
    }

    public double consultarSaldo(String numCuentaUnica) {
        CuentaBancaria cuenta = obtenerCuentaBancaria(numCuentaUnica);
        if (cuenta != null) {
            return cuenta.consultarSaldo();
        } else {
            System.out.println("La cuenta bancaria no existe.");
            return 0;
        }
    }
}