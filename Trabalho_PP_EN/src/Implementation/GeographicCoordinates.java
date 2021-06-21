package Implementation;

import edu.maen.core.interfaces.IGeographicCoordinates;

/*
* Nome: <Samuel Luciano Correia da Cunha>
* Número: <8160526>
*/
public class GeographicCoordinates implements IGeographicCoordinates {

    /**
     * The latitude coordinate
     */
    private double latitude;
    
    /**
     * The longitude coordinate
     */
    private double longitude;
    
    /**
     * Constructor of GeographicCoordinates
     * @param latitude the latitude coordinate
     * @param longitude the longitude coordinate
     */
    public GeographicCoordinates(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }
    
    /**
     * Getter for latitude 
     * @return The latitude coordinate
     */
    @Override
    public double getLatitude() {
        return this.latitude;
    }
    
    /**
     * Setter for latitude
     * @param latitude the latitude coordinate
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
    
    /**
     * Getter for longitude
     * @return the longitude coordinate
     */
    @Override
    public double getLongitude() {
        return this.longitude;
    }
    
    /**
     * Setter for longitude
     * @param longitude the longitude coordinate
     */
     public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
    
    /**
     * To String method representing the GeograpicCoordinates.
     * @return String with all the information about the coordinates.
     */
    @Override
    public String toString() {
        return "LATITUDE: " + this.latitude + "\nLONGITUDE: " + this.longitude; 
    }
    
    /**
     * Compares latitude and longitude coordinates
     * @param coordinates object to be compared
     * @return if coordinates is equal to the both latitude or longitude coordinates.
     */
    @Override
    public boolean equals(Object coordinates) {
        if (this == coordinates) {
            return true;
        }
        if (coordinates == null) {
            return false;
        }
        if (getClass() != coordinates.getClass()) {
            return false;
        }
        final GeographicCoordinates other = (GeographicCoordinates) coordinates;
        if (Double.doubleToLongBits(this.latitude) != Double.doubleToLongBits(other.latitude)) {
            return false;
        }
        if (Double.doubleToLongBits(this.longitude) != Double.doubleToLongBits(other.longitude)) {
            return false;
        }
        return true;
    }
}