package Exceptions;

import edu.maen.core.exceptions.ContainerException;

/*
* Nome: <Samuel Luciano Correia da Cunha>
* Número: <8160526>
*/
public class ExceptionContainer extends ContainerException {
    
    /**
     * Creates a new instance of ContainerException without detail message
     */
    public ExceptionContainer() {
    }
    
    /**
     * Constructs an instance of ContainerException with the specified detail message
     * @param msg 
     */
    public ExceptionContainer(String msg) {
        super(msg);
    }
}