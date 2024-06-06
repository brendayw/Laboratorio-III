package ar.utn.frbb.tup.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ar.utn.frbb.tup.model.enums.TipoCuenta;
import ar.utn.frbb.tup.service.AliasGenerador;
import ar.utn.frbb.tup.service.NumCuentaGenerador;
import ar.utn.frbb.tup.service.CvuGenerador;
import ar.utn.frbb.tup.model.enums.TipoMoneda;

//para cuentas bancarias individuales
public class CuentaBancaria {
    private String numCuentaUnico; //num de cuenta aleatorio
    private String cvu; //cvu aleatorio
    private String alias; //alias aleatorio
    public TipoCuenta tipoCuenta;
    public TipoMoneda tipoMoneda;
    public Cliente titular; //cliente titular
    private double saldo;   
    private String banco;
    private LocalDate fechaAlta;
    private List<MovimientosCuenta> movimientos;

    //constructor
    public CuentaBancaria(String numCuentaUnico, String cvu, String alias, TipoCuenta tipoCuenta, TipoMoneda tipoMoneda, double saldo, String banco, LocalDate fechaAlta) {
        this.numCuentaUnico = NumCuentaGenerador.generarNumCuenta();
        this.cvu = CvuGenerador.generarCvu();
        this.alias = AliasGenerador.generarAlias();
        this.tipoCuenta = tipoCuenta;
        this.tipoMoneda = tipoMoneda;
        this.saldo = 0;
        this.banco = banco;
        this.fechaAlta = fechaAlta;
        this.movimientos = new ArrayList<>();
    }

    //getters y setters
    public Cliente getTitular() { return titular; }
    public void setTitular(Cliente titular) { this.titular = titular; }

    public String getNumCuentaUnico() {  return numCuentaUnico; }
    public void setNumCuentaUnico(String numCuentaUnico) {  this.numCuentaUnico = numCuentaUnico;    }

    public String getCvu() {  return cvu;    }
    public void setCvu(String cvu) {  this.cvu = cvu;    }

    public String getAlias() {  return alias;    }
    public void setAlias(String alias) {  this.alias = alias;    }
    
    public TipoCuenta getTipoCuenta() {   return tipoCuenta;    }
    public void setTipoCuenta(TipoCuenta tipoCuenta) {  this.tipoCuenta = tipoCuenta;    }

    public double getSaldo() {   return saldo;     }
    public void setSaldo(double saldo) { this.saldo = saldo;   }

    public String getBanco() {  return banco;    }
    public void setBanco(String banco) {  this.banco = banco;    }

    public LocalDate getFechaAlta() {   return fechaAlta;    }
    public void setFechaAlta(LocalDate fechaAlta) {  this.fechaAlta = fechaAlta; }

    public TipoMoneda getTipoMoneda() {   return tipoMoneda;    }   
    public void setTipoMoneda(TipoMoneda tipoMoneda) {  this.tipoMoneda = tipoMoneda;    }

    //metodos
    public void crearCuenta(Cliente titular, TipoCuenta tipoCuenta, TipoMoneda tipoMoneda, double saldo, String banco, LocalDate fechaAlta) {
        this.titular = titular;
        this.tipoCuenta = tipoCuenta;
        this.tipoMoneda = tipoMoneda;
    }

    public void depositarDinero(double monto) { //deposita dinero en la cuenta bancaria
        this.saldo += monto;
        System.out.println("Dinero depositado exitosamente.");
    }

    public boolean retirarDinero(double monto) { //retira dinero 
        if (saldo >= monto) {
            saldo -= monto;
            System.out.println("Dinero retirado exitosamente.");
            return true;
        } else {
            System.out.println("Saldo insuficiente en la cuenta " + numCuentaUnico);
            return false;
        }  
    }

    public void agregarMovimiento(MovimientosCuenta movimiento) {
        movimientos.add(movimiento);
    }

    public double consultarSaldo() { //consulta saldo
        return saldo;
    }   

}

