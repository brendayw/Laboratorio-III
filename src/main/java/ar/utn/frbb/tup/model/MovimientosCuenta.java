package ar.utn.frbb.tup.model;

import java.time.LocalDateTime;

import ar.utn.frbb.tup.model.enums.TipoOperacion;

//gestiona los movimientos de una cuenta bancaria
public class MovimientosCuenta {
    private Cliente cliente;
    private CuentaBancaria cuenta;
    private final LocalDateTime fechaHora;
    private final TipoOperacion tipoOperacion;
    private final double monto;

    //constructores
    public MovimientosCuenta(Cliente cliente, CuentaBancaria cuenta, TipoOperacion tipoOperacion, double monto) {
        this.cliente = cliente;
        this.cuenta = cuenta;
        this.tipoOperacion = tipoOperacion;
        this.monto = monto;
        this.fechaHora = LocalDateTime.now(); // Asignamos la fecha y hora actual
    }

    public MovimientosCuenta(Cliente cliente, CuentaBancaria cuenta, LocalDateTime fechaHora, TipoOperacion tipoOperacion, double monto) {
        this.cliente = cliente;
        this.cuenta = cuenta;
        this.fechaHora = fechaHora;
        this.tipoOperacion = tipoOperacion;
        this.monto = monto;
    }

    //metodos
    public void registrarMovimientoDeposito(LocalDateTime fechaHora, double monto) {
        System.out.println("Movimiento de depósito registrado exitosamente.");
        System.out.println("Fecha y hora: " + fechaHora);
        System.out.println("Monto: " + monto);
    }

    public void registrarTransferencia(LocalDateTime fechaHora, double monto) {
        System.out.println("Movimiento de transferencia registrado exitosamente.");
        System.out.println("Fecha y hora: " + fechaHora);
        System.out.println("Monto: " + monto);
    }

    public void registrarRetiro(LocalDateTime fechaHora, double monto) {
        System.out.println("Movimiento de retiro registrado exitosamente.");
        System.out.println("Fecha y hora: " + fechaHora);
        System.out.println("Monto: " + monto);
    }

    // getters y setters
    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    public CuentaBancaria getCuenta() { return cuenta; }
    public void setCuenta(CuentaBancaria cuenta) { this.cuenta = cuenta; }

    public LocalDateTime getFechaHora() { return fechaHora;  }
    
    public TipoOperacion getTipoOperacion() { return tipoOperacion; }

    public double getMonto() { return monto;  }
}
