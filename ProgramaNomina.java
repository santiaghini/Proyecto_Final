import java.util.*;

public class ProgramaNomina{
    private static Scanner lector;
    private static Map<Integer, String> nombresEmpleados = new HashMap<Integer, String>();
    private static Map<Integer, String> apellidosEmpleados = new HashMap<Integer, String>();
    private static Map<Integer, String> cargosEmpleados = new HashMap<Integer, String>();
    private static Map<Integer, Integer> sueldosEmpleados = new HashMap<Integer, Integer>();
    private static Map<Integer, String> fechasIngresoEmpleados = new HashMap<Integer, String>();




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

      op = lector.nextInt();

      while ((op <= 0) || (op >= 8)) {
        System.out.println("Esa opción no es válida, por favor escribe un número en el rango.");
        op = lector.nextInt();
      }

      switch (op) {
        //case 1: consulta();
        case 2: agregar();
                break;
        case 4: eliminar();
                break;
      }

      System.out.println("¿Quieres realizar otra consulta?");
      System.out.println("s/n");
      lector.nextLine();
        System.out.println();

      answer = lector.nextLine();


    }

  }

  /*public static void consulta(){

    int numeroempleados = numeroempleados.agregar
    //no se como llamar a una variable aqui
    if (numempleados == 0)
      System.out.println("No ha agragado ningún empleado");
  }
*/
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

    public static void eliminar(){

        String a = "s";

        while(a.equals("s")) {


            System.out.println("Eliminar empleado");

            System.out.println("Escribe el número de nómina:");
            Integer num = lector.nextInt();

            boolean b = nombresEmpleados.containsKey(num);
            while (!b){
                System.out.println("Ese empleado ya no existe en la base, pruebe de nuevo.");
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

}
