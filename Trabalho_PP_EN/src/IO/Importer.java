package IO;

import Implementation.City;
import Implementation.GeographicCoordinates;
import Implementation.RecyclingBin;
import edu.maen.core.exceptions.CityException;
import edu.maen.core.exceptions.RecyclingBinException;
import edu.maen.core.interfaces.ICity;
import edu.maen.io.interfaces.IImporter;
import edu.maen.io.interfaces.IOStatistics;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/*
* Nome: <Samuel Luciano Correia da Cunha>
* Número: <8160526>
 */
public class Importer implements IImporter {
    
    private InputOutputStatistics io;
    
    private static FileWriter file;
    
    private City city;

    public Importer(City city) {
        this.city = city;
    }
    
    /**
     * Reads the input JSON file
     * @param icity the city which the file data will be read
     * @param filePath the file path
     * @throws FileNotFoundException if file is not found 
     * @throws IOException if the file cannot be read
     * @throws CityException if the city is null
     */
    @Override
    public void importData(ICity icity, String filePath) throws FileNotFoundException, IOException, CityException {
        try {
            
            if (icity == null) throw new CityException("City is null");
            
            JSONParser jsonParser = new JSONParser();
            FileReader reader = new FileReader(filePath);
            Object obj = jsonParser.parse(reader);
            
            JSONArray jsonObject = (JSONArray) obj;
            
            String Codigo;
            String ref;
            String zona;
            Double latitude;
            Double longitude;
            String codigo;
            Double capacidade;
            
            
            for(Object arrObj : jsonObject){

                JSONObject parsed = (JSONObject) arrObj;
                Codigo = parsed.get("Codigo").toString();
                ref = parsed.get("Ref. Localização").toString();
                zona = parsed.get("Zona").toString();
                
                latitude = Double.parseDouble(parsed.get("Latitude").toString());
                longitude = Double.parseDouble(parsed.get("Longitude").toString());
                
                codigo = parsed.get("codigo").toString();
                capacidade = Double.parseDouble(parsed.get("capacidade").toString());
                
                JSONObject parsedCont = (JSONObject) parsed.get("Contentores");
                
                codigo = parsedCont.get("codigo").toString();
                capacidade = Double.parseDouble(parsedCont.get("capacidade").toString());
                
                GeographicCoordinates coord1 = new GeographicCoordinates(latitude, longitude);
                RecyclingBin bin1 = new RecyclingBin(Codigo, zona, ref, null, coord1);
                icity.addRecyclingBin(bin1);
            }     
            
        } catch (ParseException ex) {
            Logger.getLogger(Importer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CityException e) {
            System.out.println(e.toString());
        } catch (RecyclingBinException ex) {
            Logger.getLogger(Importer.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }   
    
    /**
     * Return the import statistics 
     * @return the statistics
     */
    @Override
    public IOStatistics getStats() {
        return this.io;
    }

    /**
     * Stores the statistics in a JSON file
     * @param filePath the file path
     * @throws IOException 
     */
    @Override
    public void report(String filePath) throws IOException {
        int countM = 0;
        int countC = 0;
        int countB = 0;
        JSONObject write = new JSONObject();
        JSONArray obj = new JSONArray();
        
        for (int i = 0; i < this.city.getNumMeasurements().length; i++) {
            if (this.city.getRecyclingBin()[i] != null) {
                countM++;
                write.put("Number of measurements", countM);
            }
        }
        
        for (int i = 0; i < city.getRecyclingBin().length; i++) {
            if (city.getRecyclingBin()[i] != null) {
                countB++;
                write.put("Number of bins", countB);

                for (int j = 0; j < city.getRecyclingBin()[i].getContainers().length; j++) {
                    if (city.getRecyclingBin()[i].getContainers()[j] != null) {
                        countC++;
                        write.put("Number of containers", countC);
                    }
                }
            }
        }
        obj.add(write);
        
        try {
            // Constructs a FileWriter given a file name, using the platform's default charset
            file = new FileWriter(filePath);
            file.write(obj.toJSONString());
            System.out.println("Successfully Copied JSON Object to File...");
 
        } catch (IOException e) {
            e.printStackTrace();
 
        } finally {
 
            try {
                file.flush();
                file.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}