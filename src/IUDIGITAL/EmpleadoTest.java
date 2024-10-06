import IUDIGITAL.Empleado;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmpleadoTest {

    private Empleado empleado;

    @BeforeEach
    public void setUp() {
        empleado = new Empleado(123456789, "Juan", "Perez", "Full-Time", 987654321, "juan.perez@example.com", "123 Main St", "2023-01-01", "Developer", 50000.0);
    }

    @Test
    public void testGetIdentidad() {
        assertEquals(123456789, empleado.getIdentidad());
    }

    @Test
    public void testGetNombre() {
        assertEquals("Juan", empleado.getNombre());
    }

    @Test
    public void testGetApellido() {
        assertEquals("Perez", empleado.getApellido());
    }

    @Test
    public void testGetTipoEmpleado() {
        assertEquals("Full-Time", empleado.getTipoEmpleado());
    }

    @Test
    public void testGetTelefono() {
        assertEquals(987654321, empleado.getTelefono());
    }

    @Test
    public void testGetCorreo() {
        assertEquals("juan.perez@example.com", empleado.getCorreo());
    }

    @Test
    public void testGetDireccion() {
        assertEquals("123 Main St", empleado.getDireccion());
    }

    @Test
    public void testGetFechaContratacion() {
        assertEquals("2023-01-01", empleado.getFechaContratacion());
    }

    @Test
    public void testGetCargo() {
        assertEquals("Developer", empleado.getCargo());
    }

    @Test
    public void testGetSalario() {
        assertEquals(50000.0, empleado.getSalario());
    }

    @Test
    public void testSetNombre() {
        empleado.setNombre("Carlos");
        assertEquals("Carlos", empleado.getNombre());
    }

    // Agregar más pruebas para otros setters si es necesario
}