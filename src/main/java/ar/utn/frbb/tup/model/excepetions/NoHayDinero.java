package ar.utn.frbb.tup.model.excepetions; 

public class NoHayDinero extends Throwable{
    public NoHayDinero(String message){
        super(message);
    }
}
