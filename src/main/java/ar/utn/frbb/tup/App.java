package ar.utn.frbb.tup;

import ar.utn.frbb.tup.model.Banco;
import ar.utn.frbb.tup.presentation.inputs.MenuApp;

public class App 
{
    public static void main( String[] args )
    {
        Banco banco = new Banco();

        MenuApp menu = new MenuApp();
        menu.runMenu(banco);
    }
}


