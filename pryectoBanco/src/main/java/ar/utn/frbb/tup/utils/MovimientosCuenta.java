package ar.utn.frbb.tup.utils;

import java.time.LocalDateTime;

public class MovimientosCuenta {
    private LocalDateTime fechaHora;
    private TipoOperacion tipoOperacion;
    private double monto;

    public MovimientosCuenta(LocalDateTime fechaHora, TipoOperacion tipoOperacion, double monto) {
        this.fechaHora = fechaHora;
        this.tipoOperacion = tipoOperacion;
        this.monto = monto;
    }

    //getters y setters
    public LocalDateTime getFechaHora() {
        return fechaHora;
    }
    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public TipoOperacion getTipoOperacion() {
        return tipoOperacion;
    }
    public void setTipoOperacion(TipoOperacion tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    public double getMonto() {
        return monto;
    }
    public void setMonto(double monto) {
        this.monto = monto;
    }
    
}
