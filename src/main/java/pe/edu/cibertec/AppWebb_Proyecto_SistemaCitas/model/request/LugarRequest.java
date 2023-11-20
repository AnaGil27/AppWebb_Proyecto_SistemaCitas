package pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.request;

import lombok.Data;

@Data
public class LugarRequest {
    private Integer IdLugar;
    private String Ciudad;
    private String Distrito;
}
