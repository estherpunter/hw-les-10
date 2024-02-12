package nl.novi.huiswerkopdrachtles10.exceptions;

public class TelevisionNameTooLongException extends RuntimeException{
    public TelevisionNameTooLongException (String message){
        super(message);
    }

    public TelevisionNameTooLongException(){
        super();
    }
}

