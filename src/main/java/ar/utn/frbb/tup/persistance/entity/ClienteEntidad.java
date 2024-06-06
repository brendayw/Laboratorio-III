package ar.utn.frbb.tup.persistance.entity;

/*
import ar.utn.frbb.tup.model.Cliente;
import ar.utn.frbb.tup.model.CuentaBancaria;
import ar.utn.frbb.tup.model.enums.TipoPersona;
import ar.utn.frbb.tup.persistance.entity.BaseEntidad;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ClienteEntidad extends BaseEntidad{
    private final String tipoDePersona;
    private final String Nombre;
    private final String Apellido;
    private final LocalDate fechaAlta;
    private final LocalDate fechaNacimiento;
    private List<Long> cuentas;

    public ClienteEntidad(Cliente cliente) {
        super(cliente.getDni());
        this.tipoDePersona = cliente.getTipoPersona() != null ? cliente.getTipoPersona().getDescripcion() : null;
        this.Nombre = cliente.getNombre();
        this.Apellido = cliente.getApellido();
        this.fechaAlta = cliente.getFechaAlta();
        this.fechaNacimiento = cliente.getFechaNacimiento();
        if (cliente.getCuentaBancaria() != null && !cliente.getCuentaBancaria().isEmpy()) {
            this.cuentas = new ArrayList<>();
            for (CuentaBancaria acc : cliente.getCuentas()) {
                cuentas.add(acc.getNumCuentaUnico());
            }
        }
    }

    public void agregarCuenta(CuentaBancaria cuenta) {
        if (cuentas == null) {
            cuentas = new ArrayList<>();
        }
        cuentas.add(cuenta.getNumCuentaUnico());
    }

    public Cliente toCliente() {
        Cliente cliente = new Cliente();
        cliente.setDni(this.getId());
        cliente.setNombre(this.nombre);
        cliente.setApellido(this.apellido);
        cliente.setTipoPersona(TipoPersona.fromString(this.tipoPersona));
        cliente.setFechaAlta(this.fechaAlta);
        cliente.setFechaNacimiento(this.fechaNacimiento);

        return cliente;
    }
}*/
