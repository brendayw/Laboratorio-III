package ar.utn.frbb.tup;

public class App 
{
    public static void main( String[] args )
    {
        Banco banco = new Banco();

        MenuApp menu = new MenuApp();
        menu.runMenu(banco);
    }
}


