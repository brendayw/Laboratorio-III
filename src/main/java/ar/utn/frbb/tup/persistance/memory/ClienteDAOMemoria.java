package ar.utn.frbb.tup.persistance.memory;

import java.util.Map;
import java.util.HashMap;

import ar.utn.frbb.tup.model.Cliente;
import ar.utn.frbb.tup.persistance.dao.ClienteDAO;

public class ClienteDAOMemoria implements ClienteDAO {
    private Map<Long, Cliente> baseDeDatosEnMemoria = new HashMap<>();

    @Override
    public Cliente buscar(long dni) {
        return baseDeDatosEnMemoria.get(dni);
    }

    @Override
    public void guardar(Cliente cliente) {
        baseDeDatosEnMemoria.put(cliente.getDni(), cliente);
    }
}