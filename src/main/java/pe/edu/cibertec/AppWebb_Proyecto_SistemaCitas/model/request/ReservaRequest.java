package pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.request;

import lombok.Data;

import java.util.Date;

@Data
public class ReservaRequest {

    private Integer id_reserva;
    private Integer idusuario;
    private Integer IdServicios;
    private Integer id_empleado;
    private Integer id_lugar;
    private String fecha_reserva;
}
