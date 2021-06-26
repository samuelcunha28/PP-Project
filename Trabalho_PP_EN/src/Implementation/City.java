/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implementation;

import edu.maen.core.enumerations.WasteType;
import edu.maen.core.exceptions.ContainerException;
import edu.maen.core.exceptions.MeasurementException;
import edu.maen.core.exceptions.RecyclingBinException;
import edu.maen.core.interfaces.ICity;
import edu.maen.core.interfaces.IContainer;
import edu.maen.core.interfaces.IMeasurement;
import edu.maen.core.interfaces.IRecyclingBin;

/**
 *
 * @author samue
 */
public class City implements ICity {

    @Override
    public String getName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addRecyclingBin(IRecyclingBin irb) throws RecyclingBinException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addMeasurement(IMeasurement im, IContainer ic) throws ContainerException, MeasurementException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IRecyclingBin[] getRecyclingBin() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IMeasurement[] getMeasurements(IRecyclingBin irb, WasteType wt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
