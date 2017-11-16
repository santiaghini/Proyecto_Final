import java.util.*;

public class ProgramaNomina{
    private static Scanner lector;
    private static Map<Integer, String> nombresEmpleados = new HashMap<Integer, String>();
    private static Map<Integer, String> apellidosEmpleados = new HashMap<Integer, String>();
    private static Map<Integer, String> cargosEmpleados = new HashMap<Integer, String>();
    private static Map<Integer, Integer> sueldosEmpleados = new HashMap<Integer, Integer>();
    private static Map<Integer, String> fechasIngresoEmpleados = new HashMap<Integer, String>();

      //ESCRIBIR ARCHIVO
      //LEER ARCHIVO



  public static void main(String[] args) {
    lector = new Scanner (System.in);
    int op;
    String answer = "s";

      System.out.println("Bienvenido al sistema de manejo de nómina PERSEUS");

    // Este while permite que puedas repetir diferentes consultas hasta que el usuario decida terminar el programa
    while (answer.equals("s")){

      System.out.println("¿Qué quieres hacer?");
      System.out.println("1: Consulta de empleados");
      System.out.println("2: Agregar empleado");
      System.out.println("3: Modificar empleado");
      System.out.println("4: Eliminar empleado");
      System.out.println("5: Asignaciones y deducciones de empleado");
      System.out.println("6: Generar nómina");
      System.out.println("7: Generar recibos");
      System.out.println("8: Enlistar empleados");

      op = lector.nextInt();

      while ((op <= 0) || (op >= 9)) {
        System.out.println("Esa opción no es válida, por favor escribe un número en el rango.");
        op = lector.nextInt();
      }

      switch (op) {
        case 1: consulta();
                break;
        case 2: agregar();
                break;
        case 3: modificar();
                break;
        case 4: eliminar();
                break;
       // case 5: asigdeduc();
         //       break;
       // case 6: genNom();
            //    break;
       // case 7: genRec();
          //      break;
        case 8: enlistar();
                break;
      }

      System.out.println("¿Quieres realizar otra consulta?");
      System.out.println("s/n");
      answer = lector.nextLine();
      System.out.println();

    }

    //System.out.println("Si generaste recibos, las nóminas de tus empleados se guardaron");
    //System.out.println("Gracias por usar PERSEUS");
  }

  public static void consulta(){

      String a = "s";

      while(a.equals("s")) {

          System.out.println("Consulta un empleado");

          System.out.println("Número de nómina: ");
          Integer num = lector.nextInt();

          boolean b = nombresEmpleados.containsKey(num);
          while (!b){
              System.out.println("Ese empleado no existe en la base, pruebe de nuevo.");
              System.out.println("Número de nómina: ");
              num = lector.nextInt();
              b = nombresEmpleados.containsKey(num);
          }

          System.out.printf("Los datos existentes para el empleado con número de nómina %d son: \n" , num);

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

  public static void agregar(){

      String a = "s";

      while(a.equals("s")) {

          System.out.println("Agregar un nuevo empleado");

          System.out.println("Número de nómina: ");
          Integer num = lector.nextInt();

          boolean b = nombresEmpleados.containsKey(num);
          while (b){
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

          nombresEmpleados.put(num , nombre);
          apellidosEmpleados.put(num, apellidos);
          cargosEmpleados.put(num, cargo);
          sueldosEmpleados.put(num, sueldo);
          fechasIngresoEmpleados.put(num, fechaIngreso);

          System.out.printf("El empleado %s %s con número de nómina %d ha sido agregado a la base exitosamente. \n" , nombre, apellidos , num);
          System.out.println("");

          System.out.println("¿Quieres agregar otro empleado?");
          System.out.println("s/n");
          a = lector.nextLine();
          System.out.println();

      }
  }

    public static void modificar(){

        String a = "s";

        while(a.equals("s")) {


            System.out.println("Modificar empleado");

            System.out.println("Escribe el número de nómina:");
            Integer num = lector.nextInt();

            boolean b = nombresEmpleados.containsKey(num);
            while (!b){
                System.out.println("Ese empleado no existe en la base, pruebe de nuevo.");
                System.out.println("Número de nómina: ");
                num = lector.nextInt();
                b = nombresEmpleados.containsKey(num);
            }

            System.out.printf("Los datos existentes para el empleado con número de nómina %d son: \n" , num);

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
                case 1: System.out.println("Escribe el nuevo nombre:");
                        lector.nextLine();
                        String nombre = lector.nextLine();
                        nombresEmpleados.put(num , nombre);
                    break;
                case 2: System.out.println("Escribe los nuevos apellidos:");
                        String apellidos = lector.nextLine();
                        apellidosEmpleados.put(num , apellidos);
                    break;
                case 3: System.out.println("Escribe el cargo:");
                        String cargo = lector.nextLine();
                        cargosEmpleados.put(num , cargo);
                    break;
                case 4: System.out.println("Escribe el sueldo base:");
                        Integer sueldo = lector.nextInt();
                        lector.nextLine();
                        sueldosEmpleados.put(num , sueldo);
                    break;
                case 5: System.out.println("Escribe la nueva fecha de ingreso: (formato: día/mes/año)");
                        String fecha = lector.nextLine();
                        fechasIngresoEmpleados.put(num , fecha);
                    break;
            }


            System.out.println("¿Quieres modificar los datos de otro empleado?");
            System.out.println("s/n");
            lector.nextLine();
            a = lector.nextLine();
            System.out.println();

        }
    }

    public static void eliminar(){

        String a = "s";

        while(a.equals("s")) {


            System.out.println("Eliminar empleado");

            System.out.println("Escribe el número de nómina:");
            Integer num = lector.nextInt();

            boolean b = nombresEmpleados.containsKey(num);
            while (!b){
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

            System.out.printf("El empleado %s %s con número de nómina %d ha sido eliminado de la base exitosamente.\n" , nombre, apellidos , num);
            System.out.println("");

            System.out.println("¿Quieres eliminar otro empleado?");
            System.out.println("s/n");
            lector.nextLine();
            a = lector.nextLine();
            System.out.println();

        }
    }

    /*public static _ asigDeduc(){

    }

    public static __ genNom(){

    }

    public static __ genRec(){

    }*/

    public static void enlistar(){
        System.out.println("Enlistar Empleados:");
        System.out.println("");

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
