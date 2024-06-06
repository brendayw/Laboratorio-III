package ar.utn.frbb.tup.model.enums;

public enum TipoOperacion {
    DEPOSITO,
    RETIRO,
    TRANSFERENCIA,
    PAGO; 

    public static TipoOperacion fromString(String str) {
        try {
            return TipoOperacion.valueOf(str);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}

