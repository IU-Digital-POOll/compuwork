package IUdigital2;

public class ReporteDesempenio {
    //crear atributos id,empleados,fechareporte,puntajedesempenio,comentario,departamento
    private long id;
    private String empleados;
    private String fechaReporte;
    private int puntajeDesempenio;
    private String comentario;
    private String departamento;

    //crear constructor
    public ReporteDesempenio(long id, String empleados, String fechaReporte, int puntajeDesempenio, String comentario, String departamento) {
        this.id = id;
        this.empleados = empleados;
        this.fechaReporte = fechaReporte;
        this.puntajeDesempenio = puntajeDesempenio;
        this.comentario = comentario;
        this.departamento = departamento;
    }

    //crear getters y setters
    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmpleados() {
        return empleados;
    }

    public void setEmpleados(String empleados) {
        this.empleados = empleados;
    }

    public String getFechaReporte() {
        return fechaReporte;
    }

    public void setFechaReporte(String fechaReporte) {
        this.fechaReporte = fechaReporte;
    }

    public int getPuntajeDesempenio() {
        return puntajeDesempenio;
    }

    public void setPuntajeDesempenio(int puntajeDesempenio) {
        this.puntajeDesempenio = puntajeDesempenio;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    //crear metodo para imprimir
    public void imprimir() {
        System.out.println("ID: " + id);
        System.out.println("Empleados: " + empleados);
        System.out.println("Fecha de Reporte: " + fechaReporte);
        System.out.println("Puntaje de Desempeño: " + puntajeDesempenio);
        System.out.println("Comentario: " + comentario);
        System.out.println("Departamento: " + departamento);
    }



}