package pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.bd.*;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.request.ReservaRequest;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.request.ServicioRequest;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.response.ResultadoResponse;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.repository.ServicioRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class ServicioService {
    private ServicioRepository servicioRepository;
    public List<Servicio> listarServicio(){
        return servicioRepository.findAll();
    }

    public ResultadoResponse guardarServicio(ServicioRequest servicio) {
        String mensaje = "Servicio registrado correctamente";
        Boolean respuesta = true;
        try {
            Servicio objServicio = new Servicio();
            if (servicio.getIdServicios() > 0) {
                objServicio.setIdServicios(servicio.getIdServicios());
            }

            Manicura manicura = new Manicura();
            manicura.setId_manicura(servicio.getId_manicura());
            objServicio.setManicura(manicura);

            Peinado peinado = new Peinado();
            peinado.setId_peinado(servicio.getId_peinado());
            objServicio.setPeinado(peinado);

            Masaje masaje = new Masaje();
            masaje.setId_masaje(servicio.getId_masaje());
            objServicio.setMasaje(masaje);

            Maquillaje maquillaje = new Maquillaje();
            maquillaje.setId_maquillaje(servicio.getId_maquillaje());
            objServicio.setMaquillaje(maquillaje);

            servicioRepository.save(objServicio);
        }catch (Exception ex){
            mensaje = "Servicio no registradp";
            respuesta = false;
        }
        return ResultadoResponse.builder().mensaje(mensaje).respuesta(respuesta).build();
    }
}
