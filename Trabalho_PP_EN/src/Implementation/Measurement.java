package Implementation;

import edu.maen.core.interfaces.IContainer;
import edu.maen.core.interfaces.IMeasurement;
import edu.maen.core.interfaces.IRecyclingBin;
import java.time.LocalDateTime;
import java.util.Objects;

/*
* Nome: <Samuel Luciano Correia da Cunha>
* Número: <8160526>
*/
public class Measurement implements IMeasurement {
    
    /**
     * The measurement id
     */
    private int id;
    
    /**
     * The container being measured
     */
    private IContainer container;
    
    private Container[] containers;
    
    /**
     * The recycling bin being measured
     */
    private IRecyclingBin recyclingBin;
    
    /**
     * The measurement date
     */
    private LocalDateTime date;

    /**
     * The measurement value (in KG)
     */
    private double value;    

    /**
     * Constructor of Measurement
     * @param id the measurement id
     * @param container the container being measured
     * @param recyclingBin the recycling bin being measured
     * @param date the measurement date
     * @param value the measurement value
     */
    public Measurement(int id, IContainer container, IRecyclingBin recyclingBin, LocalDateTime date, double value) {
        this.id = id;
        this.container = container;
        this.recyclingBin = recyclingBin;
        this.date = date;
        this.value = value;
        this.containers = new Container[10];
    }
    
    /**
     * Getter for id 
     * @return the measurement id (in a auto-increment way)
     */
    @Override
    public int getId() {
        return this.id++;
    }

    /**
     * Setter for id
     * @param id the measurement id
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * Getter for container
     * @return the measurement container
     */
    @Override
    public IContainer getContainer() {
        return this.container;
    }
    
    public Container[] getContainers() {
        return this.containers;
    }
    
    /**
     * Setter for container
     * @param container the container being measured
     */
    public void setContainer(IContainer container) {
        this.container = container;
    }

    /**
     * Getter for recycling bin
     * @return the recycling bin being measured
     */
    @Override
    public IRecyclingBin getRecyclingBin() {
        return this.recyclingBin;
    }
    
    /**
     * Setter for recycling bin
     * @param recyclingBin the recycling bin being measured
     */
    public void setRecyclingBin(IRecyclingBin recyclingBin) {
        this.recyclingBin = recyclingBin;
    }

    /**
     * Getter for measurement date
     * @return the measurement date
     */
    @Override
    public LocalDateTime getDate() {
        return this.date;
    }
    
    /**
     * Setter for measurement date
     * @param date the measurement date
     */
    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    /**
     * Getter for measurement value (in KG)
     * @return the measurement value (in KG)
     */
    @Override
    public double getValue() {
        return this.value;
    }
    
    /**
     * Setter for measurement value (in KG)
     * @param value the measurement value (in KG)
     */
    public void setValue(double value) {
        this.value = value;
    }
    
    /**
     * To String method representing the Measurement.
     * @return String with all the information about the measurement.
     */
    @Override
    public String toString() {
        return "ID: " + this.id + "\nCONTAINER: " + this.container + 
                "\nRECYCLING BIN: " + this.recyclingBin + "\nDATE: " + this.date + 
                "\nVALUE: " + this.value; 
    }

    /**
     * Compares two Measurements.
     *
     * @param measurement measurement to be compared
     * @return true if measurement is equal to the measurement id.
     */
    @Override
    public boolean equals(Object measurement) {
        if (this == measurement) {
            return true;
        }
        if (measurement == null) {
            return false;
        }
        if (getClass() != measurement.getClass()) {
            return false;
        }
        final Measurement other = (Measurement) measurement;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}