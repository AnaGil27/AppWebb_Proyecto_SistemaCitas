package pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.request;

import lombok.Data;

@Data
public class ManicuraRequest {
    private Integer id_manicura;
    private String desc_manicura;
    private String precio_manicura;
    private String tiempo_manicura;
    private Integer id_desc_manicura;
}
