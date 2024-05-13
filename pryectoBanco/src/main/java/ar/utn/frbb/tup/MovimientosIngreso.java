package ar.utn.frbb.tup;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ar.utn.frbb.tup.utils.Cliente;
import ar.utn.frbb.tup.utils.CuentaBancaria;
import ar.utn.frbb.tup.utils.MovimientosCuenta;
import ar.utn.frbb.tup.utils.TipoOperacion;

public class MovimientosIngreso extends BaseIngresos {
    Scanner scanner = new Scanner(System.in);

    private static List<MovimientosCuenta> movimientos = new ArrayList<>();

    public MovimientosCuenta hacerTransaccion() {
        
        MovimientosCuenta movimiento = new MovimientosCuenta();
        
        System.out.println("Ingrese el Id del cliente: ");
        long id = scanner.nextLong();
        Cliente.getCliente(id);

        scanner.nextLine(); // Consumir el salto de línea

        System.out.println("Ingrese el numero de cuenta del cliente: ");
        String numCuentaUnico = scanner.nextLine();
        CuentaBancaria cuenta = CuentaBancaria.getCuentaBancaria(numCuentaUnico);

        System.out.println("Ingrese el tipo de operacion a realizar: ");
        String tipoOperacionStr = scanner.nextLine().toUpperCase();
        while (!tipoOperacionStr.equals("TRANSFERENCIA") && !tipoOperacionStr.equals("DEPOSITO") && !tipoOperacionStr.equals("RETIRO") && !tipoOperacionStr.equals("PAGO")) {
            System.out.println("Tipo de operacion invalida. Ingrese un tipo valido: ");
            tipoOperacionStr = scanner.nextLine().toUpperCase();
        }
        TipoOperacion tipoOperacion = TipoOperacion.fromString(tipoOperacionStr);
        movimiento.setTipoOperacion(tipoOperacion);

        System.out.println("Ingrese el monto a " + tipoOperacion);
        double monto = scanner.nextDouble();
        if (tipoOperacion.equals(TipoOperacion.DEPOSITO)) {
            cuenta.depositarDinero(monto);
        } else if (tipoOperacion.equals(TipoOperacion.TRANSFERENCIA)) {
            // Aquí necesitarás el número de cuenta destino, si es el caso
            CuentaBancaria cuentaDestino = obtenerCuentaDestino(); // Implementa esta función según tus necesidades
            cuenta.transferirDinero(cuentaDestino, monto);
        } else if (tipoOperacion.equals(TipoOperacion.RETIRO)) {
            cuenta.retirarDinero(monto);
        } else {
            System.out.println("No se pudo realizar la operacion");
        }

        movimientos.add(movimiento);

        
        return movimiento;
    }

    // Método para obtener la cuenta de destino en caso de una transferencia
    private CuentaBancaria obtenerCuentaDestino() {
        System.out.println("Ingrese el número de cuenta destino: ");
        String numCuentaDestino = scanner.nextLine();
        return CuentaBancaria.getCuentaBancaria(numCuentaDestino);
    }

}
