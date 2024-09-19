package IUDIGITAL;

public class Empleado {
    //crear atributos identidad,nombre,apellido,tipo empleado, telefono,correo,direccion,fechacontratacion,cargo,salario
    private String identidad;
    private String nombre;
    private String apellido;
    private String tipoEmpleado;
    private String telefono;
    private String correo;
    private String direccion;
    private String fechaContratacion;
    private String cargo;
    private double salario;

    //crear constructor
    public Empleado(String identidad, String nombre, String apellido, String tipoEmpleado, String telefono, String correo, String direccion, String fechaContratacion, String cargo, double salario) {
        this.identidad = identidad;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipoEmpleado = tipoEmpleado;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
        this.fechaContratacion = fechaContratacion;
        this.cargo = cargo;
        this.salario = salario;
    }

    //crear getters y setters
    public String getIdentidad() {
        return identidad;
    }

    public void setIdentidad(String identidad) {
        this.identidad = identidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTipoEmpleado() {
        return tipoEmpleado;
    }

    public void setTipoEmpleado(String tipoEmpleado) {
        this.tipoEmpleado = tipoEmpleado;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(String fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    //crear metodo para imprimir
    public void imprimir() {
        System.out.println("Identidad: " + identidad);
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: " + apellido);
        System.out.println("Tipo de Empleado: " + tipoEmpleado);
        System.out.println("Telefono: " + telefono);
        System.out.println("Correo: " + correo);
        System.out.println("Direccion: " + direccion);
        System.out.println("Fecha de Contratacion: " + fechaContratacion);
        System.out.println("Cargo: " + cargo);
        System.out.println("Salario: " + salario);
    }



}
