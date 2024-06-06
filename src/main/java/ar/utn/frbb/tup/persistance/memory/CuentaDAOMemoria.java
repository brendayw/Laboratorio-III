package ar.utn.frbb.tup.persistance.memory;

import java.util.HashMap;
import java.util.Map;

import ar.utn.frbb.tup.model.CuentaBancaria;
import ar.utn.frbb.tup.persistance.dao.CuentaBancariaDAO;

public class CuentaDAOMemoria implements CuentaBancariaDAO {
    private Map<Long, CuentaBancaria> baseDeDatosEnMemoria = new HashMap<>();

    @Override
    public CuentaBancaria buscarCuentaPorNumero(String numCuentaUnico) {
        return baseDeDatosEnMemoria.get(numCuentaUnico);
    }

    @Override
    public void guardarCuenta(CuentaBancaria cuenta) {
        baseDeDatosEnMemoria.put(cuenta.getNumCuentaUnico(), cuenta);
    }

}
