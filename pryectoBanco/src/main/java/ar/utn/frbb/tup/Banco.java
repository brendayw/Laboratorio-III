package ar.utn.frbb.tup;

import java.util.ArrayList;
import java.util.List;

import ar.utn.frbb.tup.utils.Cliente;
import ar.utn.frbb.tup.utils.CuentaBancaria;

public class Banco {
    private List<Cliente> clientes = new ArrayList<>();
    private List<CuentaBancaria> cuentasBancarias = new ArrayList<>();
    private List<MovimientosCuenta> movimientos = new ArrayList<>();

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    
    public List<CuentaBancaria> getCuentasBancarias() {
        return cuentasBancarias;
    }
    public void setCuentaBancaria(List<CuentaBancaria> cuentasBancarias) {
        this.cuentasBancarias = cuentasBancarias;
    }

    public List<MovimientosCuenta> getMovimientosCuenta() {
        return movimientos;
    }
    public void setMovimientosCuenta(List<MovimientosCuenta> movimientos) {
        this.movimientos = movimientos;
    }

}

