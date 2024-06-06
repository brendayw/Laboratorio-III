package ar.utn.frbb.tup.model.excepetions;

public class ClienteYaExisteExcepcion extends Throwable{
    public ClienteYaExisteExcepcion(String mensaje) {
        super(mensaje);
    }
}
