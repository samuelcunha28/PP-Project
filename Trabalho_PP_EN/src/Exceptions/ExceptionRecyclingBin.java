package Exceptions;

import edu.maen.core.exceptions.RecyclingBinException;

/*
* Nome: <Samuel Luciano Correia da Cunha>
* Número: <8160526>
*/
public class ExceptionRecyclingBin extends RecyclingBinException {
    
    /**
     * Creates a new instace of RecyclingBinException without detail message
     */
    public ExceptionRecyclingBin() {
    }
    
    /**
     * Constructs an instance of RecyclingBinException with the specified detail message
     * @param msg 
     */
    public ExceptionRecyclingBin(String msg) {
        super(msg);
    }
}