import java.util.Scanner;

public class ProgramaNomina{
  public static void main(String[] args) {
    Scanner lector = new Scanner (System.in);

    int op;
    System.out.println("¿Que quieres hacer?");
    System.out.println("1: Consulta de empleados");
    System.out.println("2: Agregar empleado");
    System.out.println("3: Modificar empleado");
    System.out.println("4: Eliminar empleado");
    System.out.println("5: Asignaciones y deducciones de empleado");
    System.out.println("6: Generar nómina");
    System.out.println("7: Generar recibos");

    op = lector.nextInt();
    while (op != 1||op != 2||op != 3||op != 4||op != 5||op != 8||op != 7) {
      System.out.println("Esa opción no es válida");
      op = lector.nextInt();
    }

    switch (op) {
      //case 1: consutla();
      case 2: agregar();
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
    Scanner lector = new Scanner (System.in);

    int numeroempleados;
    if (numeroempleados == null)
      numeroempleados = 0;
    else
      numeroempleados++;


    String[] nombreempleados = new String [numeroempleados];
    String[] apellido1empleados = new String [numeroempleados];
    String[] apellido2empleados = new String [numeroempleados];


    for (int i=0;i<numeroempleados ;i++ ) {
      System.out.println("Cómo se llama tu empleado numero "+(i+1));
      nombreempleados[i] = lector.nextLine();
      System.out.println("Primer apellido de "+(nombreempleados[i]));
      apellido1empleados[i] = lector.nextLine();
      System.out.println("Segundo apellido de "+(nombreempleados[i])+" "+(apellido1empleados[i]));
      apellido2empleados[i] = lector.nextLine();
    }
  }

}
