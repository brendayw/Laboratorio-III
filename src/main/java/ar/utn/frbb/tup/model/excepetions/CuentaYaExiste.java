package ar.utn.frbb.tup.model.excepetions;

public class CuentaYaExiste extends Throwable { 
    public CuentaYaExiste(String mensaje) {
        super(mensaje);
    }
}
