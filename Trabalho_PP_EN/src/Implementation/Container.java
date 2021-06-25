package Implementation;

import edu.maen.core.enumerations.WasteType;
import edu.maen.core.interfaces.IContainer;
import java.util.Objects;

/*
* Nome: <Samuel Luciano Correia da Cunha>
* Número: <8160526>
*/
public class Container implements IContainer {
    
    /**
     * The container code (The first character identifies the container type)
     */
    private String code;
    
    /**
     * The container capacity (in KG)
     */
    private double capacity;
    
    /**
     * The waste type that container supports
     */
    private WasteType type;

    /**
     * Constructor of Container
     * @param code the container code
     * @param capacity the container capacity
     * @param type the container waste type 
     */
    public Container(String code, double capacity, WasteType type) {
        this.code = code;
        this.capacity = capacity;
        this.type = type;
    }
    
    /**
     * Getter for container code
     * @return the container code
     */
    @Override
    public String getCode() {
        return this.code;
    }

    /**
     * Setter for container code
     * @param code the container code
     */
    public void setCode(String code) {
        this.code = code;
    }
    
    /**
     * Getter for container capacity (in KG)
     * @return the container capacity
     */
    @Override
    public double getCapacity() {
        return this.capacity;
    }
    
    /**
     * Setter for container capacity (in KG)
     * @param capacity the container capacity
     */
    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }
    
    /**
     * Getter for the waste type that container supports
     * @return the waste type associated with the container
     */
    @Override
    public WasteType getType() {
        return this.type;
    }
    
    /**
     * Setter for the waste type that container supports
     * @param type the waste type
     */
    public void setType(WasteType type) {
        this.type = type;
    }
    
    /**
     * To String method representing the Container.
     * @return String with all the information about the container.
     */
    @Override
    public String toString() {
        return "CODE: " + this.code + "\nCAPACITY: " + this.capacity + 
                "\nCONTAINER WASTE TYPE: " + this.type; 
    }
    
    /**
     * Compares two Containers.
     *
     * @param container container to be compared
     * @return true if container is equal to the container code.
     */
    @Override
    public boolean equals(Object container) {
        if (this == container) {
            return true;
        }
        if (container == null) {
            return false;
        }
        if (getClass() != container.getClass()) {
            return false;
        }
        final Container other = (Container) container;
        if (!Objects.equals(this.code, other.code)) {
            return false;
        }
        return true;
    }
}