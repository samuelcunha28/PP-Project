package IO;

import Implementation.GeographicCoordinates;
import Implementation.RecyclingBin;
import edu.maen.core.exceptions.CityException;
import edu.maen.core.exceptions.RecyclingBinException;
import edu.maen.core.interfaces.ICity;
import edu.maen.core.interfaces.IRecyclingBin;
import edu.maen.io.interfaces.IImporter;
import edu.maen.io.interfaces.IOStatistics;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
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

    @Override
    public IOStatistics getStats() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void report(String string) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
