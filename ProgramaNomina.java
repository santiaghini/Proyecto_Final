/*
        _______________________________________________________________________
        * Desarrollado por Santiago Hernández, Gerardo Anglada e Isaac Harari *
        *            Tecnológico de Monterrey Campus Santa Fe                 *
        *              Sistema de Nómina para Microempresa                    *
        _______________________________________________________________________
*/


import java.io.*;
import java.util.*;

public class ProgramaNomina {
    private static String fileName = "/Users/tiagohernan/Documents/Tec/1sem/Progra/proyecto_final_/empleados.csv";

    private static Scanner lector;
    private static Map < Integer, String > nombresEmpleados = new HashMap < Integer, String > ();
    private static Map < Integer, String > apellidosEmpleados = new HashMap < Integer, String > ();
    private static Map < Integer, String > cargosEmpleados = new HashMap < Integer, String > ();
    private static Map < Integer, Integer > sueldosEmpleados = new HashMap < Integer, Integer > ();
    private static Map < Integer, String > fechasIngresoEmpleados = new HashMap < Integer, String > ();

    private static Map < Integer, List<Integer> > nominaEmpleados = new HashMap < Integer, List<Integer> > ();


    public static void main(String[] args) throws IOException {

        cargarcsv();

        lector = new Scanner(System.in);
        int op;
        String answer = "s";

        System.out.println("Bienvenido al sistema de manejo de nómina PERSEUS");

        // Este while permite que puedas repetir diferentes consultas hasta que el usuario decida terminar el programa
        while (answer.equals("s")) {

            System.out.println("¿Qué quieres hacer?");
            System.out.println("1: Consulta de empleados");
            System.out.println("2: Agregar empleado");
            System.out.println("3: Modificar empleado");
            System.out.println("4: Eliminar empleado");
            System.out.println("5: Añadir información para el pago de cada empleado (es necesario que esto se realice antes de pasar al paso 6 o 7)");
            System.out.println("6: Generar recibo de pago de cada trabajador");
            System.out.println("7: Generar listado de nómina");
            System.out.println("8: Generar ficha personal por empleado");

            System.out.println();
            System.out.println("Por favor, si al escribir y darle enter no pasa nada, vuelve a escribir tu petición y presiona enter de nuevo.");

            op = lector.nextInt();

            while ((op <= 0) || (op >= 9)) {
                System.out.println("Esa opción no es válida, por favor escribe un número en el rango.");
                op = lector.nextInt();
            }

            switch (op) {
                case 1:
                    consulta();
                    break;
                case 2:
                    agregar();
                    break;
                case 3:
                    modificar();
                    break;
                case 4:
                    eliminar();
                    break;
                case 5:
                    infoDePago();
                    break;
                case 6:
                    reciboDePago();
                    break;
                case 7:
                    listaNomina();
                    break;
                case 8:
                    enlistar();
                    break;
            }

            System.out.println("¿Quieres realizar otra consulta? En caso de que no, el programa guardará los cambios realizados. (s/n)");
            System.out.println("Recuerda que si al escribir y darle enter no pasa nada, vuelve a escribir tu petición y presiona enter de nuevo.");
            System.out.println();
            lector.nextLine();

            answer = lector.nextLine();

            // Guardamos los cambios que se hayan realizado.
            guardarCSV();

        }

    }

    private static void guardarCSV() throws IOException {

        String fileName = "/Users/tiagohernan/Documents/Tec/1sem/Progra/proyecto_final_/empleados.csv";

        File archivo = new File(fileName);
        //destino donde se hará el archivo

        archivo.delete();

        archivo.createNewFile();
        //Crea un nuevo archivo en este caso de llama test.csv

        FileWriter escritor = new FileWriter(archivo, true);

        /* no usar asi:
        +  escritor.write("Soy una verga.\nSalto de línea");
        */

        PrintWriter pw = new PrintWriter(escritor);

        // Creamos una lista para albergar las llaves del map
        List<Integer> list = new ArrayList<Integer>();
        list.addAll(nombresEmpleados.keySet());

        // Recorremos el array de llaves para sacar la información de cada empleado y la escribimos como una nueva entrada en el csv
        for (int i = 0; i<list.size(); i++) {
            int num = list.get(i);

            pw.printf("%d,%s,%s,%s,%d,%s", num, nombresEmpleados.get(num),apellidosEmpleados.get(num),cargosEmpleados.get(num),sueldosEmpleados.get(num),fechasIngresoEmpleados.get(num));
            if (i != list.size()){
                pw.printf("\n");
            }

        }


        escritor.close();

    }

    private static void cargarcsv() throws IOException {

        // Cargamos el csv para construir nuestros maps
        String line;

        FileReader reader = new FileReader(fileName);
        BufferedReader br = new BufferedReader(reader);

        // Recorremos cada línea para obtener la info del empleado
        while ((line = br.readLine()) != null) {

            String[] elements;
            elements = line.split(",");

            nombresEmpleados.put(Integer.valueOf(elements[0]), elements[1]);
            apellidosEmpleados.put(Integer.valueOf(elements[0]), elements[2]);
            cargosEmpleados.put(Integer.valueOf(elements[0]), elements[3]);
            sueldosEmpleados.put(Integer.valueOf(elements[0]), Integer.valueOf(elements[4]));
            fechasIngresoEmpleados.put(Integer.valueOf(elements[0]), elements[5]);

        }

        reader.close();
    }

    //La siguiente función se ejecuta cada vez que se quiera consultar los datos de un empleado en la base
    public static void consulta() {

        String a = "s";

        while (a.equals("s")) {

            System.out.println("Consulta un empleado");

            System.out.println("Número de nómina: ");
            Integer num = lector.nextInt();

            // Si no existe el empleado en la base no se podrá seguir
            boolean b = nombresEmpleados.containsKey(num);
            while (!b) {
                System.out.println("Ese empleado no existe en la base, pruebe de nuevo.");
                System.out.println("Número de nómina: ");
                num = lector.nextInt();
                b = nombresEmpleados.containsKey(num);
            }

            System.out.printf("Los datos existentes para el empleado con número de nómina %d son: \n", num);

            System.out.println("Nombre:");
            System.out.println(nombresEmpleados.get(num));

            System.out.println("Apellidos:");
            System.out.println(apellidosEmpleados.get(num));

            System.out.println("Cargo:");
            System.out.println(cargosEmpleados.get(num));

            System.out.println("Sueldo base: (sólo números)");
            System.out.println(sueldosEmpleados.get(num));

            System.out.println("Fecha de ingreso: (formato: día/mes/año)");
            System.out.println(fechasIngresoEmpleados.get(num));

            System.out.println("¿Quieres consultar datos de otro empleado?");
            System.out.println("s/n");
            lector.nextLine();
            a = lector.nextLine();
            System.out.println();

        }
    }

    //La siguiente función se ejecuta cada vez que se quiera agregar un nuevo empleado a la base
    public static void agregar() {

        String a = "s";

        while (a.equals("s")) {

            System.out.println("Agregar un nuevo empleado");

            System.out.println("Número de nómina: ");
            Integer num = lector.nextInt();

            // Si el empleado ya existe no se dejará continuar
            boolean b = nombresEmpleados.containsKey(num);
            while (b) {
                System.out.println("Ese empleado ya existe en la base, pruebe de nuevo.");
                System.out.println("Número de nómina: ");
                num = lector.nextInt();
                b = nombresEmpleados.containsKey(num);
            }

            lector.nextLine();
            System.out.println("Nombre: ");
            String nombre = lector.nextLine();

            System.out.println("Apellidos: ");
            String apellidos = lector.nextLine();

            System.out.println("Cargo: ");
            String cargo = lector.nextLine();

            System.out.println("Sueldo base: (sólo números)");
            Integer sueldo = lector.nextInt();
            lector.nextLine();

            System.out.println("Fecha de ingreso: (formato: día/mes/año)");
            String fechaIngreso = lector.nextLine();

            nombresEmpleados.put(num, nombre);
            apellidosEmpleados.put(num, apellidos);
            cargosEmpleados.put(num, cargo);
            sueldosEmpleados.put(num, sueldo);
            fechasIngresoEmpleados.put(num, fechaIngreso);

            System.out.printf("El empleado %s %s con número de nómina %d ha sido agregado a la base exitosamente. \n", nombre, apellidos, num);
            System.out.println("");

            System.out.println("¿Quieres agregar otro empleado?");
            System.out.println("s/n");
            a = lector.nextLine();
            System.out.println();

        }
    }

    //La siguiente función se ejecuta cada vez que se quiera modificar algún dato de un empleado en la base
    public static void modificar() {

        String a = "s";

        while (a.equals("s")) {


            System.out.println("Modificar empleado");

            System.out.println("Escribe el número de nómina:");
            Integer num = lector.nextInt();

            boolean b = nombresEmpleados.containsKey(num);
            while (!b) {
                System.out.println("Ese empleado no existe en la base, pruebe de nuevo.");
                System.out.println("Número de nómina: ");
                num = lector.nextInt();
                b = nombresEmpleados.containsKey(num);
            }

            System.out.printf("Los datos existentes para el empleado con número de nómina %d son: \n", num);

            System.out.println("Nombre:");
            System.out.println(nombresEmpleados.get(num));

            System.out.println("Apellidos:");
            System.out.println(apellidosEmpleados.get(num));

            System.out.println("Cargo:");
            System.out.println(cargosEmpleados.get(num));

            System.out.println("Sueldo base:");
            System.out.println(sueldosEmpleados.get(num));

            System.out.println("Fecha de ingreso: (formato: día/mes/año)");
            System.out.println(fechasIngresoEmpleados.get(num));
            System.out.println("");

            System.out.println("¿Escribe el número del dato que quieras modificar?");
            System.out.println("1: Nombre");
            System.out.println("2: Apellidos");
            System.out.println("3: Cargo");
            System.out.println("4: Sueldo base");
            System.out.println("5: Fecha de ingreso");
            int op = lector.nextInt();

            while ((op <= 0) || (op >= 8)) {
                System.out.println("Esa opción no es válida, por favor escribe un número en el rango.");
                op = lector.nextInt();
            }

            lector.nextLine();

            switch (op) {
                case 1:
                    System.out.println("Escribe el nuevo nombre:");
                    lector.nextLine();
                    String nombre = lector.nextLine();
                    nombresEmpleados.put(num, nombre);
                    break;
                case 2:
                    System.out.println("Escribe los nuevos apellidos:");
                    String apellidos = lector.nextLine();
                    apellidosEmpleados.put(num, apellidos);
                    break;
                case 3:
                    System.out.println("Escribe el cargo:");
                    String cargo = lector.nextLine();
                    cargosEmpleados.put(num, cargo);
                    break;
                case 4:
                    System.out.println("Escribe el sueldo base:");
                    Integer sueldo = lector.nextInt();
                    lector.nextLine();
                    sueldosEmpleados.put(num, sueldo);
                    break;
                case 5:
                    System.out.println("Escribe la nueva fecha de ingreso: (formato: día/mes/año)");
                    String fecha = lector.nextLine();
                    fechasIngresoEmpleados.put(num, fecha);
                    break;
            }


            System.out.println("¿Quieres modificar los datos de otro empleado?");
            System.out.println("s/n");
            lector.nextLine();
            a = lector.nextLine();
            System.out.println();

        }
    }


    //La siguiente función se ejecuta cada vez que se quiera eliminar a un empleado de la base
    public static void eliminar() {

        String a = "s";

        while (a.equals("s")) {


            System.out.println("Eliminar empleado");

            System.out.println("Escribe el número de nómina:");
            Integer num = lector.nextInt();

            // Si el empleado no existe no se podrá continuar
            boolean b = nombresEmpleados.containsKey(num);
            while (!b) {
                System.out.println("Ese empleado no existe en la base, pruebe de nuevo.");
                System.out.println("Número de nómina: ");
                num = lector.nextInt();
                b = nombresEmpleados.containsKey(num);
            }

            String nombre = nombresEmpleados.get(num);
            String apellidos = apellidosEmpleados.get(num);

            nombresEmpleados.remove(num);
            apellidosEmpleados.remove(num);
            cargosEmpleados.remove(num);
            sueldosEmpleados.remove(num);
            fechasIngresoEmpleados.remove(num);

            // Se eliminan todos los datos del empleado
            System.out.printf("El empleado %s %s con número de nómina %d ha sido eliminado de la base exitosamente.\n", nombre, apellidos, num);
            System.out.println("");

            System.out.println("¿Quieres eliminar otro empleado?");
            System.out.println("s/n");
            lector.nextLine();
            a = lector.nextLine();
            System.out.println();

        }
    }

    // En esta sección pediremos al usuario la información pertinente para generar los reportes
    private static void infoDePago() {
        System.out.printf("Es necesario recabar información de los empleados para\nposteriormente generar la nómina mensual.\n");
        System.out.printf("Iremos empleado por empleado\n");

        for (Integer num: nombresEmpleados.keySet()) {

            System.out.printf("Datos para el empleado con código %d - %s %s\n", num, nombresEmpleados.get(num), apellidosEmpleados.get(num));

            List<Integer> datosNomina = new ArrayList<Integer>();

            System.out.println("Por favor escribe cantidades con números enteros.");

            System.out.println("Escribe el número de días trabajados: (20 días dan como total el sueldo base del empleado)");
            Integer dias = lector.nextInt();
            System.out.println();
            datosNomina.add(dias);

            System.out.println("Asignaciones:");
            System.out.println("Bonos:");
            Integer bonos = lector.nextInt();
            System.out.println();
            datosNomina.add(bonos);

            System.out.println("Feriados: (se pagan al doble)");
            Integer feriados = lector.nextInt();
            System.out.println();
            datosNomina.add(feriados);

            System.out.println("Horas extra:");
            Integer hExtra = lector.nextInt();
            System.out.println();
            datosNomina.add(hExtra);

            System.out.println("Deducciones:");
            System.out.println("ISR: (en %)");
            Integer isr = lector.nextInt();
            System.out.println();
            datosNomina.add(isr);

            System.out.println("Préstamos:");
            Integer prestamos = lector.nextInt();
            System.out.println();
            datosNomina.add(prestamos);

            System.out.println("Seguro social:");
            Integer seguro = lector.nextInt();
            System.out.println();
            datosNomina.add(seguro);

            nominaEmpleados.put(num, datosNomina);

            System.out.println();
            System.out.println();
        }

        System.out.println("Estamos listos para generar los reportes.");

        /* LA LISTA DE LOS DATOS DE EMPLEADO QUEDARÁ ARREGLADA DE LA
           SIGUIENTE MANERA:

           Index        Llave
           0            Días Trabajados
           1            Bonos
           2            Feriados
           3            Horas Extra
           4            ISR
           5            Préstamos
           6            Seguro Social
           7            Total
        */

        /*
        Código de empleado: %d\nNombre: %s %s\n\nSueldo base: %d\tDías trabajados: %d\tTotal: %d\n\nAsignaciones\nBonos: %d\tFeriados: %d (Total: %d)\tHoras extra: %d (Salario/hora: %d, Total: %d)\nTotal asignaciones: %d\n\nDeducciones\nISR: %d (%d%)\tPréstamos: %d\tSeguro Social: %d\nTotal deducciones: %d\n\nSalario resultante: %d
         */


    }

    // Lo que haremos aquí será recorrer a cada empleado y generar su nómina a partir de los datos recabados anteriormente.
    private static void reciboDePago() {

        System.out.println("RECIBO DE PAGO POR EMPLEADO");
        System.out.println();
        System.out.println();
        System.out.println();

        for (Integer num: nombresEmpleados.keySet()) {

            // Instanciamos los datos de cada empleado
            List<Integer> datos = nominaEmpleados.get(num);
            double sueldoDia = sueldosEmpleados.get(num)/20;

            // Calculos previos pertinentes para el calculo de la nomina
            int dias = datos.get(0);
            double totxdias = sueldoDia*dias;
            int bonos = datos.get(1);
            int feriados = datos.get(2);
            double totferiados = feriados*sueldoDia*2;
            int horasX = datos.get(3);
            double sueldoHora = sueldoDia/10;
            double totHorasX = horasX*sueldoHora;
            double totAsigna = bonos + totferiados + totHorasX;
            double sumaPos = totxdias + bonos + totferiados + totHorasX;

            int seguro = datos.get(6);
            int prestamos = datos.get(5);
            int isr = datos.get(4);
            double totIsr = (isr/100)*(sumaPos-(seguro+prestamos));
            double totDedu = seguro + prestamos + totIsr;

            Double total = sumaPos-totDedu;
            nominaEmpleados.get(num).add(total.intValue());

            System.out.printf("Código de empleado: %d\n", num);
            System.out.printf("Nombre: %s %s\n\n", nombresEmpleados.get(num), apellidosEmpleados.get(num));
            System.out.printf("Sueldo base: %d\t\tDías trabajados: %d\t\tTotal: %f\n\n", sueldosEmpleados.get(num), dias, totxdias);
            System.out.printf("Asignaciones\n");
            System.out.printf("Bonos: %d\t\tFeriados: %d (Total: %f)\t\tHoras extra: %d (Salario/hora: %f, Total: %f)\n", bonos, feriados, totferiados, horasX, sueldoHora, totHorasX);
            System.out.printf("Total asignaciones: %f\n\n", totAsigna);
            System.out.printf("Deducciones\n");
            System.out.printf("Seguro Social: %d\t\tPréstamos: %d\t\tISR: %f (Porcentaje: %d)\n", seguro, prestamos , totIsr, isr);
            System.out.printf("Total deducciones: %f\n\n", totDedu);
            System.out.printf("Salario resultante: %f", total);

            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
        }


    }

    private static void listaNomina() {

        System.out.println("LISTA DE NÓMINA");
        System.out.println();
        System.out.println();

        for (Integer num: nombresEmpleados.keySet()) {
            System.out.println("Código de Nómina: " + num);
            System.out.println("Nombre: " + nombresEmpleados.get(num)+ " " + apellidosEmpleados.get(num));
            System.out.println("Sueldo neto: $" + nominaEmpleados.get(num).get(7));
            System.out.println();
        }

    }

    public static void enlistar() {
        System.out.println("Enlistar Empleados:");
        System.out.println("");

        for (Integer num: nombresEmpleados.keySet()) {

            System.out.printf("Número de nómina: %d\n", num);
            System.out.printf("Nombre: %s\n", nombresEmpleados.get(num));
            System.out.printf("Apellidos: %s\n", apellidosEmpleados.get(num));
            System.out.printf("Cargo: %s\n", cargosEmpleados.get(num));
            System.out.printf("Sueldo base: %d\n", sueldosEmpleados.get(num));
            System.out.printf("Fecha de ingreso: %s\n", fechasIngresoEmpleados.get(num));
            System.out.println("");
        }
    }

}