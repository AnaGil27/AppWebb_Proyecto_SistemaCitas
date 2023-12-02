package pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.request;

import lombok.Data;

@Data
public class ReservaManicuraRequest {
    private Integer id_reserva_manicura;
    private Integer idusuario;
    private Integer id_lugar;
    private Integer id_empleado;
    private Integer idmanicura;
    private String fechaM;
}