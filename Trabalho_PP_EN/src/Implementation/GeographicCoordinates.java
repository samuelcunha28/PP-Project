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
     * Constructor of GeoCoordinates
     * @param latitude The geo coordinates latitude.
     * @param longitude The geo coordinates longitude.
     */
    
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
    
     // FALTA EQUALS e toString
}
