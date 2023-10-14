package tn.tuniprob.gestionmagasin.Exceptions;

public class PrixNegatifException extends Exception{
    public PrixNegatifException(String msg){
        super(msg);
    }
}
