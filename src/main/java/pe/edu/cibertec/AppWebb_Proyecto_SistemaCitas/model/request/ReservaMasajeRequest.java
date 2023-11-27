package pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.request;
import lombok.Data;

@Data
public class ReservaMasajeRequest {
    private Integer id_reserva_masaje;
    private Integer idusuario;
    private Integer id_lugar;
    private Integer id_empleado;
    private Integer id_masaje;
    private String fechaJ;
}
