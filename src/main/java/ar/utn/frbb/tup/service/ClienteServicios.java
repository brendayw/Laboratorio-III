package ar.utn.frbb.tup.service;

import ar.utn.frbb.tup.model.Cliente;
import ar.utn.frbb.tup.model.excepetions.ClienteYaExisteExcepcion;
import ar.utn.frbb.tup.model.excepetions.TipoCuentaYaExiste;
import ar.utn.frbb.tup.persistance.dao.ClienteDAO;

public class ClienteServicios {
    private ClienteDAO clienteDAO;

    public ClienteService(ClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }

    public Cliente buscarCliente(long id) {
        return clienteDAO.buscar(id);
    }

    public void guardarCliente(Cliente cliente) throws ClienteYaExisteExcepcion, TipoCuentaYaExiste {
        clienteDAO.guardar(cliente);
    }
}
