package pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.request;

import lombok.Data;

@Data
public class ReservaPeinadoRequest {

    private Integer id_reservaPeinado;
    private Integer idusuario;
    private Integer id_lugar;
    private Integer id_empleado;
    private Integer id_peinado;
    private String fechaP;
}
