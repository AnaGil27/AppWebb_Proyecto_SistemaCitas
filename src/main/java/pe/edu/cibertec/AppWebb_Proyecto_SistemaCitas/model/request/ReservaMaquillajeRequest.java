package pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.request;

import lombok.Data;

@Data
public class ReservaMaquillajeRequest {
    private Integer id_reserva_maquillaje;
    private Integer idusuario;
    private Integer id_lugar;
    private Integer id_empleado;
    private Integer idmaquillaje;
    private String fechaP;
}
