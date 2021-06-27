package Implementation;

import Exceptions.ExceptionContainer;
import edu.maen.core.interfaces.ICity;
import edu.maen.core.interfaces.IContainer;
import edu.maen.core.interfaces.IMeasurement;
import edu.maen.core.interfaces.IRecyclingBin;
import edu.maen.core.interfaces.IRoute;
import java.io.IOException;

/*
* Nome: <Samuel Luciano Correia da Cunha>
* Número: <8160526>
 */
public class Route implements IRoute {

    private double distance;

    private double duration;

    private int count = 0;

    private IRecyclingBin[] bins;

    private double maxCapacity;

    private IMeasurement measurement;

    private IContainer container;

    private ICity city;

    /**
     * Constructor of Route
     *
     * @param maxCapacity the max capacity of the vehicle used for collecting
     * waste
     */
    public Route(double maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    /**
     * Calculates and returns the route based on the read measurements
     *
     * @param kilometersLimit
     * @param durationLimit
     * @param percentageCriteria
     * @param maxCapacity
     * @return percentageCriteria é calculado pela capacidade do container e a
     * medida atual do mesmo
     */
    @Override
    public IRecyclingBin[] getRoute(double kilometersLimit, double durationLimit, double percentageCriteria, double maxCapacity) {
        for (int i = 0; i < city.getRecyclingBin().length; i++) {
            if (city.getRecyclingBin()[i] != null) {

                for (int j = 0; j < city.getRecyclingBin()[i].getContainers().length; j++) {
                    if (city.getRecyclingBin()[i].getContainers()[j] != null) {
                        // fazer o calculo da distancia e tempo
                    }
                }
            }
        }

        // devolver a percentagem
        percentageCriteria = (measurement.getValue() / container.getCapacity()) * 100;
        return null;
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

// cada bin tem um path associado (exemplo bin1 vai para o bin2 e tem a distancia e o tempo)
// tem que se incrementar estes valores e adicionando paths
// no fim devolver um array de rotas contendo os bins que passou
