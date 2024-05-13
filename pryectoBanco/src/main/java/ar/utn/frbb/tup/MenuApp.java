package ar.utn.frbb.tup;

import java.util.Scanner;
import ar.utn.frbb.tup.utils.Cliente;
import ar.utn.frbb.tup.utils.CuentaBancaria;

public class MenuApp {
    ClienteIngreso clienteIngreso = new ClienteIngreso();
    CuentaBancaria cuentaBancaria = new CuentaBancaria();

    boolean salir = false;

    public void runMenu(Banco banco) {
        Scanner scanner = new Scanner(System.in);

        while (!salir) {
            System.out.println("Bienveido a la aplicación de Banco!");
            System.out.println("1. Crear un nuevo Cliente");
            System.out.println("2. Crear una nueva Cuenta");
            System.out.println("3. Generar un movimiento");
            System.out.println("4. Salir");
            System.out.print("Ingrese su opción (1-4): ");

            int opcion = scanner.nextInt();
                        
            switch (opcion) {
                case 1:
                    Cliente c = clienteIngreso.ingresarCliente();
                    banco.getClientes().add(c);
                    break;
                case 2:
                    CuentaBancaria cuenta = clienteIngreso.crearCuenta();
                    banco.getCuentasBancarias().add(cuenta);
                    break;
                case 3:
                    MovimientosIngreso movimientosIngreso = new MovimientosIngreso();
                    MovimientosCuenta mov = movimientosIngreso.hacerTransaccion();
                    banco.getMovimientosCuenta().add(mov);
                    break;
                case 4:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida. Por favor seleccione 1-4.");
            }
            
        }
        scanner.close();
    }

}
