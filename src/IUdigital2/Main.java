package IUdigital2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Crear un objeto de la clase empleado por teclado
            System.out.println("Ingrese la identidad del empleado: ");
            long identidad = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Ingrese el nombre del empleado: ");
            String nombre = scanner.nextLine();
            System.out.println("Ingrese el apellido del empleado: ");
            String apellido = scanner.nextLine();
            System.out.println("Ingrese el tipo de empleado temporal o permanente: ");
            String tipoEmpleado = scanner.nextLine();
            System.out.println("Ingrese el telefono del empleado: \n ");
            long telefono = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Ingrese el correo del empleado: ");
            String correo = scanner.nextLine();
            System.out.println("Ingrese la direccion del empleado: ");
            String direccion = scanner.nextLine();
            System.out.println("Ingrese la fecha de contratacion del empleado: ");
            String fechaContratacion = scanner.nextLine();
            System.out.println("Ingrese el cargo del empleado: ");
            String cargo = scanner.nextLine();
            System.out.println("Ingrese el salario del empleado: ");
            double salario = scanner.nextDouble();
            scanner.nextLine();
            Empleado empleado = new Empleado(identidad, nombre, apellido, tipoEmpleado, telefono, correo, direccion, fechaContratacion, cargo, salario);

            // Crear un objeto de la clase departamento por teclado
            System.out.println("Ingrese el id del departamento: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Ingrese el nombre del departamento: ");
            String nombreDepartamento = scanner.nextLine();
            System.out.println("Ingrese el jefe del departamento: ");
            String jefe = scanner.nextLine();
            System.out.println("Ingrese la lista de empleados del departamento: ");
            String listaEmpleados = scanner.nextLine();
            System.out.println("Ingrese la descripcion del departamento: ");
            String descripcion = scanner.nextLine();
            System.out.println("Ingrese el gerente del departamento: ");
            String gerente = scanner.nextLine();
            Departamento departamento = new Departamento(id, nombreDepartamento, jefe, listaEmpleados, descripcion, gerente);

            // Crear un objeto de la clase reporte de desempenio por teclado
            System.out.println("Ingrese el id del reporte de desempenio: ");
            int idReporte = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Ingrese los empleados del reporte de desempenio: ");
            String empleados = scanner.nextLine();
            System.out.println("Ingrese la fecha del reporte de desempenio: ");
            String fechaReporte = scanner.nextLine();
            System.out.println("Ingrese el puntaje de desempenio: ");
            int puntajeDesempenio = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Ingrese el comentario del reporte de desempenio: ");
            String comentario = scanner.nextLine();
            System.out.println("Ingrese el departamento del reporte de desempenio: ");
            String departamentoReporte = scanner.nextLine();
            ReporteDesempenio reporteDesempenio = new ReporteDesempenio(idReporte, empleados, fechaReporte, puntajeDesempenio, comentario, departamentoReporte);

            // Imprimir los objetos
            empleado.imprimir();
            departamento.imprimir();
            reporteDesempenio.imprimir();

            // Asignación de empleado a departamento
            System.out.println("Desea asignar un empleado a un departamento? (s/n)");
            String respuesta = scanner.nextLine();
            if (respuesta.equals("s")) {
                try {
                    System.out.println("Ingrese el id del departamento: ");
                    id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Ingrese el nombre del departamento: ");
                    nombreDepartamento = scanner.nextLine();
                    System.out.println("Ingrese el jefe del departamento: ");
                    jefe = scanner.nextLine();
                    System.out.println("Ingrese la lista de empleados del departamento: ");
                    listaEmpleados = scanner.nextLine();
                    System.out.println("Ingrese la descripcion del departamento: ");
                    descripcion = scanner.nextLine();
                    System.out.println("Ingrese el gerente del departamento: ");
                    gerente = scanner.nextLine();
                    departamento = new Departamento(id, nombreDepartamento, jefe, listaEmpleados, descripcion, gerente);
                    System.out.println("Ingrese la identidad del empleado: ");
                    identidad = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Ingrese el nombre del empleado: ");
                    nombre = scanner.nextLine();
                    System.out.println("Ingrese el apellido del empleado: ");
                    apellido = scanner.nextLine();
                    System.out.println("Ingrese el tipo de empleado permanente o temporal: ");
                    tipoEmpleado = scanner.nextLine();
                    System.out.println("Ingrese el telefono del empleado: ");
                    telefono = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Ingrese el correo del empleado: ");
                    correo = scanner.nextLine();
                    System.out.println("Ingrese la direccion del empleado: ");
                    direccion = scanner.nextLine();
                    System.out.println("Ingrese la fecha de contratacion del empleado: ");
                    fechaContratacion = scanner.nextLine();
                    System.out.println("Ingrese el cargo del empleado: ");
                    cargo = scanner.nextLine();
                    System.out.println("Ingrese el salario del empleado: ");
                    salario = scanner.nextDouble();
                    scanner.nextLine();
                    empleado = new Empleado(identidad, nombre, apellido, tipoEmpleado, telefono, correo, direccion, fechaContratacion, cargo, salario);
                    empleado.imprimir();
                    System.out.println("Empleado asignado al departamento");
                } catch (Exception e) {
                    System.out.println("Error al asignar empleado al departamento: " + e.getMessage());
                }
            }

            // Generar reporte de desempenio
            System.out.println("Desea generar un reporte de desempenio? (s/n)");
            respuesta = scanner.nextLine();
            if (respuesta.equals("s")) {
                try {
                    System.out.println("Ingrese el id del reporte de desempenio: ");
                    idReporte = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Ingrese los empleados del reporte de desempenio: ");
                    empleados = scanner.nextLine();
                    System.out.println("Ingrese la fecha del reporte de desempenio: ");
                    fechaReporte = scanner.nextLine();
                    System.out.println("Ingrese el puntaje de desempenio: ");
                    puntajeDesempenio = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Ingrese el comentario del reporte de desempenio: ");
                    comentario = scanner.nextLine();
                    System.out.println("Ingrese el departamento del reporte de desempenio: ");
                    departamentoReporte = scanner.nextLine();
                    reporteDesempenio = new ReporteDesempenio(idReporte, empleados, fechaReporte, puntajeDesempenio, comentario, departamentoReporte);
                    reporteDesempenio.imprimir();
                } catch (Exception e) {
                    System.out.println("Error al generar el reporte de desempenio: " + e.getMessage());
                }
            }

        } catch (Exception e) {
            System.out.println("Error en la entrada de datos: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}