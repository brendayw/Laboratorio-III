package ar.utn.frbb.tup.persistance.dao;

import ar.utn.frbb.tup.model.CuentaBancaria;

public interface CuentaBancariaDAO {
    CuentaBancaria buscarCuentaPorNumero(String numeroCuenta);

    void guardarCuenta(CuentaBancaria cuenta);
    
}