import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LeerCSV{

    private static String fileName = "/Users/tiagohernan/Documents/Tec/1sem/Progra/proyecto_final_/empleados.csv";

    private static Scanner lector;
    private static Map<Integer, String> nombresEmpleados = new HashMap<Integer, String>();
    private static Map<Integer, String> apellidosEmpleados = new HashMap<Integer, String>();
    private static Map<Integer, String> cargosEmpleados = new HashMap<Integer, String>();
    private static Map<Integer, Integer> sueldosEmpleados = new HashMap<Integer, Integer>();
    private static Map<Integer, String> fechasIngresoEmpleados = new HashMap<Integer, String>();


    public static void main(String[] args) throws IOException {

        String line;

        FileReader reader = new FileReader(fileName);
        BufferedReader br = new BufferedReader(reader);

        while ( (line = br.readLine()) != null) {

            String[] elements;
            elements = line.split(",");

            nombresEmpleados.put(Integer.valueOf(elements[0]) , elements[1]);
            apellidosEmpleados.put(Integer.valueOf(elements[0]) , elements[2]);
            cargosEmpleados.put(Integer.valueOf(elements[0]) , elements[3]);
            sueldosEmpleados.put(Integer.valueOf(elements[0]) , Integer.valueOf(elements[4]));
            fechasIngresoEmpleados.put(Integer.valueOf(elements[0]) , elements[5]);

        }

        reader.close();

        for (Integer num : nombresEmpleados.keySet()) {

            System.out.printf("Número de nómina: %d\n" , num);
            System.out.printf("Nombre: %s\n" , nombresEmpleados.get(num));
            System.out.printf("Apellidos: %s\n" , apellidosEmpleados.get(num));
            System.out.printf("Cargo: %s\n" , cargosEmpleados.get(num));
            System.out.printf("Sueldo base: %d\n" , sueldosEmpleados.get(num));
            System.out.printf("Fecha de ingreso: %s\n" , fechasIngresoEmpleados.get(num));
            System.out.println("");
        }
    }

}
