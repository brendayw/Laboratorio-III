package ar.utn.frbb.tup.model.excepetions;

public class DineroNoAlcanza extends Throwable {
    public DineroNoAlcanza(String mensaje) {
        super(mensaje);
    }
}
