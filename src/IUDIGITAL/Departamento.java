package IUDIGITAL;

public class Departamento {
   //crear atributos id,nombredepartamento,jefe,listaempleados,descripcion,gerente
    private int id;
    private String nombreDepartamento;
    private String jefe;
    private String listaEmpleados;
    private String descripcion;
    private String gerente;

    //crear constructor
    public Departamento(int id, String nombreDepartamento, String jefe, String listaEmpleados, String descripcion, String gerente) {
        this.id = id;
        this.nombreDepartamento = nombreDepartamento;
        this.jefe = jefe;
        this.listaEmpleados = listaEmpleados;
        this.descripcion = descripcion;
        this.gerente = gerente;
    }

    //crear getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreDepartamento() {
        return nombreDepartamento;
    }

    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }

    public String getJefe() {
        return jefe;
    }

    public void setJefe(String jefe) {
        this.jefe = jefe;
    }

    public String getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(String listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getGerente() {
        return gerente;
    }

    public void setGerente(String gerente) {
        this.gerente = gerente;
    }

    //crear metodo para imprimir
    public void imprimir() {
        System.out.println("ID: " + id);
        System.out.println("Nombre del Departamento: " + nombreDepartamento);
        System.out.println("Jefe: " + jefe);
        System.out.println("Lista de Empleados: " + listaEmpleados);
        System.out.println("Descripcion: " + descripcion);
        System.out.println("Gerente: " + gerente);
    }
}
