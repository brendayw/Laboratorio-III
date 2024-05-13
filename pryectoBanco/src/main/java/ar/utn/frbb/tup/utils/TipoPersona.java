package ar.utn.frbb.tup.utils;

public enum TipoPersona {
    FISICA("F"),
    JURIDICA("J");

    private String tipo;

    private TipoPersona(String tipo) {
        this.tipo = tipo;
    }

    public static TipoPersona fromString(String tipoStr) {
        for (TipoPersona tipo : TipoPersona.values()) {
            if (tipo.tipo.equals(tipoStr)) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Tipo de persona no válido: " + tipoStr);
    }
}

