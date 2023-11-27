package pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.request;
import lombok.Data;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.bd.Lugar;

@Data
public class EmpleadoRequest {
    private Integer IdEmpleado;
    private String nom_empleado;
    private String ape_empleado;
    private String celular_empleado;
    private Integer id_lugar;
}
