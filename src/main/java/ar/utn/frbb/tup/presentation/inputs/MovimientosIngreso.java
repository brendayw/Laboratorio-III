package ar.utn.frbb.tup.presentation.inputs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ar.utn.frbb.tup.model.Cliente;
import ar.utn.frbb.tup.model.CuentaBancaria;
import ar.utn.frbb.tup.model.MovimientosCuenta;
import ar.utn.frbb.tup.model.OperacionesBancarias;
import ar.utn.frbb.tup.model.enums.TipoOperacion;

public class MovimientosIngreso extends BaseIngresos {
    Scanner scanner = new Scanner(System.in);

    private static List<Cliente> clientes = new ArrayList<>();
    private static List<CuentaBancaria> cuentas = new ArrayList<>();
    private static List<MovimientosCuenta> movimientos = new ArrayList<>();

    //busca al cliente por el numero de dni
    private Cliente buscarClientePorID(long id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        return null;
    }
    //busca por el num de cuenta random generado
    private CuentaBancaria buscarCuentaPorNumero(String numCuentaUnico) {
        for (CuentaBancaria cuenta : cuentas) {
            if (cuenta.getNumCuentaUnico().equals(numCuentaUnico)) {
                return cuenta;
            }
        }
        return null;
    }

    public MovimientosCuenta hacerTransaccion() {
        //ingresa el id de cliente
        System.out.println("Ingrese el DNI del cliente: ");
        long id = scanner.nextLong();
        scanner.nextLine(); // Consumir el salto de línea
        
        //busca al cliente por su id
        Cliente cliente = buscarClientePorID(id);
        if (cliente == null) {
            System.out.println("El cliente con DNI: " + id + " no existe.");
            return null;
        }
        //ingresa el numero de cuenta del cliente
        System.out.println("Ingrese el numero de cuenta del cliente: ");
        String numCuentaUnico = scanner.nextLine();
        //busca la cuenta por su numero
        CuentaBancaria cuenta = buscarCuentaPorNumero(numCuentaUnico);
        if (cuenta == null) {
            System.out.println("La cuenta con numero: " + numCuentaUnico + " no existe.");
            return null;
        }

        //ingresa el tipo de operacion a realizar
        System.out.println("Ingrese el tipo de operacion a realizar: ");
        String tipoOperacionString = scanner.nextLine().toUpperCase();
        
        //valida el tipo de operacion a realizar
        while (!tipoOperacionString.equals("TRANSFERENCIA") && !tipoOperacionString.equals("DEPOSITO") && !tipoOperacionString.equals("RETIRO") && !tipoOperacionString.equals("PAGO")) {
            System.out.println("Tipo de operacion invalida. Ingrese un tipo valido: ");
            tipoOperacionString = scanner.nextLine().toUpperCase();
        }
        TipoOperacion tipoOperacion = TipoOperacion.fromString(tipoOperacionString);
        
        //ingresa el monto 
        System.out.println("Ingrese el monto a " + tipoOperacion);
        double monto = scanner.nextDouble();
        boolean operacionExitosa = false;

        OperacionesBancarias operacionesBancarias = new OperacionesBancarias();
        switch (tipoOperacion) {
            case RETIRO:
                operacionExitosa = operacionesBancarias.retirarDinero(numCuentaUnico, monto);
                break;
            case TRANSFERENCIA:
            System.out.println("Ingrese el numero de cuenta destino: ");
            String numCuentaDestino = scanner.nextLine();
            if (operacionesBancarias.obtenerCuentaBancaria(numCuentaDestino) != null) {
                operacionesBancarias.transferirDinero(numCuentaUnico, numCuentaDestino, monto);
                operacionExitosa = true;
            } else {
                System.out.println("La cuenta destino no existe.");
            }
            break;
        case DEPOSITO:
            operacionesBancarias.depositarDinero(numCuentaUnico, monto);
            operacionExitosa = true;
            break;
        default:
            System.out.println("No se pudo realizar la operacion");       
        }

        if (!operacionExitosa) {
            System.out.println("La operación no fue exitosa.");
            return null;
        }

        MovimientosCuenta movimiento = new MovimientosCuenta(cliente, cuenta, tipoOperacion, monto);
        movimientos.add(movimiento);
        cuenta.agregarMovimiento(movimiento);

        return movimiento;
    }   

}
