package ar.utn.frbb.tup.model.excepetions;

public class TipoCuentaYaExiste extends Throwable {
    public TipoCuentaYaExiste(String mensaje) {
        super(mensaje);
    }
}
