package Exceptions;

import edu.maen.core.exceptions.CityException;

/*
* Nome: <Samuel Luciano Correia da Cunha>
* Número: <8160526>
*/
public class ExceptionCity extends CityException {
    
    /**
     * Creates a new instance of CityException without detail message
     */
    public ExceptionCity() { 
    }
    
    /**
     * Constructs a new instance of CityException with the specified detal message
     * @param msg 
     */
    public ExceptionCity(String msg) {
        super(msg);
    }   
}