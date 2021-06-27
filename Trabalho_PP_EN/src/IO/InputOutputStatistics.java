package IO;

import Implementation.City;
import edu.maen.io.interfaces.IOStatistics;


/*
* Nome: <Samuel Luciano Correia da Cunha>
* Número: <8160526>
 */
public class InputOutputStatistics implements IOStatistics {

    private City city;
    private String[] exceptions;
    private static final int EXCEPTIONS_SIZE = 10;
    
    /**
     * Constructor of InputOutputStatistics
     * @param city city associated with all the statistics
     */
    public InputOutputStatistics(City city) {
        this.city = city;
        this.exceptions = new String[EXCEPTIONS_SIZE];
    }

    /**
     * Returns the number of read measurements
     *
     * @return the number of read measurements
     */
    @Override
    public int getNumberOfReadMeasurements() {
        int count = 0;

        for (int i = 0; i < this.city.getNumMeasurements().length; i++) {
            if (this.city.getRecyclingBin()[i] != null) {
                count++;
            }
        }
        return count;
    }

    /**
     * Returns the number of Recycling Bin data read
     *
     * @return the number of Recycling Bin data read
     */
    @Override
    public int getNumberOfRecyclingBinRead() {
        int count = 0;

        for (int i = 0; i < this.city.getRecyclingBin().length; i++) {
            if (this.city.getRecyclingBin()[i] != null) {
                count++;
            }
        }
        return count;
    }

    /**
     * Returns the number of Containers data read
     * 
     * @return the number of Containers data read
     */
    @Override
    public int getNumberOfContainersRead() {
        int count = 0;
        for (int i = 0; i < city.getRecyclingBin().length; i++) {
            if (city.getRecyclingBin()[i] != null) {

                for (int j = 0; j < city.getRecyclingBin()[i].getContainers().length; j++) {
                    if (city.getRecyclingBin()[i].getContainers()[j] != null) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    /**
     * Returns the array of strings representing the occurred exceptions
     * 
     * @return the array of strings representing the occurred exceptions
     */
    @Override
    public String[] getExceptions() {
        return this.exceptions;
    }
    
    
    /**
     * To String method representing all data for statistics.
     *
     * @return String with all the information for statistics.
     */
    @Override
    public String toString() {
        return "NUMBER OF RB: " + this.getNumberOfRecyclingBinRead() + 
                "\nNUMBER OF MEASUREMENTS: " + this.getNumberOfReadMeasurements()
                + "\nNUMBER OF CONTAINERS: " + this.getNumberOfContainersRead();
    }
}
