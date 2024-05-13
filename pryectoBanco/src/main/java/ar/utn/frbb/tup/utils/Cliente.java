package ar.utn.frbb.tup.utils;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private long id;
    private String nombre;
    private String apellido;
    private String telefono;
    private String direccion;
    private TipoPersona tipoPersona;

    private static List<Cliente> clientes = new ArrayList<>();

    //constructores
    public Cliente(long id, String nombre, String apellido, String telefono, String direccion, TipoPersona tipoPersona) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.direccion = direccion;
        this.tipoPersona = tipoPersona;
    }
    public Cliente() {
        this.id = 0;
        this.nombre = null;
        this.apellido = null;
        this.telefono = null;
        this.direccion = null;
        this.tipoPersona = null;
    }

    //metodos
    public static Cliente crearCliente(long id, String nombre, String apellido, String telefono, String direccion, TipoPersona tipoPersona) {
       Cliente cliente = new Cliente(id, nombre, apellido, telefono, direccion, tipoPersona);
       System.out.println("Cliente creado exitosamente.");
       return cliente;
    
    }

    public void modificarCliente(String nuevoNombre, String nuevoApellido, String nuevoTelefono, String nuevadireccion) {
        this.nombre = nuevoNombre;
        this.apellido = nuevoApellido;
        this.telefono = nuevoTelefono;
        this.direccion = nuevadireccion;
        System.out.println("Cliente modificado exitosamente.");
    }

    public void eliminarCliente() {
        this.id = 0;
        this.nombre = null;
        this.apellido = null;
        this.telefono = null;
        this.direccion = null;
        System.out.println("Cliente eliminado exitosamente.");
    }


    //getters y setters
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public TipoPersona getTipoPersona() {
        return tipoPersona;
    }
    public void setTipoPersona(TipoPersona tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    public static Cliente getCliente(long id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        System.out.println("Cliente no existe.");
        return null;
    }
    public void setCliente(Cliente cliente) {
        clientes.add(this);
        System.out.println("Cliente agregado exitosamente.");
    }

}