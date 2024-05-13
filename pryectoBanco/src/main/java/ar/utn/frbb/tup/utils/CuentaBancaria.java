package ar.utn.frbb.tup.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CuentaBancaria {
    private String numCuentaUnico;
    private TipoCuenta tipoCuenta;
    private double saldo;
    private String banco;
    private LocalDate fechaAlta;
    private TipoOperacion tipoOperacion;
    private List<Cliente> clientes;
    private List<MovimientosCuenta> movimientos;

    private static List<CuentaBancaria> cuentasBancarias = new ArrayList<>();

    public CuentaBancaria(String numCuentaUnico, TipoCuenta tipoCuenta, double saldo, String banco, LocalDate fechaAlta) {
        this.numCuentaUnico = numCuentaUnico;
        this.tipoCuenta = tipoCuenta;
        this.saldo = saldo;
        this.banco = banco;
        this.fechaAlta = fechaAlta;
        this.clientes = new ArrayList<>();
        this.movimientos = new ArrayList<>();
    }

    public CuentaBancaria() {
        this.numCuentaUnico = null;
        this.tipoCuenta = null;
        this.saldo = 0;
        this.banco = null;
        this.fechaAlta = null;
        this.clientes = new ArrayList<>();
        this.movimientos = new ArrayList<>();
    }

    //metodos
    public static CuentaBancaria crearCuentaBancaria(String numCuentaUnico, TipoCuenta tipoCuenta, double saldo, String banco, LocalDate fechaAlta) {
        CuentaBancaria cuentaBancaria = new CuentaBancaria(numCuentaUnico, tipoCuenta, saldo, banco, fechaAlta);
        System.out.println("Cuenta bancaria creada exitosamente.");
        return cuentaBancaria;
    }

    public void asociarCliente(Cliente cliente) { //asocia la cuenta del cliente creada a la cuenta bancaria
        this.clientes.add(cliente);
    }

    public void depositarDinero(double monto) { //deposita dinero en la cuenta bancaria
        this.saldo += monto;
        System.out.println("Dinero depositado exitosamente.");
        registrarMovimiento(TipoOperacion.DEPOSITO, monto);
    }

    public void retirarDinero(double monto) { //retira dinero 
    
        if (this.saldo < 0) {
            System.out.println("No se puede retirar dinero, saldo negativo.");
        } else if (this.saldo == 0) {
            System.out.println("No se puede retirar dinero, saldo cero.");
        } else if (monto < this.saldo) {
            this.saldo -= monto;
            System.out.println("Dinero retirado exitosamente.");
            registrarMovimiento(TipoOperacion.RETIRO, monto);
        }
        
    }

    public void transferirDinero(CuentaBancaria cuentaDestino, double monto) { //transfiere dinero a otra cuenta bancaria
        if (this.saldo >= monto) {
            this.saldo -= monto;
            cuentaDestino.depositarDinero(monto);
            System.out.println("Dinero transferido exitosamente.");
            registrarMovimiento(TipoOperacion.TRANSFERENCIA, monto);
        } else {
            System.out.println("No se puede transferir dinero, saldo insuficiente.");
        }
    }

    public double consultarSaldo() { //consulta saldo
        return saldo;
    }

    public void registrarMovimiento(TipoOperacion tipoOperacion, double monto) {
        MovimientosCuenta movimiento = new MovimientosCuenta(LocalDateTime.now(), tipoOperacion, monto);
        movimientos.add(movimiento);
    }

    //getters y setters
    public String getNumCuentaUnico() {
        return numCuentaUnico;
    }
    public void setNumCuentaUnico(String numCuentaUnico) {
        this.numCuentaUnico = numCuentaUnico;
    }

    public TipoCuenta getTipoCuenta() {
        return tipoCuenta;
    }
    public void setTipoCuenta(TipoCuenta tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getBanco() {
        return banco;
    }
    public void setBanco(String banco) {
        this.banco = banco;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }
    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public TipoOperacion getTipoOperacion() {
        return tipoOperacion;
    }
    public void setTipoOperacion(TipoOperacion tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }
    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public void setCliente(Cliente cliente) {
       //para crear cuenta
        this.clientes.add(cliente);
    }

    public List<MovimientosCuenta> getMovimientos() {
        return movimientos;
    }
    public void setMovimientos(List<MovimientosCuenta> movimientos) {
        this.movimientos = movimientos;
    }

    public static CuentaBancaria getCuentaBancaria(String numCuentaUnico) {
        for (CuentaBancaria cuentaBancaria : cuentasBancarias) {
            if (cuentaBancaria.getNumCuentaUnico() == numCuentaUnico) {
                return cuentaBancaria;
            }
        }
        System.out.println("Cuenta bancaria no existe.");
        return null;
    }

    public void setCuentaBancaria(CuentaBancaria cuentaBancaria) {
        CuentaBancaria.cuentasBancarias.add(cuentaBancaria);
        System.out.println("Cuenta bancaria creada exitosamente.");
    }

}

