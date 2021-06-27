package Main;

import IO.Exporter;
import IO.Importer;
import IO.InputOutputStatistics;
import Implementation.City;
import Implementation.Container;
import Implementation.GeographicCoordinates;
import Implementation.Measurement;
import Implementation.Path;
import Implementation.RecyclingBin;
import edu.maen.core.enumerations.WasteType;
import edu.maen.core.exceptions.ContainerException;
import edu.maen.core.exceptions.RecyclingBinException;
import java.io.IOException;
import java.time.LocalDateTime;

/*
* Nome: <Samuel Luciano Correia da Cunha>
* Número: <8160526>
 */
public class Main {
    public static void main(String[] args) throws ContainerException, RecyclingBinException, IOException {
        //------------------------- GEOGRAPHIC COORDINATES ---------------------
        GeographicCoordinates coord1 = new GeographicCoordinates(5.0, 5.0);
        GeographicCoordinates coord2 = new GeographicCoordinates(10.0, 5.0);

        //------------------------- CONTAINERS ---------------------------------
        Container container1 = new Container("1", 100, WasteType.B);
        System.out.println("CONTAINER 1");
        System.out.println(container1);
        System.out.println("");

        Container container2 = new Container("2", 150, WasteType.E);
        System.out.println("CONTAINER 2");
        System.out.println(container2);
        System.out.println("");

        //------------------------- RECYCLING BINS -----------------------------
        RecyclingBin bin1 = new RecyclingBin("1", "Lousada", "Perto da CM", "P", coord1);
        System.out.println("BIN 1");
        System.out.println(bin1);
        System.out.println("");

        RecyclingBin bin2 = new RecyclingBin("2", "Felgueiras", "Perto do LIDL", "V", coord2);
        System.out.println("BIN 2");
        System.out.println(bin2);
        System.out.println("");
        
        // MANIPULATION BINS
        
        System.out.println("ADDED CONTAINER1 TO BIN1");
        bin1.addContainer(container1);
        System.out.println("LIST ALL CONTAINERS");
        for (int i = 0; i < bin1.getContainers().length; i++) {
            if (bin1.getContainers()[i] != null) {
                System.out.println(bin1.getContainers()[i].toString());

            }
        }
        System.out.println("END OF LIST");
        System.out.println("");
        
        System.out.println("LIST CONTAINER BY WASTE TYPE");
        for (int i = 0; i < bin1.getContainers().length; i++) {
            if (bin1.getContainers()[i] == bin1.getContainer(WasteType.B)) {
                System.out.println(bin1.getContainers()[i].toString());

            }
        }
        System.out.println("END OF LIST");
        System.out.println("");
        //------------------------- MEASUREMENTS -------------------------------
        Measurement measurement1 = new Measurement(1, container1, bin1, LocalDateTime.now(), 50);
        System.out.println("MEASUREMENT 1");
        System.out.println(measurement1);
        System.out.println("");

        Measurement measurement2 = new Measurement(2, container2, bin2, LocalDateTime.now(), 50);
        System.out.println("MEASUREMENT 2");
        System.out.println(measurement2);
        System.out.println("");

        //------------------------- PAHTS --------------------------------------
        Path path1 = new Path(bin2, 15, 20);
        System.out.println("PATH 1");
        System.out.println(path1);
        System.out.println("");

        // Path path2 = new Path(bin3, 10, 15);
        System.out.println("PATH 2");
        // System.out.println(path2);
        System.out.println("");
        
        
        // MANIPULATION PATHS
        System.out.println("ADDED PATH1 TO BIN 1");
        bin1.addPath(path1);
        
        //------------------------- CITIES -------------------------------------
        City city1 = new City("Porto");
        
        // MANIPULATION CITIES
        city1.addRecyclingBin(bin1);
        city1.addRecyclingBin(bin2);
        
        // city1.removeRecyclingBin(0);
        // city1.removeRecyclingBin2(bin1);
        
        
        System.out.println("AQUI AQUI");
        for (int i = 0; i < city1.getRecyclingBin().length; i++) {
            if (city1.getRecyclingBin()[i] != null) {
                System.out.println(city1.getRecyclingBin()[i].toString());

            }
        }
        
        //-------------------------- EXPORTER ----------------------------------
        Exporter exporter = new Exporter(city1, "City1.json");
        exporter.export();
        // Dashboard.render("City1.json");
        
        //-------------------------- IMPORTER ----------------------------------
        Importer importer = new Importer(city1);
        importer.report("C:\\Users\\samue\\Desktop\\Study\\Paradigmas\\Trabalho pratico\\PP-Project\\Trabalho_PP_EN\\statistics.txt");
        
        //--------------------------- IOSTATISTICS -----------------------------
        InputOutputStatistics io1 = new InputOutputStatistics(city1); 
        System.out.println(io1);
    }
}