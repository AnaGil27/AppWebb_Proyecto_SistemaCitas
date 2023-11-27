package pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.request;

import lombok.Data;

@Data
public class ServicioRequest {
    private Integer IdServicios;
    private Integer id_manicura;
    private Integer id_peinado;
    private Integer id_masaje;
    private Integer id_maquillaje;

}
