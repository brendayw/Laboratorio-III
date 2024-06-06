package ar.utn.frbb.tup.model.enums;

public enum TipoCuenta {
    CUENTACORRIENTE("CC"),
    CUENTAAHORROPESOS("CAP"),
    CUENTAAHORRODOLARES("CAD");

    private String tipo2;

    private TipoCuenta(String tipo2) {
        this.tipo2 = tipo2;
    }

    public static TipoCuenta fromString(String tipoStr) {
        for (TipoCuenta tipo2 : TipoCuenta.values()) {
            if (tipo2.tipo2.equals(tipoStr)) {
                return tipo2;
            }
        }
        throw new IllegalArgumentException("Tipo de cuenta no válido: " + tipoStr);
    }
}

