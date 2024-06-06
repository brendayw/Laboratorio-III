package ar.utn.frbb.tup.presentation.inputs;

import java.util.Scanner;

public class BaseIngresos {
    protected Scanner scanner = new Scanner(System.in);

    protected static void ClearScreen() {
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }
}
