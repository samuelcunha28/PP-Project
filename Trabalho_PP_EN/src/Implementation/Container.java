package Implementation;

import edu.maen.core.enumerations.WasteType;
import edu.maen.core.interfaces.IContainer;

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

    public void setCode(String code) {
        this.code = code;
    }
    

    @Override
    public double getCapacity() {
        return this.capacity;
    }
    
    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    @Override
    public WasteType getType() {
        return this.type;
    }
    
    public void setType(WasteType type) {
        this.type = type;
    }
    
    // FALTA EQUALS e toString
    
}
