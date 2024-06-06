package ar.utn.frbb.tup.service;

import java.util.UUID;


public class NumCuentaGenerador {
    public static String generarNumCuenta() {
        UUID uuId = UUID.randomUUID();

        String numeroCuenta = uuId.toString().replace("-", "").substring(0,12);

        return numeroCuenta;
    }

}
