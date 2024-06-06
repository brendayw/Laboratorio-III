package ar.utn.frbb.tup.persistance.dao;

import ar.utn.frbb.tup.model.Cliente;

public interface ClienteDAO {
   Cliente buscar(long id);

   void guardar(Cliente cliente);

}
