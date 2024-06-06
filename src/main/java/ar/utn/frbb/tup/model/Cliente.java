package ar.utn.frbb.tup.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.time.LocalDate;

import ar.utn.frbb.tup.model.enums.TipoPersona;
import ar.utn.frbb.tup.model.enums.TipoCuenta;
import ar.utn.frbb.tup.model.enums.TipoMoneda;

public class Cliente extends Persona{
    private long id; //num de dni
    private TipoPersona tipoPersona;
    private String banco;
    private LocalDate fechaAlta;
    private Set<CuentaBancaria> cuentas = new HashSet<>();
    private List<Long> listaCuentas = new ArrayList<>();    

    //metodos
    public void crearCliente(long id, String nombre, String apellido, String telefono, String direccion, TipoPersona tipoPersona) {
        this.id = id;
        this.tipoPersona = tipoPersona;
        this.fechaAlta = LocalDate.now();
    }

    public void agregarCuenta(CuentaBancaria cuenta) {
        this.cuentas.add(cuenta);
        cuenta.setTitular(this);
    }

    public boolean tineCuenta(long id, TipoCuenta tipoCuenta, TipoMoneda tipoMoneda) {
        for (CuentaBancaria cuenta : this.cuentas) {
            if (tipoCuenta.equals(cuenta.getTipoCuenta()) && tipoMoneda.equals(cuenta.getTipoMoneda())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Cliente: " +
                "\n ID: " + id +
                "\n Tipo de Persona: " + tipoPersona +
                "\n Banco: " + banco +
                "\n Fecha de Alta: " + fechaAlta +
                "\n Cuentas: " + cuentas;
    }

    //getters y setters
    public List<Long> getListaCuentas() {  return listaCuentas;   }
    public void setListaCuentas(List<Long> listaCuentas) {  this.listaCuentas = listaCuentas; }

    public long getId() { return id;  }
    public void setId(long id) { this.id = id;  }

    public TipoPersona getTipoPersona() { return tipoPersona;  }
    public void setTipoPersona(TipoPersona tipoPersona) { this.tipoPersona = tipoPersona;  }

    public String getBanco() { return banco;  }
    public void setBanco(String banco) { this.banco = banco;  }

    public LocalDate getFechaAlta() { return fechaAlta;  }
    public void setFechaAlta(LocalDate fechaAlta) { this.fechaAlta = fechaAlta;  }

    public Set<CuentaBancaria> getCuentas() { return cuentas;  }
    public void setCuentas(Set<CuentaBancaria> cuentas) { this.cuentas = cuentas;  }

}