import java.io.*;
import java.nio.file.Files;

public class SaveCSV {

    public static void main(String[] args) throws IOException {

        String fileName = "/Users/tiagohernan/Documents/Tec/1sem/Progra/proyecto_final_/test.csv";

        File archivo = new File(fileName);
        //dominio donde se hará el archivo

        archivo.delete();

        archivo.createNewFile();
        //Crea un nuevo archivo en este caso de llama ejemplo.txt

        FileWriter escritor = new FileWriter(archivo, true);

        /* no usar asi:
        +  escritor.write("Soy una verga.\nSalto de línea");
        */

        PrintWriter pw = new PrintWriter(escritor);

        pw.printf("Ejemplo de archivo con formato.%nNumero: %d%n",2017);
        pw.printf("Numero: %d",2018);


        escritor.close();
    }

}
