package Implementation;

import edu.maen.core.interfaces.IPath;
import edu.maen.core.interfaces.IRecyclingBin;

/*
* Nome: <Samuel Luciano Correia da Cunha>
* Número: <8160526>
*/
public class Path implements IPath {
    
    /**
     * The recycling bin from the "to" route
     * 
     * Para simplificar, esta é a variável de instância de "destino" (contentor)
     */
    private IRecyclingBin to;
    
    /**
     * The distance (in KM) between recycling bins
     */
    private int distance;
    
    /**
     * The route duration (in MIN) between recycling bins
     */
    private int duration;

    /**
     * Constructor of Path
     * @param to the recycle bin from the "to" route
     * @param distance the distance between recycling bins
     * @param duration the duration between recycling bins
     */
    public Path(IRecyclingBin to, int distance, int duration) {
        this.to = to;
        this.distance = distance;
        this.duration = duration;
    }
    
    /**
     * Getter for the recycling bin from the "to" route
     * @return the recycling bin from the "to" route
     */
    @Override
    public IRecyclingBin getTo() {
        return this.to;
    }
    
    /**
     * Setter for the recycling bin from the "to" route
     * @param to the recycling bin from the "to" route
     */
    public void setTo(IRecyclingBin to) {
        this.to = to;
    }

    /**
     * Getter for the distance (kilometers) between recycling bins
     * @return the distance between recycling bins
     */
    @Override
    public int getDistance() {
        return this.distance;
    }
    
    /**
     * Setter for the distance (kilometers) between recycling bins
     * @param distance the distance between recycling bins
     */
    public void setDistance(int distance) {
        this.distance = distance;
    }

    /**
     * Getter for route duration (minutes) between recycling bins
     * @return the route duration between recycling bins
     */
    @Override
    public int getDuration() {
        return this.duration;
    }
    
    /**
     * Setter for route duration (minutes) between recycling bins
     * @param duration the duration between recycling bins
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }
    
    /**
     * To String method representing the Path.
     * @return String with all the information about the path.
     */
    @Override
    public String toString() {
        return "TO RECYCLING BIN: " + this.to + "\nDISTANCE: " + this.distance + 
                "\nDURATION: " + this.duration; 
    }
    
}
