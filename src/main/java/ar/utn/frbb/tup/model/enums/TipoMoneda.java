package ar.utn.frbb.tup.model.enums;
public enum TipoMoneda {
    PESOS("PESOS"),
    DOLARES("DOLARES");

    private String tipo2;

    private TipoMoneda(String tipo2) {
        this.tipo2 = tipo2;
    }

    public static TipoMoneda fromString(String tipoStr) {
        for (TipoMoneda tipo2 : TipoMoneda.values()) {
            if (tipo2.tipo2.equals(tipoStr)) {
                return tipo2;
            }
        }
        throw new IllegalArgumentException("Tipo de moneda no válido: " + tipoStr);
    }
}
