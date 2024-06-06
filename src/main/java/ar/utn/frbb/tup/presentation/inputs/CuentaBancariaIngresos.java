package ar.utn.frbb.tup.presentation.inputs;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

import ar.utn.frbb.tup.model.CuentaBancaria;
import ar.utn.frbb.tup.model.Cliente;
import ar.utn.frbb.tup.model.enums.TipoCuenta;
import ar.utn.frbb.tup.model.enums.TipoMoneda;

public class CuentaBancariaIngresos extends BaseIngresos {
    Scanner scanner = new Scanner(System.in);

    private static List<Cliente> clientes = new ArrayList<>();
    private static List<CuentaBancaria> cuentas = new ArrayList<>();
    
    //busca si el cliente existe por el id (dni)
    private Cliente buscarClientePorID(long id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        return null;
    }

    public CuentaBancaria crearCuenta(TipoCuenta tipoCuenta, TipoMoneda tipoMoneda, LocalDate fechaAltaParam) {
    
        System.out.println("Ingrese el DNI del cliente: ");
        long id = scanner.nextLong();
        
        Cliente titular = buscarClientePorID(id);
        if (titular == null) {
            System.out.println("El cliente con ID: " + id + " no existe.");
            return null;
        }

        //ingresa el banco del cliente
        System.out.println("Ingrese el Banco del cliente:");
        String banco = scanner.nextLine();
        
        //ingresa el tipo de cuenta que desea crear
        System.out.println("Ingrese el tipo de cuenta a crear: \n" +
                    "CC = cuenta corriente \n" +
                    "CAP = cuenta ahorro en pesos \n" +
                    "CAD = cuenta ahorro en dólares");
        scanner.nextLine(); // Consumir el carácter de nueva línea pendiente
        String tipoCuentaStr = scanner.nextLine().toUpperCase();   
        while (tipoCuenta == null) {
            System.out.println("Tipo de cuenta inválido.");
            System.out.println("Ingrese nuevamente el tipo de cuenta: ");
            tipoCuentaStr = scanner.nextLine().toUpperCase();
            tipoCuenta = TipoCuenta.fromString(tipoCuentaStr);
        }

        if (tipoCuenta.equals(TipoCuenta.CUENTACORRIENTE) || tipoCuenta.equals(TipoCuenta.CUENTAAHORROPESOS)) {
            tipoMoneda = TipoMoneda.PESOS;
        } else if (tipoCuenta.equals(TipoCuenta.CUENTAAHORRODOLARES)) {
            tipoMoneda = TipoMoneda.DOLARES;
        }

        //ingresa el saldo inicial
        System.out.println("Ingrese el saldo inicial: ");
        double saldo = scanner.nextDouble();
        
        //fecha de alta del tipo de cuenta que crea
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

        //genera numero de cuenta unico
        Random random = new Random(); //crea numero random de cuenta de 10 digitos
        StringBuilder numCuentaUnicoInt = new StringBuilder();//StringBuilder crea una cadena de caracteres de nums enteros
        for (int i = 0; i < 10; i++) {
            int digit = random.nextInt(10);
            numCuentaUnicoInt.append(digit);
        }
        //convertir a string
        String numCuentaUnico = numCuentaUnicoInt.toString();//convierte stringbuilder a una cadena de texto
        System.out.println("El número de cuenta es: " + numCuentaUnico);

        //crea la cuenta bancaria
        CuentaBancaria cuenta = new CuentaBancaria(numCuentaUnico, "", "", tipoCuenta, tipoMoneda, saldo, banco, fechaAlta);
        cuentas.add(cuenta);
 
        //asignar la cuenta al cliente
        titular.agregarCuenta(cuenta);

        System.out.println("Cuenta creada exitosamente.");
        return cuenta;
    
    }

}