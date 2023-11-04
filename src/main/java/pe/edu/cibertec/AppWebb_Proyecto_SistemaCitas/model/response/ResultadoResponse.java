package pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResultadoResponse {
    private boolean respuesta;
    private String mensaje;
}
