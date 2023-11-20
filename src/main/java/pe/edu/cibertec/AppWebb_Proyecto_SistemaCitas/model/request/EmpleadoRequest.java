package pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.request;
import lombok.Data;

@Data
public class EmpleadoRequest {
    private Integer IdEmpleado;
    private String NomEmpleado;
    private String ApeEmpleado;
    private String CelularEmpleado;
}
