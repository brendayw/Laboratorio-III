package ar.utn.frbb.tup.model;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    private List<Cliente> clientes = new ArrayList<>();
    private List<CuentaBancaria> cuentasBancarias = new ArrayList<>();
    private List<MovimientosCuenta> movimientos = new ArrayList<>();

    //clientes:
    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    //cuentas bancarias;
    public List<CuentaBancaria> getCuentasBancarias() {
        return cuentasBancarias;
    }
    public void setCuentaBancaria(List<CuentaBancaria> cuentasBancarias) {
        this.cuentasBancarias = cuentasBancarias;
    }

    //movimientos:
    public List<MovimientosCuenta> getMovimientosCuenta() {
        return movimientos;
    }
    public void setMovimientosCuenta(List<MovimientosCuenta> movimientos) {
        this.movimientos = movimientos;
    }

}

