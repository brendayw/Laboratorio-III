package ar.utn.frbb.tup.service;

import java.util.Random;

public class AliasGenerador {
    private static final String[] Palabras = {"sol", "luna", "agua", "tierra", "fuego", "aire", "luz", "oscuro", "claro", "pelo", "rulo", "estrella", "cometa", "color", "fondo", "papel", "bufanda", "frio", "calor"};

    public static String generarAlias() {
        Random random = new Random();
        StringBuilder alias = new StringBuilder();

        for (int i = 0; i <3; i++) {
            int indicePalabra = random.nextInt(Palabras.length);
            alias.append(Palabras[indicePalabra]);

            if (i <2) {
                alias.append(" ");
            }
        }

        return alias.toString();
    }

    //agregar en el main para que se genere
}
