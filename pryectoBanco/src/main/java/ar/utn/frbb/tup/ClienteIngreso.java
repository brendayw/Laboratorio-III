package ar.utn.frbb.tup;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

import ar.utn.frbb.tup.utils.Cliente;
import ar.utn.frbb.tup.utils.TipoPersona;
import ar.utn.frbb.tup.utils.CuentaBancaria;
import ar.utn.frbb.tup.utils.TipoCuenta;
/* 
import utils.MovimientosCuenta;
import utils.TipoOperacion;*/

public class ClienteIngreso extends BaseIngresos{
    Scanner scanner = new Scanner(System.in);

    private static List<Cliente> clientes = new ArrayList<>();
    private static List<CuentaBancaria> cuentas = new ArrayList<>();

    public Cliente ingresarCliente() {  

        Cliente cliente = new Cliente();
        CuentaBancaria cuenta = new CuentaBancaria();
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

        System.out.println("Ingrese el banco del cliente:");
        String banco = scanner.nextLine();
        cuenta.setBanco(banco);

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
        cuenta.setFechaAlta(fechaAlta);

        //generar id
        Random random = new Random();
        int id = 10000 + random.nextInt(90000); // genera id de 5digitos
        cliente.setId(id);
        System.out.println("Id generado: " + id);
        
        Cliente.crearCliente(id, nombre, apellido, telefono, direccion, tipoPersona);
        clientes.add(cliente);

        return cliente;
    }

    public CuentaBancaria crearCuenta() {
        CuentaBancaria cuenta = new CuentaBancaria();
    
        System.out.println("Ingrese el ID del cliente: ");
        long id = scanner.nextLong();

        Cliente cliente = null;
        for (Cliente c : clientes) {
            if (c.getId() == id) {
                cliente = c;
                break;
            }
        }
        if (cliente == null) {
            System.out.println("Cliente no encontrado. Por favor, ingrese un ID válido.");
            return null;
        }
        cuenta.setCliente(cliente);
    
        System.out.println("Ingrese el tipo de cuenta a crear: \n" +
                    "CC = cuenta corriente \n" +
                    "CAP = cuenta ahorro en pesos \n" +
                    "CAD = cuenta ahorro en dólares");
        scanner.nextLine(); // Consumir el carácter de nueva línea pendiente
        String tipoCuentaStr = scanner.nextLine().toUpperCase();   
        TipoCuenta tipoCuenta = TipoCuenta.fromString(tipoCuentaStr);
        while (tipoCuenta == null) {
            System.out.println("Tipo de cuenta inválido.");
            System.out.println("Ingrese nuevamente el tipo de cuenta: ");
            tipoCuentaStr = scanner.nextLine().toUpperCase();
            tipoCuenta = TipoCuenta.fromString(tipoCuentaStr);
        }

        cuenta.setTipoCuenta(tipoCuenta);

        System.out.println("Ingrese el saldo inicial: ");
        double saldo = scanner.nextDouble();
        cuenta.setSaldo(saldo);
    
        System.out.println("Ingrese la fecha de alta: (YYYY-MM-DD)");
        LocalDate fechaAlta = null;
        boolean fechaValida = false;
        while (!fechaValida) {
            try {
                fechaAlta = LocalDate.parse(scanner.next());
                fechaValida = true;
            } catch (Exception e) {
                System.out.println("Formato de fecha inválido. Ingrese la fecha en formato YYYY-MM-DD:");
            }
        }
        cuenta.setFechaAlta(fechaAlta);

        System.out.println("Ingrese el banco del cliente:");
        String banco = scanner.next();
        cuenta.setBanco(banco);

        Random random = new Random(); //crea numero random de cuenta de 10 digitos
        StringBuilder numCuentaUnicoInt = new StringBuilder();//StringBuilder crea una cadena de caracteres de nums enteros
        for (int i = 0; i < 10; i++) {
            int digit = random.nextInt(10);
            numCuentaUnicoInt.append(digit);
        }
        //convertir a string
        String numCuentaUnico = numCuentaUnicoInt.toString();//convierte stringbuilder a una cadena de texto
        System.out.println("El número de cuenta es: " + numCuentaUnico);
        
        cuenta.setNumCuentaUnico(numCuentaUnico);
        
        CuentaBancaria.crearCuentaBancaria(numCuentaUnico, tipoCuenta, saldo, banco, fechaAlta);
        cuentas.add(cuenta);
    
        return cuenta;
    }
/*
    public static transaccionCliente() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el ID del cliente: ");
        long id = scanner.nextLong();
        Cliente.getCliente(id);

        System.out.println("Ingrese el número de cuenta: ");
        String numCuentaUnico = scanner.nextLine();

        return movimientos;
    }*/
    
}

