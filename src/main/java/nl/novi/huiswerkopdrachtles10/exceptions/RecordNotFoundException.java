package nl.novi.huiswerkopdrachtles10.exceptions;

public class RecordNotFoundException extends RuntimeException {

    // De exception zonder message
    public RecordNotFoundException() {

        super();

    }

    // De exception met message
    public RecordNotFoundException(String message) {

        super(message);

    }

}