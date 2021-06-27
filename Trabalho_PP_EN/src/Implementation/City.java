package Implementation;

import Exceptions.ExceptionContainer;
import Exceptions.ExceptionMeasurement;
import Exceptions.ExceptionRecyclingBin;
import edu.maen.core.enumerations.WasteType;
import edu.maen.core.exceptions.ContainerException;
import edu.maen.core.exceptions.MeasurementException;
import edu.maen.core.exceptions.RecyclingBinException;
import edu.maen.core.interfaces.ICity;
import edu.maen.core.interfaces.IContainer;
import edu.maen.core.interfaces.IMeasurement;
import edu.maen.core.interfaces.IRecyclingBin;

/*
* Nome: <Samuel Luciano Correia da Cunha>
* Número: <8160526>
 */
public class City implements ICity {

    private static final int MEASUREMENTS_SIZE = 10;
    private static final int BINS_SIZE = 10;
    private int count = 0;
    private int count2 = 0;

    /**
     * The number of measurements.
     */
    private int numberOfMeasurements;

    private int numberOfRecyclingBins;

    /**
     * The city name
     */
    private String name;

    /**
     * Collection of Measurements
     */
    private IMeasurement[] measurements;

    /**
     * Collection of Recycling bins
     */
    private IRecyclingBin[] bins;

    /**
     * The container
     */
    private IContainer container;

    /**
     * Constructor of City
     *
     * @param name the name of the city
     */
    public City(String name) {
        this.name = name;
        this.measurements = new IMeasurement[MEASUREMENTS_SIZE];
        this.bins = new IRecyclingBin[BINS_SIZE];
    }

    /**
     * Getter for city name
     *
     * @return the city name
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Setter for city name
     *
     * @param name the city name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Adds a new recycling bin to the city
     *
     * @param irb the recycling bin to be installed in the city
     * @return true if the recycling bin was inserted in the collection storing
     * all recycling bins false if the recycle bin already exists
     * @throws RecyclingBinException if the recycling bin is null and the
     * recycling bin is invalid (if the recycling bin have duplicate container
     * of a certain type)
     */
    @Override
    public boolean addRecyclingBin(IRecyclingBin irb) throws RecyclingBinException {
        boolean duplicated = false;

        for (int i = 0; i < this.count; i++) {
            if (irb.getType().equals(this.bins[i].getType()) || (irb.getCode() == null) || (irb.getCode().equals(this.bins[i].getCode()))) {
                duplicated = true;
                throw new ExceptionRecyclingBin("Recycle bin waste type already exists or bin is null/already exists");
            }
        }

        if (this.count >= 0 && duplicated == false) {
            this.bins[this.count] = irb;
            this.count++;
            return true;
        }
        return false;
    }

    /**
     * Adds a new measurement to the city considering the recycling bin and
     * container
     *
     * @param im measurement considering the recycling bin and container
     * @param ic the container for the measurement
     * @return true if the measurement was inserted in the collection storing
     * all measurements false if the measurement already existes for a given
     * date (each container has only one measurement for a given date)
     * @throws ContainerException if the container doesnt exist
     * @throws MeasurementException if the value is lesser than 0 and higher to
     * the capacity
     */
    @Override
    public boolean addMeasurement(IMeasurement im, IContainer ic) throws ContainerException, MeasurementException {
        boolean duplicated = false;

        for (int i = 0; i < this.count2; i++) {
            if ((im.getDate().equals(this.measurements[i].getDate())) || (ic.getCode() == null)) {
                duplicated = true;
                throw new ExceptionContainer("The measurement already exists or container does not exist");
            } else if (im.getValue() < 0 && im.getValue() > ic.getCapacity()) {
                throw new ExceptionMeasurement("Value is lesser than 0 or higher to the capacity of the container");
            }
        }

        if (this.count2 >= 0 && duplicated == false) {
            this.measurements[this.count2] = im;
            this.count2++;
            return true;
        }
        return false;
    }

    /**
     * Returns a copy of a existing recycle bin
     *
     * @return a copy of a existing recycle bin
     */
    @Override
    public IRecyclingBin[] getRecyclingBin() {
        return this.bins;
        
    }

    /**
     * Return a copy of a existing measurements from a recycling bin and waste
     * type
     *
     * @param irb recycling bin for measurements
     * @param wt waste type for getting measurements
     * @return a copy of existing measurements
     */
    @Override
    public IMeasurement[] getMeasurements(IRecyclingBin irb, WasteType wt) {
        int count = 0;

        IMeasurement[] copyMeasurements = new IMeasurement[this.numberOfMeasurements];
        for (int i = 0; i < this.numberOfMeasurements; i++) {
            if ((this.measurements[i].getRecyclingBin().equals(irb) && (this.measurements[i].getContainer().getType().equals(wt)))) {
                copyMeasurements[count] = this.measurements[i];
                count++;
            }
        }
        return copyMeasurements;
    }
    
    /**
     * Returns the number of registered measurements
     * @return the number of registered measurements
     */
    public IMeasurement[] getNumMeasurements() {
        return this.measurements;
    }
}
