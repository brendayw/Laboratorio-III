package ar.utn.frbb.tup.service;

import ar.utn.frbb.tup.persistance.dao.CuentaBancariaDAO;
import ar.utn.frbb.tup.model.CuentaBancaria;

public class CuentaBancariaService {
    private CuentaBancariaDAO cuentaBancariaDAO;

    public CuentaBancariaService(CuentaBancariaDAO cuentaBancariaDAO) {
        this.cuentaBancariaDAO = cuentaBancariaDAO;
    }

    public CuentaBancaria buscarCuentaPorNumero(long numCuentaUnico) {
        return cuentaBancariaDAO.buscarCuentaPorNumero(numCuentaUnico);
    }

    public void guardarCuenta(CuentaBancaria cuenta) {
        cuentaBancariaDAO.guardarCuenta(cuenta);
    }

}
