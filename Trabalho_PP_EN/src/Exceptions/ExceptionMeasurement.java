package Exceptions;

import edu.maen.core.exceptions.MeasurementException;

/*
* Nome: <Samuel Luciano Correia da Cunha>
* Número: <8160526>
*/
public class ExceptionMeasurement extends MeasurementException {
    
    /**
     * Creates a new instance of MeasurementException without detail message
     */
    public ExceptionMeasurement() {
    }
    
    /**
     * Constructs an instance of MeasurementException with the specified detail message
     * @param msg 
     */
    public ExceptionMeasurement(String msg) {
        super(msg);
    }
}