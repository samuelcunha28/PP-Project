package Implementation;

import Exceptions.ExceptionContainer;
import Exceptions.ExceptionRecyclingBin;
import edu.maen.core.enumerations.WasteType;
import edu.maen.core.exceptions.ContainerException;
import edu.maen.core.exceptions.RecyclingBinException;
import edu.maen.core.interfaces.IContainer;
import edu.maen.core.interfaces.IGeographicCoordinates;
import edu.maen.core.interfaces.IPath;
import edu.maen.core.interfaces.IRecyclingBin;
import java.util.Objects;

/*
* Nome: <Samuel Luciano Correia da Cunha>
* Número: <8160526>
*/
public class RecyclingBin implements IRecyclingBin {

    /**
     * The number of containers.
     */
    private int numberOfContainers;

    /**
     * The recycling bin code
     */
    private String code;

    /**
     * The recycling bin zone
     */
    private String zone;

    /**
     * The recycling bin description of the place
     */
    private String description;
    
    /**
     * The recycling bin type
     */
    private String type;

    /**
     * The distance between this recycling bin to other
     */
    private int distance;

    /**
     * The duration between this recycling bin to other
     */
    private int duration;

    /**
     * The recycling bin geographic coordinates
     */
    private IGeographicCoordinates geographicCoordinates;

    /**
     * Collection of Containers
     */
    private Container[] containers;

    /**
     * Collection of paths
     */
    private IPath[] paths;
    
    private static final int CONTAINER_SIZE = 10;
    private static final int PATH_SIZE = 10;
    private int count = 0;
    private int count2 = 0;

    /**
     * Constructor of Recycling Bin
     *
     * @param code the recycling bin code
     * @param zone the recycling bin zone
     * @param description the recycling bin description of the place
     * @param type the recycling bin type
     * @param geographicCoordinates the recycling bin coordinates
     */
    public RecyclingBin(String code, String zone, String description, String type, IGeographicCoordinates geographicCoordinates) {
        this.code = code;
        this.zone = zone;
        this.description = description;
        this.type = type;
        this.distance = distance;
        this.duration = duration;
        this.geographicCoordinates = geographicCoordinates;
        this.containers = new Container[CONTAINER_SIZE];
        this.paths = new IPath[PATH_SIZE];
    }

    /**
     * Getter for the recycling bin code
     *
     * @return the recycling bin code
     */
    @Override
    public String getCode() {
        return this.code;
    }

    /**
     * Setter for the recycling bin code
     *
     * @param code the recycling bin code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Getter for the recycling bin zone
     *
     * @return the recycling bin zone
     */
    @Override
    public String getZone() {
        return this.zone;
    }

    /**
     * Setter for the recycling bin zone
     *
     * @param zone the recycling bin zone
     */
    public void setZone(String zone) {
        this.zone = zone;
    }

    /**
     * Getter for the description of the place in which the recycling bin is
     * installed
     *
     * @return the description of the local
     */
    @Override
    public String getRefLocal() {
        return this.description;
    }

    /**
     * Setter for the description of the place in which the recycling bin is
     * installed
     *
     * @param description the description of the local
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Getter for the recycling bin type
     *
     * @return the recycling bin type
     */
    @Override
    public String getType() {
        return this.type;
    }

    /**
     * Setter for the recycling bin type
     *
     * @param type the recycling bin type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Getter for the recycling bin geographic coordinates
     *
     * @return the recycling bin geographic coordinates
     */
    @Override
    public IGeographicCoordinates getCoordinates() {
        return this.geographicCoordinates;
    }

    /**
     * Setter for the recycling bin geographic coordinates
     *
     * @param geographicCoordinates the recycling bin geographic coordinates
     */
    public void setGeographicCoordinates(IGeographicCoordinates geographicCoordinates) {
        this.geographicCoordinates = geographicCoordinates;
    }

    /**
     * Getter for Distance and Duration between current recycling bin and
     * parameter irb
     *
     * @param irb the "to" recycling bin
     * @return the distance and duration between recycling bins
     * @throws RecyclingBinException if recycling bin does not exist
     */
    @Override
    public IPath getDistanceAndDuration(IRecyclingBin irb) throws RecyclingBinException {

        for (int i = 0; i < this.paths.length; i++) {
            if (irb.getCode().equals(this.code)) {
                this.distance = paths[i].getDistance();
                System.out.println(distance);
                this.duration = paths[i].getDuration();
                System.out.println(duration);
            }
        }
        return null;
    }

    /**
     * Adds a new container to the recycling bin
     *
     * @param ic the container to be added
     * @return true if the container was inserted in the collection storing all
     * containers; False if the container already exists
     * @throws ContainerException if container is null; container type (waste
     * type) already exists
     */
    @Override
    public boolean addContainer(IContainer ic) throws ContainerException {
        boolean duplicated = false;

        for (int i = 0; i < this.count; i++) {
            if (ic.getType() == this.containers[i].getType() || (ic.getCode() == null) || (ic.getCode().equals(this.containers[i].getCode()))) {
                duplicated = true;
                throw new ExceptionContainer("Container waste type already exists or container is null/already exists");
            }
        }

        if (this.count >= 0 && duplicated == false) {
            this.containers[this.count] = (Container) ic;
            this.count++;
            return true;
        }
        return false;
    }

    /**
     * Considering a waste type, returns the correspondent container
     *
     * @param wt the given waste type
     * @return the container
     * @throws ContainerException if the container does not exist
     */
    @Override
    public IContainer getContainer(WasteType wt) throws ContainerException {

        for (int i = 0; i < this.count; i++) {
            if (this.containers[i].getType().equals(wt)) {
                return this.containers[i];
            } else {
                throw new ExceptionContainer("Container not found");
            }
        }
        return null;
    }

    /**
     * Return a copy of a existing containers
     *
     * @return a copy of existing containers
     */
    @Override
    public IContainer[] getContainers() {
        /*
        IContainer[] copyContainers = new IContainer[this.numberOfContainers];
        for (int i = 0; i < this.numberOfContainers; i++) {
            copyContainers[i] = this.containers[i];
        }
        return copyContainers;
         */
        return this.containers;
        
        
    }
    
    /**
     * Method that returns if container is empty.
     *
     * @return true if container is empty, false otherwise.
     */
    public boolean isEmpty() {
        return (this.numberOfContainers == 0);
    }

    /**
     * Adds a new path describing the path between this recycling bin to other
     * recycling bin
     *
     * @param ipath the path
     * @return true if the path was inserted in the collection storing all
     * paths; False if the path already exists
     * @throws RecyclingBinException if path is null or already exists
     */
    @Override
    public boolean addPath(IPath ipath) throws RecyclingBinException {
        boolean duplicated = false;

        for (int i = 0; i < this.count2; i++) {
            if (ipath.getTo() == this.paths[i].getTo() || (ipath.getTo() == null)) {
                duplicated = true;
                throw new ExceptionRecyclingBin("Path already exists or path is null");
            }
        }

        if (this.count2 >= 0 && duplicated == false) {
            this.paths[this.count2] = ipath;
            this.count2++;
            return true;
        }
        return false;
    }

    /**
     * To String method representing the RecyclingBin.
     *
     * @return String with all the information about the recycling bin.
     */
    @Override
    public String toString() {
        return "CODE: " + this.code + "\nDESCRIPTION: " + this.description
                + "\nRECYCLING BIN TYPE: " + this.type + "\nZONE: " + this.zone;
    }

    /**
     * Compares two Recycling Bins.
     *
     * @param bin bin to be compared
     * @return true if bin is equal to the bin code.
     */
    @Override
    public boolean equals(Object bin) {
        if (this == bin) {
            return true;
        }
        if (bin == null) {
            return false;
        }
        if (getClass() != bin.getClass()) {
            return false;
        }
        final RecyclingBin other = (RecyclingBin) bin;
        if (!Objects.equals(this.code, other.code)) {
            return false;
        }
        return true;
    }
}
