package pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.service;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.bd.DescPeinado;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.bd.Peinado;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.request.PeinadoRequest;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.response.ResultadoResponse;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.repository.PeinadoRepository;

import java.util.List;
@AllArgsConstructor
@Service
public class PeinadoService {

    private PeinadoRepository peinadoRepository;


    public List<Peinado> listarPeinado() {
        return peinadoRepository.findAll();
    }

    public ResultadoResponse guardarPeinado(PeinadoRequest peinado) {
        String mensaje = "Peinado registrado correctamente";
        Boolean respuesta = true;
        try {
            Peinado objPeinado = new Peinado();
            if (peinado.getIdpeinado() > 0) {
                objPeinado.setIdpeinado(peinado.getIdpeinado());
            }
            objPeinado.setPreciopeinado(peinado.getPreciopeinado());
            objPeinado.setTiempopeinado(peinado.getTiempopeinado());
            objPeinado.setDescripcion(peinado.getDescripcion());

            DescPeinado descPeinado = new DescPeinado();
            descPeinado.setIddescpeinado(peinado.getIddescpeinado());
            objPeinado.setDescpeinado(descPeinado);


            peinadoRepository.save(objPeinado);
        }catch (Exception ex){
            mensaje = "Peinado no registrado";
            respuesta = false;
        }
        return ResultadoResponse.builder().mensaje(mensaje).respuesta(respuesta).build();
    }
}