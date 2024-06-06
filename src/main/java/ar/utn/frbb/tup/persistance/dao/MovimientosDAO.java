package ar.utn.frbb.tup.persistance.dao;

import ar.utn.frbb.tup.model.MovimientosCuenta;


public class MovimientosDAO extends BaseAbstractaDAO {
    @Override
    protected String getNombreEntidad() {
        return "Movimientos";
    }

    public void guardarMovimiento(MovimientosCuenta movimiento) {
        MovimientosEntidad entidad = new MovimientosEntidad(movimiento);
        getBaseDeDatosEnMemoria().put(entidad.getId(), entidad);
    }
}
