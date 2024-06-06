package ar.utn.frbb.tup.persistance.dao;

import java.util.HashMap;
import java.util.Map;

public abstract class BaseAbstractaDAO {
    protected static Map<String, Map<Long, Object>> BaseDeDatitos = new HashMap<>();
    protected abstract String getNombreEntidad();

    protected Map<Long, Object> getBaseDeDatosEnMemoria() {
        if (BaseDeDatitos.get(getNombreEntidad()) == null) {
            BaseDeDatitos.put(getNombreEntidad(), new HashMap<>());
        }
        return BaseDeDatitos.get(getNombreEntidad());
    }
}
