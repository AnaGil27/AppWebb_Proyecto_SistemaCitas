package pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.request;

import lombok.Data;

import java.util.Date;

@Data
public class ReservaRequest {

    private Integer IdReserva;
    private Integer idusuario;
    private Integer id_manicura;
    private Integer id_peinado;
    private Integer id_masaje;
    private Integer id_maquillaje;
    private Integer IdEmpleado;
    private Integer IdLugar;
    private String FechaReserva;
}
