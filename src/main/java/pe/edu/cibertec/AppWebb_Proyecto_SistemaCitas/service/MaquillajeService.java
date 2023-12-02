package pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.bd.DescMaquillaje;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.bd.Maquillaje;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.request.MaquillajeRequest;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.response.ResultadoResponse;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.repository.MaquillajeRepository;

import java.util.List;
@AllArgsConstructor
@Service
public class MaquillajeService {
    private MaquillajeRepository maquillajeRepository;
    public List<Maquillaje> listarMaquillaje(){return maquillajeRepository.findAll(); }

    public ResultadoResponse guardarMaquillaje(MaquillajeRequest maquillaje){
        String mensaje = "Maquillaje registrado correctamente";
        Boolean respuesta = true;
        try {
            Maquillaje objMaquillaje = new Maquillaje();
            if (maquillaje.getIdmaquillaje() > 0) {
                objMaquillaje.setIdmaquillaje(maquillaje.getIdmaquillaje());
            }
            objMaquillaje.setPreciomaquillaje(maquillaje.getPreciomaquillaje());
            objMaquillaje.setTiempomaquillaje(maquillaje.getTiempomaquillaje());
            objMaquillaje.setDescripcion(maquillaje.getDescripcion());

            DescMaquillaje descMaquillaje = new DescMaquillaje();
            descMaquillaje.setIddescmaquillaje(maquillaje.getIddescmaquillaje());
            objMaquillaje.setDescmaquillaje(descMaquillaje);


            maquillajeRepository.save(objMaquillaje);
        }catch (Exception ex){
            mensaje = "Maquillaje no registrado";
            respuesta = false;
        }
        return ResultadoResponse.builder().mensaje(mensaje).respuesta(respuesta).build();
    }
}
