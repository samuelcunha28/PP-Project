/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implementation;

import edu.maen.core.interfaces.IRecyclingBin;
import edu.maen.core.interfaces.IRoute;
import java.io.IOException;

/**
 *
 * @author samue
 */
public class Route implements IRoute {

    @Override
    public IRecyclingBin[] getRoute(double d, double d1, double d2, double d3) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getTotalDistance(IRecyclingBin[] irbs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getTotalDuration(IRecyclingBin[] irbs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String export() throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
