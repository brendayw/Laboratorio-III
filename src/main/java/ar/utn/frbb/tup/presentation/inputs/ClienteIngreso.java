package ar.utn.frbb.tup.presentation.inputs;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ar.utn.frbb.tup.model.Cliente;
import ar.utn.frbb.tup.model.enums.TipoPersona;

public class ClienteIngreso extends BaseIngresos{
    Scanner scanner = new Scanner(System.in);

    private static List<Cliente> clientes = new ArrayList<>();

    public Cliente ingresarCliente() {
        Cliente cliente = new Cliente();

        System.out.println("Ingrese el nombre del cliente: ");
        String nombre = scanner.nextLine();
        cliente.setNombre(nombre);

        System.out.println("Ingrese el apellido del cliente: ");
        String apellido = scanner.nextLine();
        cliente.setApellido(apellido);

        System.out.println("Ingrese el telefono del cliente: ");
        String telefono = scanner.nextLine();
        cliente.setTelefono(telefono);

        System.out.println("Ingrese la direccion del cliente: ");
        String direccion = scanner.nextLine();
        cliente.setDireccion(direccion);

        System.out.println("Ingrese el tipo de persona Física(F) o Jurídica(J):");
        String tipoPersonaStr = scanner.nextLine().toUpperCase();
        while (!tipoPersonaStr.equals("F") && !tipoPersonaStr.equals("J")) {
            System.out.println("Tipo de persona inválido. Ingrese NATURAL o JURIDICA:");
            tipoPersonaStr = scanner.nextLine().toUpperCase();
        }
        TipoPersona tipoPersona = TipoPersona.fromString(tipoPersonaStr);
        cliente.setTipoPersona(tipoPersona);

        System.out.println("Ingrese la fecha de alta: (YYYY-MM-DD)");
        LocalDate fechaAlta = null;
        boolean fechaValida = false;
        while (!fechaValida) {
            try {
                fechaAlta = LocalDate.parse(scanner.nextLine());
                fechaValida = true;
            } catch (Exception e) {
                System.out.println("Formato de fecha inválido. Ingrese la fecha en formato YYYY-MM-DD:");
            }
        }
        cliente.setFechaAlta(fechaAlta);

        //id es el dni de la persona
        System.out.println("Ingrese su numero de documento");
        Long id = scanner.nextLong();
        cliente.setId(id);
        System.out.println("El id del cliente es: " + id);

        cliente.crearCliente(id, nombre, apellido, telefono, direccion, tipoPersona);
        clientes.add(cliente);

        return cliente;
    }
    
}

