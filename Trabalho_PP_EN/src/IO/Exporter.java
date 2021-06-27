package IO;

import Implementation.Measurement;
import edu.maen.core.interfaces.ICity;
import edu.maen.core.interfaces.IMeasurement;
import edu.maen.core.interfaces.IPath;
import edu.maen.io.interfaces.IExporter;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/*
* Nome: <Samuel Luciano Correia da Cunha>
* Número: <8160526>
 */
public class Exporter implements IExporter {

    /**
     * Exporter path to a file were the delivery info will be stored.
     */
    private String GUIpath;

    /**
     * City to be exported
     */
    private ICity city;

    /**
     * Builds an exporter object
     *
     * @param city city associated with the data to be exported
     * @param GUIpath path of the file to be exported
     */
    public Exporter(ICity city, String GUIpath) {
        this.city = city;
        this.GUIpath = GUIpath;
    }

    /**
     * Sets the path of the file to export
     *
     * @param GUIpath path of the file to export
     */
    public void setGUIpath(String GUIpath) {
        this.GUIpath = GUIpath;
    }

    /**
     * Sets the city parameter
     *
     * @param city city parameter
     */
    public void setCity(ICity city) {
        this.city = city;
    }

    /**
     * Exports the data to a JSON file
     *
     * @return "Done" when finished
     * @throws IOException if there was an Input/Output error
     */
    @Override
    public String export() throws IOException {
        try (FileWriter file = new FileWriter(this.GUIpath)) {
            file.write(serializeBinGUI().toJSONString());
        }
        return "Done";
    }

    /**
     * Serializes an Recycling Bin according to render method.
     *
     * @return an JSONObject that can be written to a file
     * @throws IOException Signals that an I/O exception of some sort has
     * occurred. This class is the general class of exceptions produced by
     * failed or interrupted I/O operations.
     */
    private JSONArray serializeBinGUI() throws IOException {
        JSONArray obj = new JSONArray();
        JSONObject write = new JSONObject();
        JSONObject cont = new JSONObject();

        for (int i = 0; i < city.getRecyclingBin().length; i++) {
            if (city.getRecyclingBin()[i] != null) {

                for (int j = 0; j < city.getRecyclingBin()[i].getContainers().length; j++) {
                    if (city.getRecyclingBin()[i].getContainers()[j] != null) {

                        write.put("Codigo", city.getRecyclingBin()[i].getCode());
                        write.put("Ref. Localização", city.getRecyclingBin()[i].getRefLocal());
                        write.put("Zona", city.getRecyclingBin()[i].getZone());
                        write.put("Latitude", city.getRecyclingBin()[i].getCoordinates().getLatitude());
                        write.put("Longitude", city.getRecyclingBin()[i].getCoordinates().getLongitude());

                        cont.put("codigo", city.getRecyclingBin()[i].getContainers()[j].getCode());
                        cont.put("capacidade", city.getRecyclingBin()[i].getContainers()[j].getCapacity());

                        write.put("Contentores", cont);
                        obj.add(write);
                    }
                }
            }
        }
        return obj;
    }
}